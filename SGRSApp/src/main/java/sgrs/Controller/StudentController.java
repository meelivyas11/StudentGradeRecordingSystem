package sgrs.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sgrs.ServiceFactory;
import sgrs.Domain.Assignment;
import sgrs.Domain.Course;
import sgrs.Domain.EnterGrade;
import sgrs.Service.ProfessorService;
import sgrs.Service.StudentService;

@Controller
@RequestMapping(value="/StudentController")
public class StudentController {
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String home() {
		return "redirect:/StudentController/SeeStudentCourses";
	}
	
	@RequestMapping(value = "/SeeStudentCourses", method = RequestMethod.GET)
	public String showEnterGradePage(@ModelAttribute("EnterGrade") EnterGrade enterGrade ,Model model, HttpServletRequest request) {
		StudentService studentService = ServiceFactory.getStudentService();

		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("UserId");
		
		List<Course> courseList = new ArrayList<Course>();
		
		courseList = studentService.getCourseListForStudent(studentId);
		
		enterGrade.setCourseList(courseList);
		return "Student/StudentCourse";
	}
	
	@RequestMapping(value = "/GetAllAssignmentsMarks", method = RequestMethod.GET)
	public String getAssignmentList(@ModelAttribute("EnterGrade") EnterGrade enterGrade, Model model, HttpServletRequest request) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		StudentService studentService = ServiceFactory.getStudentService();
		
		HttpSession session = request.getSession();
		int studentId = (Integer) session.getAttribute("UserId");
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		Course course = new Course();
		
		assignmentList = professorService.getAssignmentListForCourseId(courseId);
		for (Assignment assignment : assignmentList) {
			int assignmentId = assignment.getAssignmentId();
			double marksObtained = professorService.getMarksOfAssignment(studentId, courseId, assignmentId);
			assignment.setObtainedMarks(marksObtained);
		}
		enterGrade.setAssignmentList(assignmentList);
		
		course = professorService.getCourseById(courseId);
		enterGrade.setSelectedCourseId(courseId);
		
		double overAllMarks = studentService.getOverAllGrades(studentId, courseId);
		
		model.addAttribute("OverAllMarks", overAllMarks);
		model.addAttribute("SelectedCourse", course.getCode() + ":" + course.getName() + "-" + course.getTerm());
		return "Student/StudentsGrade";
	}
	
}
