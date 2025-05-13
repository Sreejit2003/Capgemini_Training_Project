package Event_Ticket_Booking_Pkg;

public class Ticket {
    private Attendee attendee;
    private Event event;
    private String status;
    public Ticket(Attendee attendee,Event event){
        this.attendee=attendee;
        this.event=event;
        this.status="Booked";
    }
    public void cancel(){
        status="Cancelled";
    }
    public String getStatus(){
        return status;
    }
    public String ticketDetails(){
        return "Ticket for "+attendee.name+" - Event: "+event.getTitle()+" - Status: "+status;
    }
}
