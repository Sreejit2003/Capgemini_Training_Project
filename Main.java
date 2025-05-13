package Event_Ticket_Booking_Pkg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventBookingSystem1 system = new EventBookingSystem1();

        //system.loadEvents("capgemini");

        while (true) {
            System.out.println("\n--- Event Ticket Booking System ---");
            System.out.println("1. Register Attendee");
            System.out.println("2. Add Event");
            System.out.println("3. Book Ticket");
            System.out.println("4. Show Events");
            System.out.println("5. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Attendee ID: ");
                    String attendeeId = scanner.nextLine();
                    System.out.print("Enter Attendee Name: ");
                    String attendeeName = scanner.nextLine();
                    Attendee attendee = new Attendee(attendeeId, attendeeName);
                    system.registerUser(attendee);
                    System.out.println("Attendee registered.");
                    break;

                case 2:
                    System.out.print("Enter Event Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Available Tickets: ");
                    int tickets = scanner.nextInt();
                    scanner.nextLine();
                    Event event = new Event(title, tickets);
                    system.addEvent(event);
                    System.out.println("Event added.");
                    break;

                case 3:
                    System.out.print("Enter Attendee ID: ");
                    String id = scanner.nextLine();
                    Attendee found = null;
                    for (Attendee a : system.getAttendees()) {
                        if (a.getId().equalsIgnoreCase(id)) {
                            found = a;
                            break;
                        }
                    }
                    if (found == null) {
                        System.out.println("Attendee not found.");
                        break;
                    }
                    System.out.print("Enter Event Title: ");
                    String eventName = scanner.nextLine();
                    try {
                        system.bookTicket(found, eventName);
                    } catch (Custom_Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    system.showEvents();
                    break;

                case 5:
                    system.saveEvents("capgemini");
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

