package allAround.dao;
import allAround.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministratorsDao extends UsersDao{
	private static AdministratorsDao instance = null;
	protected AdministratorsDao() {
		super();
	}
	public static AdministratorsDao getInstance() {
		if(instance == null) {
			instance = new AdministratorsDao();
		}
		return instance;
	}
	
	public Administrators create(Administrators administrator) throws SQLException {
		// Insert into the superclass table first.
		create(new Users(administrator.getUserName(), administrator.getPassword(), 
				         administrator.getFirstName(), administrator.getLastName(),
				         administrator.getEmail(), administrator.getPhone()));

		String insertAdministrator = "INSERT INTO Administrators(UserName,loginTime) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAdministrator);
			insertStmt.setString(1, administrator.getUserName());
			insertStmt.setTimestamp(2, new Timestamp(administrator.getLogInTime().getTime()));
			insertStmt.executeUpdate();
			return administrator;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	
	public Administrators updateFirstName(Administrators administrator, String newFirstName) throws SQLException{
		super.updateFirstName(administrator, newFirstName);
		return administrator;
	}
	
	public Administrators updateLastName(Administrators administrator, String newLastName) throws SQLException{
        super.updateLastName(administrator, newLastName);
        return administrator;
    }
	
	public Administrators updatePassword(Administrators administrator, String newPassword) throws SQLException{
		super.updatePassword(administrator, newPassword);
		return administrator;
	}
	
	public Administrators updateEmail(Administrators administrator, String newEmail) throws SQLException{
        super.updateEmail(administrator, newEmail);
        return administrator;
    }
	
	public Administrators updatePhone(Administrators administrator, String newPhone) throws SQLException{
        super.updatePhone(administrator, newPhone);
        return administrator;
    }
	
	public Administrators delete(Administrators administrator) throws SQLException {
			String deleteAdministrator = "DELETE FROM Administrators WHERE UserName=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteAdministrator);
				deleteStmt.setString(1, administrator.getUserName());
				deleteStmt.executeUpdate();

				// Then also delete from the superclass.
				// Note: due to the fk constraint (ON DELETE CASCADE), we could simply call
				// super.delete() without even needing to delete from Administrators first.
				super.delete(administrator);

				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(deleteStmt != null) {
					deleteStmt.close();
				}
			}
	}
	
	public Administrators getAdministratorByUserName(String userName) throws SQLException {
		// To build an Administrator object, we need the Persons record, too.
		String selectAdministrator =
			"SELECT Administrators.UserName AS UserName, Password, FirstName, LastName, Email, Phone, LoginTime " +
			"FROM Administrators INNER JOIN Users " +
			"  ON Administrators.UserName = Users.UserName " +
			"WHERE Administrators.UserName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAdministrator);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultUserName = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				String phone = results.getString("Phone");
				Date loginTime = new Date(results.getTimestamp("LoginTime").getTime());
				Administrators administrator = new Administrators(resultUserName, password, firstName, lastName, email, phone, loginTime);
				return administrator;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}


}
