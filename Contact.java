
public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	public Contact(String conID, String fName, String lName, String phoneNumber, String addy) {
		//throws exception if field is null or is to long
		if (conID == null || conID.length()>10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		if (fName == null || fName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lName == null || lName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (phoneNumber == null || phoneNumber.length()>10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (addy == null || addy.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		contactID = conID;
		firstName = fName;
		lastName = lName;
		phoneNum = phoneNumber;
		address = addy;
	}
	
	public String getID() {
		return contactID;
	}
	public String getFName() {
		return firstName;
	}
	public String getLName() {
		return lastName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String fName) {
		firstName = fName;
	}
	public void setLastName(String lName) {
		lastName = lName;
	}
	public void setPhoneNum(String phoneNumber) {
		phoneNum = phoneNumber;
	}
	public void setAddress(String addy) {
		address = addy;
	}

}
