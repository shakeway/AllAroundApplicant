package allAround.dao;

import allAround.model.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class CompletionDao {
	protected ConnectionManager connectionManager;
	
	private static CompletionDao instance = null;
	protected CompletionDao(){
		connectionManager = new ConnectionManager();
	}
	
	public static CompletionDao getInstance(){
		if(instance == null) {
			instance = new CompletionDao();
		}
		return instance;
	}
	
	public Completion create(Completion completion) throws SQLException {
		String insertcompletion = 
				"INSERT INTO Completion(year,completionratesuppressedoverall1,"
				+ "completionratesuppressedoverall2,completionrate4yr150nt,"
				+ "completionratelessthan4yr150nt,unitid) "
				+ "VALUES(?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertcompletion,
				Statement.RETURN_GENERATED_KEYS);
			insertStmt.setInt(1, completion.getYear());
            insertStmt.setString(2, completion.getCompletionratesuppressedoverall1());
            insertStmt.setString(3, completion.getCompletionratesuppressedoverall2());
            insertStmt.setString(4, completion.getCompletionrate4yr150nt());
            insertStmt.setString(5, completion.getCompletionratelessthan4yr150nt());
            insertStmt.setInt(6, completion.getSchool().getUnitId());
            insertStmt.executeUpdate();
			
			resultKey = insertStmt.getGeneratedKeys();
			int reviewId = -1;
			if(resultKey.next()) {
				reviewId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			completion.setCompletionid(reviewId);
			return completion;
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
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}
	
	public Completion getCompletionByCompletionId(int completionId) throws SQLException {
		String selectcompletion =
			"SELECT completionId,year,completionratesuppressedoverall1,"
				+ "completionratesuppressedoverall2,completionrate4yr150nt,"
				+ "completionratelessthan4yr150nt,unitid " +
			"FROM Completion " +
			"WHERE completionId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectcompletion);
			selectStmt.setInt(1, completionId);
			results = selectStmt.executeQuery();
			SchoolsDao schoolDao = SchoolsDao.getInstance();

			if(results.next()) {
				int year = results.getInt("year");
				String completionratesuppressedoverall1 = results.getString("completionratesuppressedoverall1");
                String completionratesuppressedoverall2 = results.getString("completionratesuppressedoverall2");
                String completionrate4yr150nt = results.getString("completionrate4yr150nt");
                String completionratelessthan4yr150nt = results.getString("completionratelessthan4yr150nt");
                int unitid = results.getInt("unitid");
                Schools school = schoolDao.getSchoolById(unitid);
				
				Completion completion = new Completion(completionId, year, completionratesuppressedoverall1,
	                     completionratesuppressedoverall2, completionrate4yr150nt,
	                     completionratelessthan4yr150nt, school);
				return completion;
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

	public List<Completion> getCompletionBySchoolName(String name) throws SQLException {
		SchoolsDao schoolsDao = SchoolsDao.getInstance();
		int unitId = schoolsDao.getSchoolBySchoolName(name).getUnitId();
		return getCompletionBySchoolId(unitId);
	}
	
	public List<Completion> getCompletionBySchoolId(int unitid) throws SQLException {
		List<Completion> completions = new ArrayList<Completion>();
		String selectcompletion =
			"SELECT completionId,year,completionratesuppressedoverall1,"
				+ "completionratesuppressedoverall2,completionrate4yr150nt,"
				+ "completionratelessthan4yr150nt,unitid " +
			"FROM Completion " +
			"WHERE unitid=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectcompletion);
			selectStmt.setInt(1, unitid);
			results = selectStmt.executeQuery();
			SchoolsDao schoolDao = SchoolsDao.getInstance();

			while (results.next()) {
				int completionid = results.getInt("completionid");
                int year = results.getInt("year");
                String completionratesuppressedoverall1 = results.getString("completionratesuppressedoverall1");
                String completionratesuppressedoverall2 = results.getString("completionratesuppressedoverall2");
                String completionrate4yr150nt = results.getString("completionrate4yr150nt");
                String completionratelessthan4yr150nt = results.getString("completionratelessthan4yr150nt");
                Schools school = schoolDao.getSchoolById(unitid);
                
                Completion completion = new Completion(completionid, year, completionratesuppressedoverall1,
                     completionratesuppressedoverall2, completionrate4yr150nt,
                     completionratelessthan4yr150nt, school);
                completions.add(completion);
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
		return completions;
	}
	
	
	public Completion delete(Completion completion) throws SQLException {
		String deletecompletion = "DELETE FROM Completion WHERE completionid=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deletecompletion);
			deleteStmt.setInt(1, completion.getCompletionid());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Restaurants instance.
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
	
}
