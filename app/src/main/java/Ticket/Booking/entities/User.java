package Ticket.Booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("hashedPassword")
    private String hashedPassword;

    @JsonProperty("password")
    private String password;

    @JsonProperty("ticketsBooked")
    private List<Ticket> ticketsBooked;

    // Default constructor
    public User() {}

    // Full constructor
    public User(String userId, String userName, String password, String hashedPassword, List<Ticket> ticketsBooked) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = ticketsBooked;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getHashedPassword() { return hashedPassword; }
    public List<Ticket> getTicketsBooked() { return ticketsBooked; }

    // Setters
    public void setUserId(String userId) { this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }
    public void setTicketsBooked(List<Ticket> ticketsBooked) { this.ticketsBooked = ticketsBooked; }

    // Utility
    public void printTickets() {
        if (ticketsBooked != null) {
            for (Ticket t : ticketsBooked) {
                System.out.println(t.getTicketInfo());
            }
        }
    }
}







//package Ticket.Booking.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.databind.PropertyNamingStrategy;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//
//import java.util.List;
//
//
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class User {
//    private String userId;
//    private String userName;
//    private String hashedPassword;
//    private String password;
//    private List<Ticket> ticketsBooked;
//
//        // build a constructor to take values of all the pairs
//    public User(String userId,
//                String userName,
//                String password,
//                String hashedPassword,
//                List<Ticket> ticketsBooked) {
//        this.userId = userId;
//        this.userName = userName;
//        this.hashedPassword = hashedPassword;
//        this.password = password;
//        this.ticketsBooked = ticketsBooked;
//
//    }
//
//
//    public String getName() {
//        return this.userName;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public String getUserId() {
//        return this.userId;
//    }
//
//    // default constructor
//    public User() {
//    }
//
//
//    // getHashedPassword
//    public String getHashedPassword() {
//        return this.hashedPassword;
//    }
//
//
//    // get Tickets
//    public List<Ticket> getTicket() {
//        return this.ticketsBooked;
//    }
//
//    // print Tickets
//    public void printTickets() {
//        for (int i = 0; i < ticketsBooked.size(); i++) {
//            System.out.println(ticketsBooked.get(i).getTicketInfo());
//        }
//    }
//
////set all the values
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setName(String name) {
//        this.userName = name;
//    }
//
//    public void setUserID(String UserId) {
//        this.userId = userId;
//    }
//
//    public void setTicketBooked(List<Ticket> TicketsBooked) {
//        this.ticketsBooked = ticketsBooked;
//    }
//
//
//}
