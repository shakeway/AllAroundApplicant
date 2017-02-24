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

public class NormalUsersDao extends UsersDao{
	private static NormalUsersDao instance = null;
	protected NormalUsersDao() {
		super();
	}
	public static NormalUsersDao getInstance() {
		if(instance == null) {
			instance = new NormalUsersDao();
		}
		return instance;
	}
	
	public NormalUsers create(NormalUsers normalUser) throws SQLException {
		// Insert into the superclass table first.
		create(new Users(normalUser.getUserName(), normalUser.getPassword(), 
                		normalUser.getFirstName(), normalUser.getLastName(),
                		normalUser.getEmail(), normalUser.getPhone()));

		String insertNormalUser = "INSERT INTO NormalUsers(UserName,DoB,Status) VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertNormalUser);
			insertStmt.setString(1, normalUser.getUserName());
			insertStmt.setTimestamp(2, new Timestamp(normalUser.getDOB().getTime()));
			insertStmt.setString(3, normalUser.getStatus().name());
			insertStmt.executeUpdate();
			return normalUser;
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
	
	public NormalUsers delete(NormalUsers normalUser) throws SQLException {
		String deleteNormalUser = "DELETE FROM NormalUsers WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteNormalUser);
			deleteStmt.setString(1, normalUser.getUserName());
			int affectedRows = deleteStmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("No records available to delete for UserName=" + normalUser.getUserName());
			}
			super.delete(normalUser);

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
	
	public NormalUsers getNormalUserByUserName(String userName) throws SQLException {
        // To build an NormalUser object, we need the Persons record, too.
        String selectNormalUser =
            "SELECT NormalUsers.UserName AS UserName, Password, FirstName, LastName, Email, Phone, DOB, Status " +
            "FROM NormalUsers INNER JOIN Users " +
            "  ON NormalUsers.UserName = Users.UserName " +
            "WHERE NormalUsers.UserName=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectNormalUser);
            selectStmt.setString(1, userName);
            results = selectStmt.executeQuery();
            if(results.next()) {
                String resultUserName = results.getString("UserName");
                String password = results.getString("Password");
                String firstName = results.getString("FirstName");
                String lastName = results.getString("LastName");
                String email = results.getString("Email");
                String phone = results.getString("Phone");
                Date dob = new Date(results.getTimestamp("DOB").getTime());
                NormalUsers.Status status = NormalUsers.Status.valueOf(results.getString("Status"));
                NormalUsers normalUser = new NormalUsers(resultUserName, password, firstName, lastName, email, phone, dob, status);
                return normalUser;
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
	
    public NormalUsers updateFirstName(NormalUsers normalUser, String newFirstName) throws SQLException{
        super.updateFirstName(normalUser, newFirstName);
        return normalUser;
    }
    
    public NormalUsers updateLastName(NormalUsers normalUser, String newLastName) throws SQLException{
        super.updateLastName(normalUser, newLastName);
        return normalUser;
    }
    
    public NormalUsers updatePassword(NormalUsers normalUser, String newPassword) throws SQLException{
        super.updatePassword(normalUser, newPassword);
        return normalUser;
    }
    
    public NormalUsers updateEmail(NormalUsers normalUser, String newEmail) throws SQLException{
        super.updateEmail(normalUser, newEmail);
        return normalUser;
    }
    
    public NormalUsers updatePhone(NormalUsers normalUser, String newPhone) throws SQLException{
        super.updatePhone(normalUser, newPhone);
        return normalUser;
    }


}
