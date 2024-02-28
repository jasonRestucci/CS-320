import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	@Test
	void testAppointment() {
		Appointment appointment = new Appointment("1", LocalDateTime.of(2024, 2, 14, 9, 30), "a");
		assertTrue(appointment.getID().equals("1"));
		assertTrue(appointment.getDate().equals(LocalDateTime.of(2024, 2, 14, 9, 30)));
		assertTrue(appointment.getDescription().equals("a"));
	}

	@Test
	void testAppIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Appointment("1234567891000", LocalDateTime.of(2024, 2, 14, 9, 30), "a");
		});
	}
	
	@Test
	void testAppIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Appointment(null, LocalDateTime.of(2024, 2, 14, 9, 30), "a");
		});
	}
	
	@Test
	void testAppDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Appointment("1", LocalDateTime.of(1800, 2, 14, 9, 30), "a");
		});
	}
	
	@Test
	void testAppDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Appointment("1", null, "a");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Appointment("1", LocalDateTime.of(2024, 2, 14, 9, 30), "012345678901234567890123456789012345678901234567890123456789");
		});
	}
	
	@Test
	void testDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Appointment("1",LocalDateTime.of(2024, 2, 14, 9, 30), null);
		});
	}
}
