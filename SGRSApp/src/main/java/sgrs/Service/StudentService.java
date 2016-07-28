package sgrs.Service;

import java.util.List;

import sgrs.Domain.Course;
import sgrs.Domain.StudentGrade;

public interface StudentService {

	List<Course> getCourseListForStudent(int studentId);

	List<StudentGrade> getAllStudents();

	double getOverAllGrades(int studentId, int courseId);

}
