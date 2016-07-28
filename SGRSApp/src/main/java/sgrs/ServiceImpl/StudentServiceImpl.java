package sgrs.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import sgrs.ServiceFactory;
import sgrs.DataProvider.StudentDataProvider;
import sgrs.Domain.Course;
import sgrs.Domain.StudentGrade;
import sgrs.Service.ProfessorService;
import sgrs.Service.StudentService;

public class StudentServiceImpl implements StudentService {

	public List<Course> getCourseListForStudent(int studentId) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		List<Integer> courseIds = StudentDataProvider.getRegisteredCourseList(studentId);
		List<Course> courseList = new ArrayList<Course>();
		for (Integer courseId : courseIds) {
			Course c = professorService.getCourseById(courseId);
			courseList.add(c);
		}
		return courseList;
	}

	public List<StudentGrade> getAllStudents() {
		List<StudentGrade> students = StudentDataProvider.getAllStudents();
		return students;
	}

	public double getOverAllGrades(int studentId, int courseId) {
		return StudentDataProvider.getFinalGrades(studentId, courseId);
	}

}
