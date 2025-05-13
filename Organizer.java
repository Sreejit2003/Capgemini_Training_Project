package Event_Ticket_Booking_Pkg;

public class Organizer extends User {
	
	private boolean active = true;

	public Organizer(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void showProfile() {
		// TODO Auto-generated method stub
		System.out.println("Organizer Profile: ");
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Status: "+ (active ? "Active" : "Inactive"));
	}

}
