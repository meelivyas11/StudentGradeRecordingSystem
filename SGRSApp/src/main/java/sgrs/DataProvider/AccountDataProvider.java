package sgrs.DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sgrs.Domain.User;

public class AccountDataProvider {
	
	public static User getRoleFromUserNamePassword(String uName, String pass) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		User user = new User();
		try {
			// STEP 1: Register JDBC driver
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();

			// STEP 2: Open a connection
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			// STEP 3: Execute a query
			String sql = DBUtils.GET_LOGIN_FROM_USERNAME_PASSWORD;
			prepareStmt = conn.prepareStatement(sql);

			prepareStmt.setString(1, uName);
			prepareStmt.setString(2, pass);
			
			ResultSet rs = prepareStmt.executeQuery();

			// STEP 4: Extract data from result set
			while (rs.next()) {
				user.setRole(rs.getString("ROLE"));
				user.setUserId(rs.getInt("ID"));
				user = getFirstLastNameFromUserId(user);	
				} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return user;
	}
	
	/*public static String insertUser() {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		String role = "";
		try {
			// STEP 1: Register JDBC driver
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();

			// STEP 2: Open a connection
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			// STEP 3: Execute a query
			String sql = DBUtils.INSERT_RECORD;
			prepareStmt.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		return role;
	}*/

	public static String getRoleFromUserId(int userId) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		String role = "" ; 
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);

			String sql = DBUtils.GET_ROLE_FROM_ID;
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, userId);

			ResultSet rs = prepareStmt.executeQuery();
			while (rs.next()) {
				role = rs.getString("ROLE");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		
		return role;
	}
	
	public static User getFirstLastNameFromUserId(User user) {
		Connection conn = null;
		PreparedStatement prepareStmt = null;
		try {
			Class.forName(DBUtils.ORA_DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DBUtils.DB_CONNECTION_URL, DBUtils.DB_USERNAME, DBUtils.DB_PASSWORD);
			String sql = "";
			
			if(user.getRole().equals("Student"))
				sql = DBUtils.GET_STUDENTDETAILS_FROM_ID;
			else if (user.getRole().equals("Professor"))
				sql = DBUtils.GET_PROFESSORDETAILS_FROM_ID;
			
			prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setLong(1, user.getUserId());

			ResultSet rs = prepareStmt.executeQuery();
			while (rs.next()) {
				user.setFirstName(rs.getString("FIRSTNAME"));
				user.setLastName(rs.getString("LASTNAME"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(prepareStmt);
		}
		
		return user;
	}
}
