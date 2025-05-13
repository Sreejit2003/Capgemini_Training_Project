package Event_Ticket_Booking_Pkg;

import java.util.*;
import java.io.*;

    public class EventBookingSystem1 {
        private List<Attendee> attendees = new ArrayList<>();
        private List<Organizer> organizers = new ArrayList<>();
        private List<Event> events = new ArrayList<>();
        private List<Ticket> tickets = new ArrayList<>();

        public void registerUser(User user) {
            if (user instanceof Attendee) {
                attendees.add((Attendee) user);
            } else if (user instanceof Organizer) {
                organizers.add((Organizer) user);
            }
        }

        public void addEvent(Event event) {
            events.add(event);
        }

        public void bookTicket(Attendee attendee, String eventTitle) throws Custom_Exception {
            for (Event event : events) {
                if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                    if (!event.isAvailable()) {
                        throw new Custom_Exception("Tickets are sold out.");
                    }
                    event.setAvailableTickets(event.getAvailableTickets() - 1);
                    Ticket ticket = new Ticket(attendee, event);
                    tickets.add(ticket);
                    System.out.println("Ticket booked successfully.");
                    return;
                }
            }
            throw new Custom_Exception("Event not found.");
        }

        public void saveEvents(String filename) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(events);
                System.out.println("Events saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        public void loadEvents(String filename) {
//            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
//                events = (List<Event>) in.readObject();
//                System.out.println("Events loaded.");
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
        public static void loadEvents() {
            File file = new File("capgemini.txt");

            
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        System.out.println("File 'capgemini.txt' created.");
                    }
                } catch (IOException e) {
                    System.out.println("Error creating file: " + e.getMessage());
                }
            }

          
            try (FileInputStream fis = new FileInputStream(file)) {
               
            } catch (IOException e) {
                System.out.println("Error reading events: " + e.getMessage());
            }
        }


        public void showEvents() {
            if (events.isEmpty()) {
                System.out.println("No events available.");
            } else {
                for (Event e : events) {
                    System.out.println(e.getAvailableTickets());
                }
            }
        }

        
        public List<Attendee> getAttendees() { return attendees; }
        public List<Organizer> getOrganizers() { return organizers; }
        public List<Event> getEvents() { return events; }
        public List<Ticket> getTickets() { return tickets; }
    }
