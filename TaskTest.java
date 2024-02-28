import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("1", "K", "K");
		assertTrue(task.getID().equals("1"));
		assertTrue(task.getName().equals("K"));
		assertTrue(task.getDescription().equals("K"));
	}

	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Task("1234567891000", "1", "2");
		});
	}
	
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Task(null, "1", "2");
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Task("1", "Abernificuszeclonobunituisochoexiously", "2");
		});
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Task("1", null, "2");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Task("1", "aa", "012345678901234567890123456789012345678901234567890123456789");
		});
	}
	
	@Test
	void testDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
				new Task("1","aaa", null);
		});
	}
}
