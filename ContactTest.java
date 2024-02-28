import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("1", "K", "K", "781", "55 Ne");
		assertTrue(contact.getID().equals("1"));
		assertTrue(contact.getFName().equals("K"));
		assertTrue(contact.getLName().equals("K"));
		assertTrue(contact.getPhoneNum().equals("781"));
		assertTrue(contact.getAddress().equals("55 Ne"));
	}

	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("12345678910", "1", "2", "1", "3");
		});
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact(null, "1", "2", "1", "3");
		});
	}
	
	@Test
	void testContactFNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1", "Abernificuszeclonobunituis Rex", "2", "1", "3");
		});
	}
	
	@Test
	void testContactFNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1", null, "2", "1", "3");
		});
	}
	
	@Test
	void testContactPhoneNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1", "aa", "Rx", "1111111111111111111111111111111111111111111111111111", "3");
		});
	}
	
	@Test
	void testContactPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1","aaa", "aaaa", null, "3");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1", "aa", "Rx", "1", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1","aaa", "aaaaa", "1", null);
		});
	}
	
	@Test
	void testContactLNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1", "aa", "Abernificuszeclonobunituis Rex", "1", "3");
		});
	}
	
	@Test
	void testContactLNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Contact("1","aaa", null, "1", "3");
		});
	}
}
