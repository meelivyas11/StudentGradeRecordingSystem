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
import sgrs.Domain.Student;
import sgrs.Domain.StudentGrade;
import sgrs.Service.AccountService;
import sgrs.Service.ProfessorService;
import sgrs.Service.StudentService;

@Controller
@RequestMapping(value="/ProfessorController")
public class ProfessorController {

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String home(@ModelAttribute("EnterGrade") EnterGrade enterGrade, HttpServletRequest request) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		StudentService studentService = ServiceFactory.getStudentService();
		AccountService acctService = ServiceFactory.getAccountService();
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		List<Course> courseList = new ArrayList<Course>();
		List<StudentGrade> studentList = new ArrayList<StudentGrade>();
		
		if(acctService.isUserProfessor(loggedInUserId)) {
			courseList = professorService.getCourseListForProfessor(loggedInUserId);
			studentList = studentService.getAllStudents();
		}
		enterGrade.setCourseList(courseList);
		enterGrade.setStudentList(studentList);
		return "Professor/PHome";
	}
	

	@RequestMapping(value = "/AddCourseView", method = RequestMethod.GET)
	public String showAddCoursePage(Model model) {
		model.addAttribute("NewCourse", new Course()); 
		return "Professor/AddCourse";
	}
	
	@RequestMapping(value = "/AddCourse", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("NewCourse") Course course, HttpServletRequest request, Model model) {
		
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		boolean isCourseCreated = false;
		if(acctService.isUserProfessor(loggedInUserId)) {
			course.setStaffId(loggedInUserId);
			isCourseCreated = professorService.addCourse(course);
		}
		model.addAttribute("isCourseCreated", isCourseCreated);
		return "Professor/AddCourse";
	}
	
	@RequestMapping(value = "/AddStudentView", method = RequestMethod.GET)
	public String showAddStudentPage(Model model) {
		model.addAttribute("NewStudent", new Student()); 
		return "Professor/AddStudent";
	}
	
	@RequestMapping(value = "/AddStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("NewStudent") Student student, HttpServletRequest request, Model model) {
		
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		//StudentBook studentBook = new StudentBook();
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		String courseCode = (String) request.getParameter("courseCode");
		String term = (String) request.getParameter("term");
		
		boolean isStudentAdded = false;
		if(acctService.isUserProfessor(loggedInUserId)) {
			//studentBook.setStaffId(loggedInUserId);
			isStudentAdded = professorService.addStudentInCourse(loggedInUserId, student, courseCode, term);
		}
		model.addAttribute("isStudentAdded", isStudentAdded);
		return "Professor/AddStudent";
	}
	
	@RequestMapping(value = "/AddAssignmentView", method = RequestMethod.GET)
	public String showAddAssignmentPage(Model model) {
		model.addAttribute("NewAssignment", new Assignment()); 
		return "Professor/AddAssignment";
	}
	
	@RequestMapping(value = "/AddAssignment", method = RequestMethod.POST)
	public String addAssignment(@ModelAttribute("NewAssignment") Assignment assignment, HttpServletRequest request, Model model) {
		
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		String courseCode = (String) request.getParameter("courseCode");
		String term = (String) request.getParameter("term");
		
		// Making totalMarks = 100 (default)
		assignment.setTotalMarks(100);
		
		boolean isAssignmentAdded = false;
		if(acctService.isUserProfessor(loggedInUserId)) {
			double existingAssignmentWeightage =  professorService.getAssignmenntTotalWeightagePercent(courseCode, term);
			if(existingAssignmentWeightage + assignment.getPercentage() < 101) {
				isAssignmentAdded = professorService.addAssignmentForCourse(assignment, courseCode, term);
				model.addAttribute("existingAssignmentWeightage", existingAssignmentWeightage + assignment.getPercentage());
			}
			else {
				model.addAttribute("remainingAssignmentWeightage", 100 - existingAssignmentWeightage);
			}
		}
		model.addAttribute("isAssignmentAdded", isAssignmentAdded);
		return "Professor/AddAssignment";
	}
	
	@RequestMapping(value = "/EnterGradesView", method = RequestMethod.GET)
	public String showEnterGradePage(@ModelAttribute("EnterGrade") EnterGrade enterGrade ,Model model, HttpServletRequest request) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		List<Course> courseList = new ArrayList<Course>();
		
		if(acctService.isUserProfessor(loggedInUserId)) {
			courseList = professorService.getCourseListForProfessor(loggedInUserId);
		}
		enterGrade.setCourseList(courseList);
		return "Professor/SelectCourse";
	}
	
	@RequestMapping(value = "/GetAssignments", method = RequestMethod.GET)
	public String getAssignmentList(@ModelAttribute("EnterGrade") EnterGrade enterGrade, Model model, HttpServletRequest request) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		String selectedCourseId = request.getParameter("courseId");
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		Course course = new Course();
		if(acctService.isUserProfessor(loggedInUserId)) {
			assignmentList = professorService.getAssignmentListForCourseId(Integer.parseInt(selectedCourseId));
			course = professorService.getCourseById(Integer.parseInt(selectedCourseId));
		}
		enterGrade.setAssignmentList(assignmentList);
		enterGrade.setSelectedCourseId(Integer.parseInt(selectedCourseId));
		model.addAttribute("SelectedCourse", course.getCode() + ":" + course.getName() + "-" + course.getTerm());
		return "Professor/SelectAssignment";
	}
	
	@RequestMapping(value = "/GetStudents", method = RequestMethod.GET)
	public String getStudentList(@ModelAttribute("EnterGrade") EnterGrade enterGrade, Model model, HttpServletRequest request) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		
		int selectedCourseId = Integer.parseInt(request.getParameter("courseId"));
		int selectedAssignmentId = Integer.parseInt(request.getParameter("assignmentId"));
		List<StudentGrade> studentList = new ArrayList<StudentGrade>();
		Course course = new Course();
		Assignment assignment = new Assignment();
		
		if(acctService.isUserProfessor(loggedInUserId)) {
			assignment = professorService.getAssignmentById(selectedAssignmentId);
			course = professorService.getCourseById(selectedCourseId);
			studentList = professorService.getStudentListForCourseId(selectedCourseId, selectedAssignmentId);
			for (StudentGrade studentGrade : studentList) {
				int sId = studentGrade.getStudentId();
				double currentMarks = professorService.getMarksOfAssignment(sId, selectedCourseId, selectedAssignmentId);
				studentGrade.setMarks(currentMarks);
			}
			
		}
		enterGrade.setSelctedAssignmenId(selectedAssignmentId);;
		enterGrade.setSelectedCourseId(selectedCourseId);
		enterGrade.setStudentList(studentList);
		model.addAttribute("SelectedCourse", course.getCode() + ":" + course.getName() + " - " + course.getTerm());
		model.addAttribute("SelectedAssigment", assignment.getAssignmentName() + "	, Total Marks is: " + assignment.getTotalMarks());
		return "Professor/EnterStudentMarks";
	}
	
	@RequestMapping(value = "/EnterMarks", method = RequestMethod.POST)
	public String enterMarks(@ModelAttribute("EnterGrade") EnterGrade enterGrade, Model model, HttpServletRequest request) {
		ProfessorService professorService = ServiceFactory.getProfessorService();
		AccountService acctService = ServiceFactory.getAccountService();
		
		HttpSession session = request.getSession();
		int loggedInUserId = (Integer) session.getAttribute("UserId");
		boolean isMarksAddedInGrade, isOverAllMarksAdded = false;
		
		int courseId = -1;
		int assignmentId = -1 ;
		List<StudentGrade> studentList = new ArrayList<StudentGrade>();
		
		if(acctService.isUserProfessor(loggedInUserId)) {
			for (StudentGrade sg : enterGrade.getStudentList()) {
				assignmentId = sg.getAssignmentId();
				courseId = sg.getCourseId();
				int studentId = sg.getStudentId();
				double marksObtained = sg.getMarks();
				Assignment assignment = professorService.getAssignmentById(assignmentId);
				
				if(marksObtained <= assignment.getTotalMarks()) {
					isMarksAddedInGrade = professorService.addMarksInGrade(studentId, assignmentId, courseId, marksObtained);
					if (isMarksAddedInGrade) {
						isOverAllMarksAdded = professorService.updateMarksInStudentBook(studentId, assignmentId, courseId);
					}
				} else {
					model.addAttribute("IncorrectMarks", true);
				}
			}
			studentList = professorService.getStudentListForCourseId(courseId, assignmentId);
			for (StudentGrade studentGrade : studentList) {
				int sId = studentGrade.getStudentId();
				double currentMarks = professorService.getMarksOfAssignment(sId, courseId, assignmentId);
				studentGrade.setMarks(currentMarks);
			}
			
			Assignment assignment = professorService.getAssignmentById(assignmentId);
			Course course = professorService.getCourseById(courseId);
			
			enterGrade.setSelctedAssignmenId(assignmentId);
			enterGrade.setSelectedCourseId(courseId);
			enterGrade.setStudentList(studentList);
			
			model.addAttribute("SelectedCourse", course.getCode() + ":" + course.getName() + "-" + course.getTerm());
			model.addAttribute("SelectedAssigment", assignment.getAssignmentName() + " , Total Marks is: " + assignment.getTotalMarks());
			
			model.addAttribute("isOverAllMarksUpdated", isOverAllMarksAdded);
			return "Professor/EnterStudentMarks";
		}
		else {
			return "Login.jsp";
		}
		
	}
	
	
	
}
