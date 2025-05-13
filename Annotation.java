package Event_Ticket_Booking_Pkg;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation {
	String role();
}
