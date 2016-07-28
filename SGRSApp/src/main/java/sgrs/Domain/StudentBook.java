package sgrs.Domain;

public class StudentBook {
	private int studentId;
	private int staffId;
	private int courseId;
	private String term;
	private double overallMarks;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public double getOverallMarks() {
		return overallMarks;
	}
	public void setOverallMarks(double overallMarks) {
		this.overallMarks = overallMarks;
	}
	
	
	
}
