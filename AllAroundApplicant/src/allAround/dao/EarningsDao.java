package allAround.dao;

import allAround.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class EarningsDao {
	protected ConnectionManager connectionManager;

	private static EarningsDao instance = null;
	protected EarningsDao(){
		connectionManager = new ConnectionManager();
	}

	public static EarningsDao getInstance(){
		if(instance == null) {
			instance = new EarningsDao();
		}
		return instance;
	}

	public Earnings create(Earnings earnings) throws SQLException {
		String insertearnings =
                "INSERT INTO Earnings(year,studentcount,"
                + "earnings10yrsafterentrymedian,earnings10yrsafternotenrolledmeanearnings,"
                + "earnings6yrsafterentrymedian,earnings6yrsafternotenrolledmeanearnings,unitid) "
                + "VALUES(?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertearnings,
				Statement.RETURN_GENERATED_KEYS);
			insertStmt.setInt(1, earnings.getYear());
            insertStmt.setInt(2, earnings.getStudentCount());
            insertStmt.setInt(3, earnings.getEarnings10YrsAfterEntryMedian());
            insertStmt.setInt(4, earnings.getEarnings10YrsAfterNotEnrolledMeanEarnings());
            insertStmt.setInt(5, earnings.getEarnings6YrsAfterEntryMedian());
            insertStmt.setInt(6, earnings.getEarnings6YrsAfterNotEnrolledMeanEarnings());
            insertStmt.setInt(7, earnings.getSchool().getUnitId());
			insertStmt.executeUpdate();

			resultKey = insertStmt.getGeneratedKeys();
			int earningId = -1;
			if(resultKey.next()) {
				earningId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			earnings.setEarningsId(earningId);
			return earnings;
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


	public Earnings getEarningsByEarningsId(int earningsid) throws SQLException {
		String insertearnings =
            "SELECT earningsid,year,studentcount,"
                + "earnings10yrsafterentrymedian,earnings10yrsafternotenrolledmeanearnings,"
                + "earnings6yrsafterentrymedian,earnings6yrsafternotenrolledmeanearnings,unitid " +
            "FROM Earnings " +
            "WHERE earningsid=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(insertearnings);
			selectStmt.setInt(1, earningsid);
			results = selectStmt.executeQuery();
			SchoolsDao schoolDao = SchoolsDao.getInstance();

			if(results.next()) {
				int year = results.getInt("year");
                int studentcount = results.getInt("studentcount");
                int earnings10yrsafterentrymedian = results.getInt("earnings10yrsafterentrymedian");
                int earnings10yrsafternotenrolledmeanearnings = results.getInt("earnings10yrsafternotenrolledmeanearnings");
                int earnings6yrsafterentrymedian = results.getInt("earnings6yrsafterentrymedian");
                int earnings6yrsafternotenrolledmeanearnings = results.getInt("earnings6yrsafternotenrolledmeanearnings");
                int unitid = results.getInt("unitid");
                Schools school = schoolDao.getSchoolById(unitid);

				Earnings earnings = new Earnings(earningsid, year, studentcount, earnings10yrsafterentrymedian,
                     earnings10yrsafternotenrolledmeanearnings, earnings6yrsafterentrymedian,
                     earnings6yrsafternotenrolledmeanearnings, school);
				return earnings;
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
	
	public List<Earnings> getEarningsBySchoolName(String name) throws SQLException {
		SchoolsDao schoolsDao = SchoolsDao.getInstance();
		return getEarningsBySchoolId(schoolsDao.getSchoolBySchoolName(name).getUnitId());
	}
	
	
	public List<Earnings> getEarningsBySchoolId(int unitid) throws SQLException {
		List<Earnings> earningsList = new ArrayList<Earnings>();
		String insertearnings =
            "SELECT earningsid,year,studentcount,"
                + "earnings10yrsafterentrymedian,earnings10yrsafternotenrolledmeanearnings,"
                + "earnings6yrsafterentrymedian,earnings6yrsafternotenrolledmeanearnings,unitid " +
            "FROM Earnings " +
            "WHERE unitid=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(insertearnings);
			selectStmt.setInt(1, unitid);
			results = selectStmt.executeQuery();
			SchoolsDao schoolDao = SchoolsDao.getInstance();

			while(results.next()) {
				int earningsid = results.getInt("earningsid");
                int year = results.getInt("year");
                int studentcount = results.getInt("studentcount");
                int earnings10yrsafterentrymedian = results.getInt("earnings10yrsafterentrymedian");
                int earnings10yrsafternotenrolledmeanearnings = results.getInt("earnings10yrsafternotenrolledmeanearnings");
                int earnings6yrsafterentrymedian = results.getInt("earnings6yrsafterentrymedian");
                int earnings6yrsafternotenrolledmeanearnings = results.getInt("earnings6yrsafternotenrolledmeanearnings");
                Schools school = schoolDao.getSchoolById(unitid);

                Earnings earnings = new Earnings(earningsid, year, studentcount, earnings10yrsafterentrymedian,
                     earnings10yrsafternotenrolledmeanearnings, earnings6yrsafterentrymedian,
                     earnings6yrsafternotenrolledmeanearnings, school);
				earningsList.add(earnings);
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
		return earningsList;
	}

	public Earnings delete(Earnings earnings) throws SQLException {
		String deleteearnings = "DELETE FROM Earnings WHERE earningsid=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteearnings);
			deleteStmt.setInt(1, earnings.getEarningsId());
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
