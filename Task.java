
public class Task {
	private String taskID;
	private String name;
	private String description;
	
	public Task(String tskID, String nam, String desc) {
		//throws exception if field is null or is to long
		if (tskID == null || tskID.length()>10) {
			throw new IllegalArgumentException("Invalid Task ID");
		}
		if (nam == null || nam.length()>20) {
			throw new IllegalArgumentException("Invalid Name");
		}

		if (desc == null || desc.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		taskID = tskID;
		name = nam;
		description = desc;
	}
	
	public String getID() {
		return taskID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public void setName(String nam) {
		name = nam;
	}
	public void setDescription(String desc) {
		description = desc;
	}
}
