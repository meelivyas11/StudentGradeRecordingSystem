package sgrs.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import sgrs.ServiceFactory;
import sgrs.DataProvider.ProfessorDataProvider;
import sgrs.Domain.Assignment;
import sgrs.Domain.Course;
import sgrs.Domain.Student;
import sgrs.Domain.StudentGrade;
import sgrs.Service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

	public boolean addCourse(Course course) {
		int rowsInserted = ProfessorDataProvider.createNewCourse(course);
		if(rowsInserted>0)
			return true;
		else
			return false;
	}

	public boolean addStudentInCourse(int staffId, Student student, String courseCode, String term) {
		int courseId = ProfessorDataProvider.getCourseIdFromCodeTerm(courseCode, term);
		int studentId = ProfessorDataProvider.getStudentIdFromStudentName(student.getFirstName(), student.getLastName());
		
		if(courseId!= -1 && studentId==student.getStudentId()) {
			int rowsInserted = ProfessorDataProvider.addStudentRecords(studentId, staffId, courseId, term);
			if(rowsInserted>0)
				return true;
			return false;
		}
		return false;
	}

	public boolean addAssignmentForCourse(Assignment assignment, String courseCode, String term) {
		int courseId = ProfessorDataProvider.getCourseIdFromCodeTerm(courseCode, term);
		
		if(courseId!= -1) {
			int rowsInserted = ProfessorDataProvider.addAssignment(courseId, assignment);
			if(rowsInserted>0)
				return true;
			return false;
		}
		return false;
	}

	public double getAssignmenntTotalWeightagePercent(String courseCode, String term) {
		int courseId = ProfessorDataProvider.getCourseIdFromCodeTerm(courseCode, term);
		if(courseId!= -1) {
			double totalPercentWeightage = ProfessorDataProvider.getTotalPercentage(courseId);
			return totalPercentWeightage;
		}
		return 0;
	}

	public List<Course> getCourseListForProfessor(int staffId) {
		List<Course> courses = ProfessorDataProvider.getCourseList(staffId);
		return courses;
	}

	public List<Assignment> getAssignmentListForCourseId(int courseId) {
		List<Assignment> assignments = ProfessorDataProvider.getAssignmentList(courseId);
		return assignments;
	}

	public Course getCourseById(int courseId) {
		return ProfessorDataProvider.getCourseFromId(courseId);
	}

	public Assignment getAssignmentById(int selectedAssignmentId) {
		return ProfessorDataProvider.getAssignmentFromId(selectedAssignmentId);
	}

	public List<StudentGrade> getStudentListForCourseId(int selectedCourseId, int selectedAssignmentId) {
		List<StudentGrade> students = ProfessorDataProvider.getStudentsList(selectedCourseId,selectedAssignmentId);
		return students;
	}

	public boolean addMarksInGrade(int studentId, int assignmentId, int courseId, double marksObtained) {
		int rowsInserted = ProfessorDataProvider.createUpdateGrade(studentId, assignmentId, courseId, marksObtained);
		if(rowsInserted>0)
			return true;
		else
			return false;
	}

	public boolean updateMarksInStudentBook(int studentId, int aseeeeeeeeeesignmentId, int courseId) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		List<StudentGrade> studentGradeList = new ArrayList<StudentGrade>();
		studentGradeList = ProfessorDataProvider.getStudentGrades(studentId, courseId);
		
		double marksForAssignment = 0;
		for (StudentGrade studentGrade : studentGradeList) {
			int assignmentId = studentGrade.getAssignmentId();
			Assignment assignment = professorService.getAssignmentById(assignmentId);
			marksForAssignment =  marksForAssignment + (studentGrade.getMarks() * (assignment.getPercentage()) / assignment.getTotalMarks());
		}
		
		//Inset in Student_BOOK
		int rowsInserted = ProfessorDataProvider.insertOverallGrade(marksForAssignment, studentId, courseId);
		if(rowsInserted>0)
			return true;
		else
			return false;
	}

	public double getMarksOfAssignment(int sId, int courseId, int assignmentId) {
		double marks = ProfessorDataProvider.getMarksForAssignmentCourseOfStudent(sId, courseId, assignmentId);
		return marks;
	}

}
