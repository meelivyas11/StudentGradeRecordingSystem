package sgrs.Domain;

import java.util.List;

public class EnterGrade {
	private int selectedCourseId;
	private int selctedAssignmenId;
	private List<Course> courseList;
	private List<Assignment> assignmentList;
	private List<StudentGrade> studentList;
	
	public int getSelectedCourseId() {
		return selectedCourseId;
	}
	public void setSelectedCourseId(int selectedCourseId) {
		this.selectedCourseId = selectedCourseId;
	}
	public int getSelctedAssignmenId() {
		return selctedAssignmenId;
	}
	public void setSelctedAssignmenId(int selctedAssignmenId) {
		this.selctedAssignmenId = selctedAssignmenId;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}
	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	public List<StudentGrade> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<StudentGrade> studentList) {
		this.studentList = studentList;
	}
	
	
}
