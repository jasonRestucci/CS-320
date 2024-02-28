import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService {
	public static void main(String[] args){
		List<Task> taskList = new ArrayList<>();
		taskList.add(new Task("1", "Do taxes", "Do my taxes and do not use turbo tax this time")); //place holder for testing
		boolean active= true;
		while(active == true) { // main while loop
			System.out.println("Welcome to Task Service");
			System.out.println("Would you like to add (1), delete (2), or update (3) a task?");
			
			Scanner reader = new Scanner(System.in); // reads user input
			System.out.println("Enter 1 to add, 2 to delete, 3 to update, or 4 to quit: ");
			int n = reader.nextInt();
			
			if (n < 1 || n > 4) { // checks for for invalid input
				System.out.println("Invalid menu input!");
				continue;
			}
			
			reader.nextLine();
			if (n == 1) { // adds a new task using user inputs
				System.out.println("Enter a unique ID:");
				String id = reader.next();
				reader.nextLine();
				System.out.println("Enter a Name:");
				String taskName = reader.nextLine();
				System.out.println("Enter a Description:");
				String taskDesc = reader.nextLine();
				
				taskList.add(new Task(id, taskName, taskDesc));
			}
			if (n == 4) { //quits the program, closes the reader
				active = false;
				reader.close();
			}
			if (n == 2) { // deletes task by searching for given ID
				System.out.println("Enter the ID for the task you would like to delete: ");
				String deletedID = reader.next();
				
				if (deletedID == null || deletedID.length()>10) { // checks for invalid input
					System.out.println("Invalid ID!");
					continue;
				}
				
				for(int i = 0; i < taskList.size(); i++) { 			// searches the taskList
					if (taskList.get(i).getID().equals(deletedID)) { //if the ID is found
						taskList.remove(i); 						// removes the ID
						System.out.println("Removal Successfull!");
					}
				}
			}
			if (n == 3) { // updates task by searching for ID, then asks what to update
				System.out.println("Enter the ID for the task you would like to update: ");
				String updatedID = reader.next();
				
				if (updatedID == null || updatedID.length()>10) { // checks for invalid input
					System.out.println("Invalid ID!");
					continue;
				}
				
				for(int i = 0; i < taskList.size(); i++) { // searches the taskList for given ID
					if (taskList.get(i).getID().equals(updatedID)) {// ID is found
						System.out.println("Would you like to update the task Name (1), or Description (2)? ");
						int b = reader.nextInt();
						
						if (n < 1 || n > 2) { // throws an argument exception for invalid input
							System.out.println("Invalid ID!");
							continue;
						}
						
						reader.nextLine();
						if (b == 1) {// updates the name via user input
							System.out.println("Enter the new name: ");
							String updateTask = reader.nextLine();
							
							if (updateTask == null || updateTask.length()>20) { // checks for invalid input
								System.out.println("Invalid Name!");
								continue;
							}
							
							System.out.println("Name used to be :" + taskList.get(i).getName());
							taskList.get(i).setName(updateTask);
							System.out.println("Name changed to :" + taskList.get(i).getName());
						}
						if (b == 2) {// updates description via user input
							System.out.println("Enter a new description: ");
							String updateTask = reader.nextLine();
							
							if (updateTask == null || updateTask.length()>50) { // checks for invalid input
								System.out.println("Invalid Description!");
								continue;
							}
							
							System.out.println("Description used to be :" + taskList.get(i).getDescription());
							taskList.get(i).setDescription(updateTask);
							System.out.println("Description changed to :" + taskList.get(i).getDescription());
						}
					}
					else {// no ID in list
						if (i >= taskList.size()) {
							System.out.println("Could not find ID");
						}
					}
				}
			}
		}
	}
}
