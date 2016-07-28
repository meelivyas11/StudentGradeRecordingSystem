package sgrs.Service;

import java.util.List;

import sgrs.Domain.Assignment;
import sgrs.Domain.Course;
import sgrs.Domain.Student;
import sgrs.Domain.StudentGrade;

public interface ProfessorService {
	
	public boolean addCourse(Course course);

	public boolean addStudentInCourse(int staffId, Student student, String courseCode, String term);

	public boolean addAssignmentForCourse(Assignment assignment, String courseCode, String term);

	public double getAssignmenntTotalWeightagePercent(String courseCode, String term);

	public List<Course> getCourseListForProfessor(int loggedInUserId);

	public List<Assignment> getAssignmentListForCourseId(int parseInt);

	public Course getCourseById(int parseInt);

	public Assignment getAssignmentById(int selectedAssignmentId);

	public List<StudentGrade> getStudentListForCourseId(int selectedCourseId, int selectedAssignmentId);

	public boolean addMarksInGrade(int studentId, int assignmentId, int courseId, double marksObtained);

	public boolean updateMarksInStudentBook(int studentId, int assignmentId, int courseId);

	public double getMarksOfAssignment(int sId, int courseId, int assignmentId);

}
