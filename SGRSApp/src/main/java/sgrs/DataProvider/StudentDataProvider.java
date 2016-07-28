package sgrs.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sgrs.Domain.StudentGrade;

public class StudentDataProvider {
	
	public static List<Integer> getRegisteredCourseList(int studentId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		List<Integer> courseIds = new ArrayList<Integer>();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_REGISTERED_COURSES;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, studentId);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				courseIds.add(rs.getInt("COURSE_ID"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return courseIds;
	}

	public static List<StudentGrade> getAllStudents() {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ALL_STUDENTS;
			prepareStmt = conn.prepareStatement(sql);
			
			ResultSet rs = prepareStmt.executeQuery();

			while (rs.next()) {
				StudentGrade s = new StudentGrade();
				s.setStudentId(rs.getInt("ID"));
				s.setFirstName(rs.getString("FIRSTNAME"));
				s.setLastName(rs.getString("LASTNAME"));
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

	public static double getFinalGrades(int studentId, int courseId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		double finalMarks = 0;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_FINAL_GRADES;
			prepareStmt = conn.prepareStatement(sql);
		
			prepareStmt.setLong(1, courseId);
			prepareStmt.setLong(2, studentId);
	
			ResultSet rs = prepareStmt.executeQuery();

			if (rs.next()) {
				finalMarks = rs.getDouble("OVERALL_MARKS");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return finalMarks;

	}

}
