import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
	public static void main(String[] args){
		List<Appointment> appList = new ArrayList<>();
		appList.add(new Appointment("1", LocalDateTime.of(2024, 2, 14, 9, 30), "a")); //place holder for testing
		boolean active= true;
		while(active == true) { // main while loop
			System.out.println("Welcome to Appointment Service");
			System.out.println("Would you like to add (1), or delete (2) an appointment?");
			
			Scanner reader = new Scanner(System.in); // reads user input
			System.out.println("Enter 1 to add, 2 to delete, or 3 to quit: ");
			int n = reader.nextInt();
			
			if (n < 1 || n > 3) { // checks for for invalid input
				System.out.println("Invalid menu input!");
				continue;
			}
			
			reader.nextLine();
			if (n == 1) { // adds a new task using user inputs
				System.out.println("Enter a unique ID:");
				String id = reader.next();
				reader.nextLine();
				System.out.println("Next, we will enter the date and time of the appointment");
				System.out.println("Enter the year:");
				int year = reader.nextInt();
				System.out.println("Enter the month (numbered, ex: enter 3 for march):");
				int month = reader.nextInt();
				System.out.println("Enter the day (numbered):");
				int day = reader.nextInt();
				System.out.println("Enter the hour (military time):");
				int hour = reader.nextInt();
				System.out.println("Enter the minute (enter 0 for the top of the hour)");
				int min = reader.nextInt();
				reader.nextLine();
				System.out.println("Enter a Description:");
				String taskDesc = reader.nextLine();
				
				appList.add(new Appointment(id, LocalDateTime.of(year, month, day, hour, min), taskDesc));
			}
			if (n == 3) { //quits the program, closes the reader
				active = false;
				reader.close();
			}
			if (n == 2) { // deletes task by searching for given ID
				System.out.println("Enter the ID for the appointment you would like to delete: ");
				String deletedID = reader.next();
				
				if (deletedID == null || deletedID.length()>10) { // checks for invalid input
					System.out.println("Invalid ID!");
					continue;
				}
				
				for(int i = 0; i < appList.size(); i++) { 			// searches the taskList
					if (appList.get(i).getID().equals(deletedID)) { //if the ID is found
						appList.remove(i); 						// removes the ID
						System.out.println("Removal Successfull!");
					}
				}
			}
		}
	}
}
