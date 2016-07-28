package sgrs.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sgrs.Domain.Assignment;
import sgrs.Domain.Course;
import sgrs.Domain.StudentGrade;

public class ProfessorDataProvider {

	public static int createNewCourse(Course course) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int rowsInserted = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.INSERT_COURSE;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setString(1, course.getCode());
			prepareStmt.setString(2, course.getDescription());
			prepareStmt.setLong(3, course.getStaffId());
			prepareStmt.setString(4, course.getTerm());
			prepareStmt.setString(5, course.getName());
			
			rowsInserted = prepareStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return rowsInserted;
	}

	public static int getCourseIdFromCodeTerm(String courseCode, String term) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int courseId = -1;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_COURSEID_FROM_CODE_TERM;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setString(1, courseCode);
			prepareStmt.setString(2, term);

			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				courseId = rs.getInt("ID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return courseId;
	}

	public static int getStudentIdFromStudentName(String firstName, String lastName) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int studentId = -1;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_STUDENTID_FROM_NAME;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setString(1, firstName);
			prepareStmt.setString(2, lastName);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				studentId = rs.getInt("ID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return studentId;
	}

	public static int addStudentRecords(int studentId, int staffId, int courseId, String term) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int rowsInserted = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.INSERT_STUDENT_IN_STUDENTBOOK;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setLong(1, studentId);
			prepareStmt.setLong(2, staffId);
			prepareStmt.setLong(3, courseId);
			prepareStmt.setString(4, term);
			
			rowsInserted = prepareStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return rowsInserted;

	}

	public static int addAssignment(int courseId, Assignment assignment) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int rowsInserted = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.INSERT_ASSIGNMENT;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setLong(1, courseId);
			prepareStmt.setDouble(2, assignment.getTotalMarks());
			prepareStmt.setDouble(3, assignment.getPercentage());
			prepareStmt.setString(4, assignment.getAssignmentName());
			prepareStmt.setString(5, assignment.getAssignmentDescription());
			
			rowsInserted = prepareStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return rowsInserted;
	}

	public static double getTotalPercentage(int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		double totalPercentage = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_PERCENT_FOR_COURSEID;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, courseId);

			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				totalPercentage = totalPercentage + rs.getDouble("PERCENTAGE");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return totalPercentage;
	}

	public static List<Course> getCourseList(int staffId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ALLCOURSES_FOR_STAFF;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, staffId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				Course c = new Course();
				c.setCourceId(rs.getInt("ID"));
				c.setName(rs.getString("NAME"));
				c.setCode(rs.getString("CODE"));
				c.setDescription(rs.getString("DESCRIPTION"));
				c.setStaffId(rs.getInt("STAFF_ID"));
				c.setTerm(rs.getString("TERM"));
				courses.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return courses;
	}

	public static List<Assignment> getAssignmentList(int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		List<Assignment> assignments = new ArrayList<Assignment>();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ALL_ASSIGNMENT_FOR_COURSEID;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, courseId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				Assignment a = new Assignment();
				a.setAssignmentId(rs.getInt("ID"));
				a.setAssignmentName(rs.getString("NAME"));
				a.setAssignmentDescription(rs.getString("DESCRIPTION"));
				a.setPercentage(rs.getDouble("PERCENTAGE"));
				a.setTotalMarks(rs.getInt("TOTAL_MARKS"));
				assignments.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return assignments;
	}

	public static Course getCourseFromId(int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		Course course = new Course();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_COURSE_FOR_COURSEID;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, courseId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				course.setCourceId(rs.getInt("ID"));
				course.setName(rs.getString("NAME"));
				course.setCode(rs.getString("CODE"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setStaffId(rs.getInt("STAFF_ID"));
				course.setTerm(rs.getString("TERM"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return course;
	}

	public static Assignment getAssignmentFromId(int assignmentId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		Assignment assignment = new Assignment();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ASSIGNMENT_BY_ID;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, assignmentId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				assignment.setAssignmentId(rs.getInt("ID"));
				assignment.setAssignmentName(rs.getString("NAME"));
				assignment.setTotalMarks(rs.getInt("TOTAL_MARKS"));
				assignment.setPercentage(rs.getDouble("PERCENTAGE"));
				assignment.setAssignmentDescription(rs.getString("DESCRIPTION"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return assignment;
	}

	public static List<StudentGrade> getStudentsList(int courseId, int assignmentId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ALL_STUDENTS_FOR_COURSEID;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, courseId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				StudentGrade s = new StudentGrade();
				s.setStudentId((int) rs.getFloat("ID"));
				s.setFirstName(rs.getString("FIRSTNAME"));
				s.setLastName(rs.getString("LASTNAME"));
				s.setCourseId(courseId);
				s.setAssignmentId(assignmentId);
				studentGrades.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return studentGrades;
	}
	
	public static boolean isGradeRecordExist(int studentId, int assignmentId, int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		boolean recordExists = false;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_GRADE_RECORDS;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, studentId);
			prepareStmt.setLong(2, assignmentId);
			prepareStmt.setLong(3, courseId);
			
			ResultSet rs = prepareStmt.executeQuery();
			
			if(rs.next())
				recordExists = true ;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return recordExists;

	}

	public static int createUpdateGrade(int studentId, int assignmentId, int courseId, double marksObtained) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int rowsInserted = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			if(isGradeRecordExist(studentId, assignmentId, courseId)){
				String sql = DBUtils.UPDATE_GRADES;
				prepareStmt = conn.prepareStatement(sql);
				prepareStmt.setDouble(1,marksObtained);
				prepareStmt.setLong(2, studentId);
				prepareStmt.setLong(3, assignmentId);
				prepareStmt.setLong(4, courseId);
				rowsInserted = prepareStmt.executeUpdate();
			}
			else {
				String sql = DBUtils.INSERT_GRADES;
				prepareStmt = conn.prepareStatement(sql);
				prepareStmt.setLong(1, studentId);
				prepareStmt.setLong(2, assignmentId);
				prepareStmt.setLong(3, courseId);
				prepareStmt.setDouble(4,marksObtained);
				rowsInserted = prepareStmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return rowsInserted;
	}

	public static List<StudentGrade> getStudentGrades(int studentId, int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ASSIGNMENT_WORDKED_BY_STUDENTS;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, courseId);
			prepareStmt.setLong(2, studentId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				StudentGrade s = new StudentGrade();
				s.setStudentId(rs.getInt("STUDENT_ID"));
				s.setCourseId(rs.getInt("COURSE_ID"));
				s.setAssignmentId(rs.getInt("ASSIGNMENT_ID"));
				s.setMarks(rs.getDouble("MARKS_OBTAINED"));
				studentGrades.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return studentGrades;
	}

	public static int insertOverallGrade(double marksForAssignment, int studentId, int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		int rowsInserted = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.UPDATE_FINAL_GRADES;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setDouble(1, marksForAssignment);
			prepareStmt.setLong(2, courseId);
			prepareStmt.setLong(3, studentId);
	
			rowsInserted = prepareStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return rowsInserted;
	}

	public static double getMarksForAssignmentCourseOfStudent(int studentId, int courseId, int assignmentId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		double marks = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_GRADE_RECORDS;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setFloat(1, studentId);
			prepareStmt.setFloat(2, assignmentId);
			prepareStmt.setFloat(3, courseId);
			
			ResultSet rs = prepareStmt.executeQuery();
			if (rs.next()) {
				marks = rs.getDouble("MARKS_OBTAINED");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return marks;

	}
}
