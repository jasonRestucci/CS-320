import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {
	
	public static void main(String[] args){
		List<Contact> contactList = new ArrayList<>();
		contactList.add(new Contact("1", "Kyle", "Kyleson", "7815555555", "55 Neighborhood Ave")); //place holder for testing
		boolean active= true;
		while(active == true) { // main while loop
			System.out.println("Welcome to Contact Service");
			System.out.println("Would you like to add (1), delete (2), or update (3) a contact?");
			
			Scanner reader = new Scanner(System.in); // reads user input
			System.out.println("Enter 1 to add, 2 to delete, 3 to update, or 4 to quit: ");
			int n = reader.nextInt(); 
			//System.out.println(n);
			if (n == 1) { // adds a new contact using user inputs
				System.out.println("Enter a unique ID:");
				String id = reader.next();
				System.out.println("Enter a First Name:");
				String fName = reader.next();
				System.out.println("Enter a Last Name:");
				String lName = reader.next();
				System.out.println("Enter a Phone Number:");
				String phoneNumber = reader.next();
				System.out.println("Enter an Address:");
				String addy = reader.next();
				contactList.add(new Contact(id, fName, lName, phoneNumber, addy));
			}
			if (n == 4) { //quits the program, closes the reader
				active = false;
				reader.close();
			}
			if (n == 2) { // deletes contact by searching for given ID
				System.out.println("Enter the ID for the contact you would like to delete: ");
				String deletedID = reader.next();
				for(int i = 0; i < contactList.size(); i++) { // ID is found
					if (contactList.get(i).getID().equals(deletedID)) {
						contactList.remove(i);
						System.out.println("Removal Successfull!");
					}
				}
			}
			if (n == 3) { // updates contact by searching for ID, then asks what to update
				System.out.println("Enter the ID for the contact you would like to update: ");
				String updatedID = reader.next();
				for(int i = 0; i < contactList.size(); i++) { // searches for given ID
					if (contactList.get(i).getID().equals(updatedID)) {// ID is found
						System.out.println("Would you like to update the first name (1), the last name (2), the phone number (3), or the address (4)? ");
						int b = reader.nextInt();
						if (b == 1) {// updates first name
							System.out.println("Enter the new first name: ");
							String updateCon = reader.next();
							contactList.get(i).setFirstName(updateCon);
						}
						if (b == 2) {// updates last name
							System.out.println("Enter the new last name: ");
							String updateCon = reader.next();
							contactList.get(i).setLastName(updateCon);
						}
						if (b == 3) {// updates phone number
							System.out.println("Enter the new phone number: ");
							String updateCon = reader.next();
							contactList.get(i).setPhoneNum(updateCon);
						}
						if (b == 4) {// updates address
							System.out.println("Enter the new address: ");
							String updateCon = reader.next();
							contactList.get(i).setAddress(updateCon);
						}
					}
					else {// no ID in list
						System.out.println("Could not find ID");
					}
				}
			}
		}
	}
}
