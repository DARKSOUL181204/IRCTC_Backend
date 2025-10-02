package Ticket.Booking.services;

import Ticket.Booking.entities.Train;
import Ticket.Booking.entities.User;
import Ticket.Booking.util.UserServiceUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;


public class UserBookingService {
    User user;
    private List<User> userList;

    private final ObjectMapper objectMapper = new ObjectMapper();
//    private static final String USERS_PATH = "../app/src/main/resources/localDb/user.json";
private static final String USERS_PATH = "/Users/chetan/Java Projects /Java_Backend/app/src/main/java/Ticket/Booking/Localdb/user.json";

    // for login purpose
    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsers();
    }

    // general constructor for initialization
//    public UserBookingService() throws IOException {
//        loadUsers();
//
//    }
    public UserBookingService() throws IOException {
        File usersFile = new File(USERS_PATH);

        // If file exists, read the users
        if (usersFile.exists()) {
            userList = objectMapper.readValue(usersFile, new TypeReference<List<User>>() {});
        } else {
            userList = new ArrayList<>(); // initialize empty list if file doesn't exist
        }
    }

    public List<User> loadUsers() throws IOException {
        File users = new File(USERS_PATH);
        return objectMapper.readValue(users, new TypeReference<List<User>>() {
        });

    }

    // login
    public boolean loginUser() {
        Optional<User> findUser = userList.stream().filter(user1 -> {
            return user1.getUserName().equalsIgnoreCase(user.getUserName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return findUser.isPresent();
    }

    // signup
//    public Boolean signup(User user1) {
//        try {
//            userList.add(user1);
//            saveUserListToFile();
//            return Boolean.TRUE;
//        } catch (IOException ex) {
//            return Boolean.FALSE;
//        }
//    }
    public Boolean signup(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            System.out.println("User saved successfully!");
            return Boolean.TRUE;
        } catch (IOException ex) {
            System.out.println("Error saving user: " + ex.getMessage());
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        File parentDir = usersFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();  // create the directory if it doesn't exist
        }
        objectMapper.writeValue(usersFile, userList);
    }
//    private void saveUserListToFile() throws IOException {
//        File usersFile = new File(USERS_PATH);
//        objectMapper.writeValue(usersFile, userList);
//    }
// Object(user) ---> json (serialize)
// json         ---> Object(user)  (deserialize)


    public void fetchBooking() {
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId) {
        if (userList.contains(user)) {
            boolean removed = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
            if (removed) {
                try {
                    saveUserListToFile(); // persist updated userList to file
                } catch (IOException e) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public List<Train> getTrain(String Source, String Destination) throws IOException {
        TrainService trainService = new TrainService();
        return trainService.searchTrains(Source, Destination);
    }

    public List<List<Integer>> fetchSeats(Train trainSelectedForBooking) {
        return trainSelectedForBooking.getSeats();
    }


    public boolean bookTrainSeat(Train trainSelectedForBooking, int row, int col) {
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> availableSeats = fetchSeats(trainSelectedForBooking);

            if (row < 0 || row >= availableSeats.size() ||
                    col < 0 || col >= availableSeats.get(row).size()) {
                System.out.println("Invalid seat position");
                return false;
            }


            if (availableSeats.get(row).get(col) == 1) {
                System.out.println("Seat already booked.");
                return false;
            }


            availableSeats.get(row).set(col, 1);
            trainSelectedForBooking.setSeats(availableSeats);
            trainService.updateTrain(trainSelectedForBooking);

            System.out.println("Your seat has been booked!");
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Error while booking seat", e);
        }

    }

}


//    public boolean bookTrainSeat(Train trainSelectedForBooking, int row, int col) {
//        try {
//            TrainService trainService = new TrainService();
//            List<List<Integer>> avilableSeats =  fetchSeats(trainSelectedForBooking);
//            if(avilableSeats.get(row).get(col) == 0){
//                avilableSeats.get(row).set(col,1);
//                trainSelectedForBooking.setSeats(avilableSeats);
//                trainService.addTrain(trainSelectedForBooking);
//                System.out.println("Your Seat is set");
//                return Boolean.TRUE;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return Boolean.FALSE;
//    }
//
//
//}