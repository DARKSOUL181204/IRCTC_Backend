package Ticket.Booking.entities;

import java.util.*;


public class Train {
    private String trainId;
    private String trainNo;
    private Map<String, String> stationTimes;
    private List<String> stations;
    List<List<Integer>> seats;


    public Train() {
    }

    public Train(
            String trainId,
            String trainNo,
            Map<String, String> stationTimes,
            List<String> stations,
            List<List<Integer>> seats
    ) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.stationTimes = stationTimes;
        this.stations = stations;
        this.seats = seats;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public List<String> getStation() {
        return stations;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public Map<String, String> getStationTimes() {
        return stationTimes;
    }

//    public List<Train> getTrains(String Source, String Destination) {
//        List<Train> availableTrains;
//        if (stations.contains(Source) && stations.contains(Destination)) {
//            if (stations.indexOf(Source) < stations.indexOf(Destination)){
//                availableTrains.add();
//            }
//        }
//    }


    // set
    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }


    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String getTrainInfo() {
        return String.format("Train Id : %s and Train Number: %s ", trainId, trainNo);
    }
}
