package Event_Ticket_Booking_Pkg;

public class Attendee extends User {

	public Attendee(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showProfile() {
		// TODO Auto-generated method stub
		System.out.println("Attendee Profile: ");
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
	}

}
