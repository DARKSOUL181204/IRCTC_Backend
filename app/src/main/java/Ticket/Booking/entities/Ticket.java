package Ticket.Booking.entities;

import java.util.Date;

public class Ticket {
    private String TicketId;
    private User user;
    private String Source;
    private String Destination;
    private String dateTravel;
    private Train TrainNo;

    public Ticket() {
    }

    public Ticket(String TicketId,
                  User user,
                  String Source,
                  String Destination,
                  String  dateTravel,
                  Train TrainNo) {
        this.TicketId = TicketId;
        this.user = user;
        this.Source = Source;
        this.Destination = Destination;
        this.dateTravel = dateTravel;
        this.TrainNo = TrainNo;

    }

    public String getTicketInfo(){
        return String.format("Ticket Id : %s belong to : %s form : %s to : %s ",TicketId,user,Source,Destination);
    }



    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }


    public String getSource(){
        return Source;
    }
    public void setSource(String Source){
        this.Source = Source;
    }


    public String getDestination(){
        return Destination;
    }
    public void setDestination(String Destination){
        this.Destination = Destination;
    }

    public String getTicketId(){
        return TicketId;
    }
    public void setTicketId(String TicketId){
        this.TicketId = TicketId;
    }

    public String getDateTravel(){
        return dateTravel;
    }
    public void setDateTravel(String dateTravel){
        this.dateTravel = dateTravel;
    }



    public Train getTrainNo() {
        return TrainNo;
    }
    public void setTrainNo(Train TrainNo) {
        this.TrainNo = TrainNo;
    }





}
