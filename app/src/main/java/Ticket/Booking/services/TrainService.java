package Ticket.Booking.services;

import Ticket.Booking.entities.Train;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {

    private static final String  TRAINS_PATH = "app/src/main/resources/localDb/Train.json";
    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Train> searchTrains(String Source, String Destination) {
        return trainList.stream().filter(train1 -> train1.getStation().contains(Source) && train1.getStation().contains(Destination))
                .filter(train1 -> train1.getStation().indexOf(Source) < train1.getStation().indexOf(Destination))
                .collect(Collectors.toList());
    }


    private void saveTrainListToFile() throws  IOException {
        File trainsFile = new File(TRAINS_PATH);
        objectMapper.writeValue(trainsFile, trainList);  // trainList = all trains
    }

    public void addTrain(Train train) throws IOException {
        Optional<Train> existingTrain = trainList.stream().filter(train1-> {
           return  train1.getTrainId().equalsIgnoreCase(train.getTrainId());
        }).findFirst();
        if(existingTrain.isPresent()){
            //update previous data of train
            updateTrain(train);
        }else{
            // add as new train in the list
            trainList.add(train);
            saveTrainListToFile();
        }

    }
    public void updateTrain(Train updatedTrain) throws IOException {
        OptionalInt index = IntStream.range(0, trainList.size())
                .filter(i -> trainList.get(i).getTrainId().equalsIgnoreCase(updatedTrain.getTrainId()))
                .findFirst();
        if (index.isPresent()) {
            trainList.set(index.getAsInt(), updatedTrain);
            saveTrainListToFile();
        } else {
            addTrain(updatedTrain);
        }
    }


}




// normal methard using loops
//    public List<Train> searchTrains(String Source, String Destination) {
//        List<Train> availableTrain = new ArrayList<>();
//        for (Train train : trainList) {
//            if (train.getStation().contains(Source) && train.getStation().contains(Destination)) {
//                if (train.getStation().indexOf(Source) < train.getStation().indexOf(Destination)) {
//                    availableTrain.add(train);
//                }
//            }
//        }
//        return availableTrain;
//    }