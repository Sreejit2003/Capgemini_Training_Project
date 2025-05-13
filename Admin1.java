package Event_Ticket_Booking_Pkg;

import java.util.Iterator;
import java.util.List;

@Annotation(role = "Admin")
public class Admin1 extends User {
    public Admin1(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }

    public void removeEvent(List<Event> events, String title) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Event '" + title + "' removed.");
                return;
            }
        }
        System.out.println("Event '" + title + "' not found.");
    }
}

