package sgrs.DataProvider;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;

public class DBUtils {

	// Add the Oracle JDBC Jars in your build path
	public static final String ORA_DB_DRIVER = "oracle.jdbc.OracleDriver";

	// Get the connection url from your SQL Developer connections
	// jdbc:oracle:thin:@//<HOST_NAME>:<PORT_NUMBER>/<SID>
	//"jdbc:mysql://127.7.14.2:3306/sgrs";
	protected static final String DB_CONNECTION_URL = "jdbc:oracle:thin:@//localhost:1521/xe";

	// Specify the User Name and Password of the selected Connection
	protected static final String DB_USERNAME = "SGRS";
	protected static final String DB_PASSWORD = "SGRS";

	// Query for Account
	protected static final String GET_LOGIN_FROM_USERNAME_PASSWORD = "Select * from LOGIN where USERNAME = ? and PASSWORD = ?";
	protected static final String GET_ROLE_FROM_ID = "Select role from LOGIN where ID = ?";
	protected static final String GET_STUDENTDETAILS_FROM_ID = "Select FIRSTNAME, LASTNAME, EMAIL from STUDENT where ID = ?";
	protected static final String GET_PROFESSORDETAILS_FROM_ID = "Select * from STAFF where ID = ?";
	
	// Query for Professor
	protected static final String INSERT_COURSE = "INSERT INTO COURSE (CODE, DESCRIPTION, STAFF_ID, TERM, NAME) VALUES (?, ? ,?, ?, ?)";	
	protected static final String GET_COURSEID_FROM_CODE_TERM = "Select ID from COURSE where CODE = ? and TERM = ?";
	protected static final String  GET_STUDENTID_FROM_NAME = "Select ID from STUDENT where FIRSTNAME = ? and LASTNAME = ? ";
	protected static final String INSERT_STUDENT_IN_STUDENTBOOK = "INSERT INTO STUDENT_BOOK (STUDENT_ID, STAFF_ID, COURSE_ID, TERM) VALUES (?, ? ,?, ?)";
	protected static final String INSERT_ASSIGNMENT = "INSERT INTO ASSIGNMENT (COURSE_ID, TOTAL_MARKS, PERCENTAGE, NAME, DESCRIPTION) VALUES (?, ? ,?, ?, ?)";
	protected static final String GET_PERCENT_FOR_COURSEID = "Select PERCENTAGE from ASSIGNMENT where COURSE_ID = ? ";
	protected static final String GET_ALLCOURSES_FOR_STAFF = "Select * from COURSE where STAFF_ID = ?";
	protected static final String GET_COURSE_FOR_COURSEID = "Select * from COURSE where ID = ?";
	protected static final String GET_ALL_ASSIGNMENT_FOR_COURSEID = "Select * from ASSIGNMENT where COURSE_ID = ?";
	protected static final String GET_ASSIGNMENT_BY_ID = "Select * from ASSIGNMENT where ID = ?";
	protected static final String GET_ALL_STUDENTS_FOR_COURSEID = "Select * from STUDENT where ID IN ( Select STUDENT_ID from STUDENT_BOOK where COURSE_ID = ?)";
	protected static final String INSERT_GRADES = "INSERT INTO GRADE (STUDENT_ID, ASSIGNMENT_ID, COURSE_ID, MARKS_OBTAINED) VALUES ( ? ,?, ?, ?)";
	protected static final String GET_ASSIGNMENT_WORDKED_BY_STUDENTS = "Select * from GRADE where COURSE_ID = ? and STUDENT_ID = ? ";
	protected static final String UPDATE_FINAL_GRADES = "UPDATE STUDENT_BOOK SET OVERALL_MARKS = ? WHERE COURSE_ID = ? and STUDENT_ID = ?";
	protected static final String GET_GRADE_RECORDS = "Select * from GRADE where STUDENT_ID = ? and ASSIGNMENT_ID = ? and COURSE_ID = ?";
	protected static final String UPDATE_GRADES = "UPDATE GRADE SET MARKS_OBTAINED = ? WHERE STUDENT_ID = ? and ASSIGNMENT_ID = ? and COURSE_ID = ?";
	
	
	// Query for Student
	protected static final String GET_REGISTERED_COURSES = "SELECT COURSE_ID from STUDENT_BOOK WHERE STUDENT_ID = ?";
	protected static final String GET_ALL_STUDENTS = "Select * from STUDENT";
	protected static final String GET_FINAL_GRADES = "SELECT OVERALL_MARKS from STUDENT_BOOK WHERE COURSE_ID = ? and STUDENT_ID = ?";
	
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
