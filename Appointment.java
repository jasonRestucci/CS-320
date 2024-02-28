import java.time.LocalDateTime;

public class Appointment {
	private String appID;
	private LocalDateTime appDate;
	private String appDesc;
	
	public Appointment(String appId, LocalDateTime appDATE, String appDESC) {
		//throws exception if field is null or is to long
		if (appId == null || appId.length()>10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		if (appDATE == null || appDATE.isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Invalid Date");
		}

		if (appDESC == null || appDESC.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		appID = appId;
		appDate = appDATE;
		appDesc = appDESC;
	}
	
	public String getID() {
		return appID;
	}
	public LocalDateTime getDate() {
		return appDate;
	}
	public String getDescription() {
		return appDesc;
	}
	
	public void setDate(LocalDateTime dt) {
		appDate = dt;
	}
	public void setDescription(String desc) {
		appDesc = desc;
}}
