package sgrs.Domain;

public class Course {
	private int courceId;
	private String code;
	private String name;
	private String description;
	private int staffId;
	private String term;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourceId() {
		return courceId;
	}
	public void setCourceId(int courceId) {
		this.courceId = courceId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
}
