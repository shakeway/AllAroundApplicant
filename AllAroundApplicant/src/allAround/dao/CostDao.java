package allAround.dao;

import allAround.model.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import allAround.dao.ConnectionManager;

public class CostDao {
	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static CostDao instance = null;

	protected CostDao() {
		connectionManager = new ConnectionManager();
	}

	public static CostDao getInstance() {
		if (instance == null) {
			instance = new CostDao();
		}
		return instance;
	}
	
	public Cost create(Cost cost) throws SQLException {
		String insertCost = "INSERT INTO Cost " +
				"(UnitId, Year, AnnualCost, TuitionInState, " +
				"TuitionOutState, NetPriceAverage, NetPriceFamily1, " +
				"NetPriceFamily2, NetPriceFamily3, NetPriceFamily4, " + 
				"NetPriceFamily5) " +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			// Restaurants has auto-generated key. So we want to retrieve it.
			insertStmt = connection.prepareStatement(insertCost, Statement.RETURN_GENERATED_KEYS);
			// Setting inserting values
			insertStmt.setInt(1, cost.getSchool().getUnitId());
			insertStmt.setInt(2, cost.getYear());
			insertStmt.setInt(3, cost.getAnnualCost());
			insertStmt.setInt(4, cost.getTuitionInState());
			insertStmt.setInt(5, cost.getTuitionOutState());
			insertStmt.setInt(6, cost.getNetPriceAverage());
			insertStmt.setInt(7, cost.getNetPriceFamily1());
			insertStmt.setInt(8, cost.getNetPriceFamily2());
			insertStmt.setInt(9, cost.getNetPriceFamily3());
			insertStmt.setInt(10, cost.getNetPriceFamily4());
			insertStmt.setInt(11, cost.getNetPriceFamily5());
			
			insertStmt.executeUpdate();

			resultKey = insertStmt.getGeneratedKeys();
			int costId = -1;
			if (resultKey.next()) {
				costId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			cost.setCostId(costId);
			return cost;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
			if (resultKey != null) {
				resultKey.close();
			}
		}
			
	}
	
	
	public Cost getCostById(int costId) throws SQLException {
		String selectCost = "SELECT " 
				+ "CostId, UnitId, Year, AnnualCost, TuitionInState, " 
				+ "TuitionOutState, NetPriceAverage, NetPriceFamily1, " 
				+ "NetPriceFamily2, NetPriceFamily3, NetPriceFamily4, " 
				+ "NetPriceFamily5 "
				+ "FROM Cost "
				+ "WHERE CostId = ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCost);
			selectStmt.setInt(1, costId);
			// Note that we call executeQuery(). This is used for a SELECT
			// statement
			// because it returns a result set. For more information, see:
			// http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
			// http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
			results = selectStmt.executeQuery();
			SchoolsDao schoolsDao = SchoolsDao.getInstance();
			// You can iterate the result set (although the example below only
			// retrieves
			// the first record). The cursor is initially positioned before the
			// row.
			// Furthermore, you can retrieve fields by name and by type.
			if (results.next()) {
				int resultCostId = results.getInt("CostId");
				int unitId = results.getInt("UnitId");
				int year = results.getInt("Year");
				int annualCost = results.getInt("AnnualCost");
				int tuitionInState = results.getInt("TuitionInState");
				int tuitionOutState = results.getInt("TuitionOutState");
				int netPriceAverage = results.getInt("NetPriceAverage");
				int netPriceFamily1 = results.getInt("NetPriceFamily1");
				int netPriceFamily2 = results.getInt("NetPriceFamily2");
				int netPriceFamily3 = results.getInt("NetPriceFamily3");
				int netPriceFamily4 = results.getInt("NetPriceFamily4");
				int netPriceFamily5 = results.getInt("NetPriceFamily5");
				

				Schools school = schoolsDao.getSchoolById(unitId);
				Cost cost = new Cost(resultCostId, school, year, annualCost, 
						tuitionInState, tuitionOutState, netPriceAverage, netPriceFamily1,
						netPriceFamily2, netPriceFamily3, netPriceFamily4, netPriceFamily5);

	
				return cost;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
		
	}
	
	public List<Cost> getCostsBySchoolName(String schoolName) throws SQLException {
		SchoolsDao schoolsDao = SchoolsDao.getInstance();
		return getCostsByUnitId(schoolsDao.getSchoolBySchoolName(schoolName).getUnitId());
	}
	
	
	public List<Cost> getCostsByUnitId(int unitId) throws SQLException{
		List<Cost> costs = new ArrayList<Cost>();
		String selectCosts = "SELECT " 
				+ "CostId, UnitId, Year, AnnualCost, TuitionInState, " 
				+ "TuitionOutState, NetPriceAverage, NetPriceFamily1, " 
				+ "NetPriceFamily2, NetPriceFamily3, NetPriceFamily4, " 
				+ "NetPriceFamily5 "
				+ "FROM Cost "
				+ "WHERE UnitId = ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCosts);
			selectStmt.setInt(1, unitId);
			results = selectStmt.executeQuery();
			SchoolsDao schoolsDao = SchoolsDao.getInstance();
			while (results.next()) {
				int costId = results.getInt("CostId");
				int resultUnitId = results.getInt("UnitId");
				int year = results.getInt("Year");
				int annualCost = results.getInt("AnnualCost");
				int tuitionInState = results.getInt("TuitionInState");
				int tuitionOutState = results.getInt("TuitionOutState");
				int netPriceAverage = results.getInt("NetPriceAverage");
				int netPriceFamily1 = results.getInt("NetPriceFamily1");
				int netPriceFamily2 = results.getInt("NetPriceFamily2");
				int netPriceFamily3 = results.getInt("NetPriceFamily3");
				int netPriceFamily4 = results.getInt("NetPriceFamily4");
				int netPriceFamily5 = results.getInt("NetPriceFamily5");
				

				Schools school = schoolsDao.getSchoolById(resultUnitId);
				Cost cost = new Cost(costId, school, year, annualCost, 
						tuitionInState, tuitionOutState, netPriceAverage, netPriceFamily1,
						netPriceFamily2, netPriceFamily3, netPriceFamily4, netPriceFamily5);

				costs.add(cost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return costs;
	}
	
	public List<Cost> getCostsByYear(int year) throws SQLException{
		List<Cost> costs = new ArrayList<Cost>();
		String selectCosts = "SELECT " 
				+ "CostId, UnitId, Year, AnnualCost, TuitionInState, " 
				+ "TuitionOutState, NetPriceAverage, NetPriceFamily1, " 
				+ "NetPriceFamily2, NetPriceFamily3, NetPriceFamily4, " 
				+ "NetPriceFamily5 "
				+ "FROM Cost "
				+ "WHERE Year = ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCosts);
			selectStmt.setInt(1, year);
			results = selectStmt.executeQuery();
			SchoolsDao schoolsDao = SchoolsDao.getInstance();
			while (results.next()) {
				int costId = results.getInt("CostId");
				int unitId = results.getInt("UnitId");
				int resultYear = results.getInt("Year");
				int annualCost = results.getInt("AnnualCost");
				int tuitionInState = results.getInt("TuitionInState");
				int tuitionOutState = results.getInt("TuitionOutState");
				int netPriceAverage = results.getInt("NetPriceAverage");
				int netPriceFamily1 = results.getInt("NetPriceFamily1");
				int netPriceFamily2 = results.getInt("NetPriceFamily2");
				int netPriceFamily3 = results.getInt("NetPriceFamily3");
				int netPriceFamily4 = results.getInt("NetPriceFamily4");
				int netPriceFamily5 = results.getInt("NetPriceFamily5");
				

				Schools school = schoolsDao.getSchoolById(unitId);
				Cost cost = new Cost(costId, school, resultYear, annualCost, 
						tuitionInState, tuitionOutState, netPriceAverage, netPriceFamily1,
						netPriceFamily2, netPriceFamily3, netPriceFamily4, netPriceFamily5);

				costs.add(cost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return costs;
	}
	
	public Cost delete(Cost cost) throws SQLException {
		String deleteCost = "DELETE FROM Cost WHERE CostId = ?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteCost);
			deleteStmt.setInt(1, cost.getCostId());
			int affectedRows = deleteStmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(
						"No records available to delete for CostId=" + cost.getCostId());
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

}
