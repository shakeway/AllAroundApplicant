package allAround.dao;

import allAround.model.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import allAround.dao.ConnectionManager;
import java.sql.SQLException;

public class FinancialAidDao {

	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static FinancialAidDao instance = null;

	protected FinancialAidDao() {
		connectionManager = new ConnectionManager();
	}

	public static FinancialAidDao getInstance() {
		if (instance == null) {
			instance = new FinancialAidDao();
		}
		return instance;
	}
	
	public FinancialAid create(FinancialAid financialAid) throws SQLException {
		String insertFinancialAid = "INSERT INTO FinancialAid "
				+ "(UnitId, Year, RatioFedLoan, DebtMedian, GradDebtMedian, "
				+ "LowIncomeDebtMedian, MedIncomeDebtMedian, HiIncomeDebtMedian, "
				+ "DepDebtMedian, IndepDebtMedian, FemaleDebtMedian, MaleDebtMedian) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			// Restaurants has auto-generated key. So we want to retrieve it.
			insertStmt = connection.prepareStatement(insertFinancialAid, Statement.RETURN_GENERATED_KEYS);
			// Setting inserting values
			insertStmt.setLong(1, financialAid.getSchool().getUnitId());
			insertStmt.setInt(2, financialAid.getYear());
			insertStmt.setBigDecimal(3, financialAid.getRatioFedLoan());
			insertStmt.setBigDecimal(5, financialAid.getDebtMedian());
			insertStmt.setBigDecimal(6, financialAid.getGradDebtMedian());
			insertStmt.setBigDecimal(7, financialAid.getLowIncomeDebtMedian());
			insertStmt.setBigDecimal(8, financialAid.getMedIncomeDebtMedian());
			insertStmt.setBigDecimal(9, financialAid.getHiIncomeDebtMedian());
			insertStmt.setBigDecimal(10, financialAid.getDepDebtMedian());
			insertStmt.setBigDecimal(11, financialAid.getIndepDebtMedian());
			insertStmt.setBigDecimal(12, financialAid.getFemaleDebtMedian());
			insertStmt.setBigDecimal(13, financialAid.getMaleDebtMedian());

			insertStmt.executeUpdate();

			resultKey = insertStmt.getGeneratedKeys();
			int financialAidId = -1;
			if (resultKey.next()) {
				financialAidId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			financialAid.setFinancialAidId(financialAidId);

			return financialAid;

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

	public FinancialAid getFinancialAidById(int financialAidId) throws SQLException {
		String selectFinancialAid = "SELECT " + "FinancialAidId, UnitId, Year, RatioFedLoan, DebtMedian, GradDebtMedian, "
				+ "LowIncomeDebtMedian, MedIncomeDebtMedian, HiIncomeDebtMedian, "
				+ "DepDebtMedian, IndepDebtMedian, FemaleDebtMedian, MaleDebtMedian "
				+ "FROM FinancialAid WHERE FinancialAidId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectFinancialAid);
			selectStmt.setInt(1, financialAidId);
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
				int resultFinancialAidId = results.getInt("FinancialAidId");
				int unitId = results.getInt("UnitId");
				int year = results.getInt("Year");
				BigDecimal ratioFedLoan = results.getBigDecimal("RatioFedLoan");
				BigDecimal debtMedian = results.getBigDecimal("DebtMedian");
				BigDecimal gradDebtMedian = results.getBigDecimal("GradDebtMedian");
				BigDecimal lowIncomeDebtMedian = results.getBigDecimal("LowIncomeDebtMedian");
				BigDecimal medIncomeDebtMedian = results.getBigDecimal("MedIncomeDebtMedian");
				BigDecimal hiIncomeDebtMedian = results.getBigDecimal("HiIncomeDebtMedian");
				BigDecimal depDebtMedian = results.getBigDecimal("DepDebtMedian");
				BigDecimal indepDebtMedian = results.getBigDecimal("IndepDebtMedian");
				BigDecimal femaleDebtMedian = results.getBigDecimal("FemaleDebtMedian");
				BigDecimal maleDebtMedian = results.getBigDecimal("MaleDebtMedian");

				Schools school = schoolsDao.getSchoolById(unitId);

				FinancialAid financialAid = new FinancialAid(resultFinancialAidId, school, year, ratioFedLoan,
						debtMedian, gradDebtMedian, lowIncomeDebtMedian, medIncomeDebtMedian, hiIncomeDebtMedian,
						depDebtMedian, indepDebtMedian, femaleDebtMedian, maleDebtMedian);
				return financialAid;
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
	
	public List<FinancialAid> getFinancialAidsBySchoolName(String schoolName) throws SQLException {
		SchoolsDao schoolsDao = SchoolsDao.getInstance();
		return getFinancialAidsByUnitId(schoolsDao.getSchoolBySchoolName(schoolName).getUnitId());
	}
	
	
	
	public List<FinancialAid> getFinancialAidsByUnitId(int unitId) throws SQLException {
		List<FinancialAid> financialAids = new ArrayList<FinancialAid>();
		String selectFinancialAids = "SELECT "
				+ "FinancialAidId, UnitId, Year, RatioFedLoan, DebtMedian, GradDebtMedian, "
				+ "LowIncomeDebtMedian, MedIncomeDebtMedian, HiIncomeDebtMedian, "
				+ "DepDebtMedian, IndepDebtMedian, FemaleDebtMedian, MaleDebtMedian "
				+ "FROM FinancialAid WHERE UnitId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectFinancialAids);
			selectStmt.setInt(1, unitId);
			results = selectStmt.executeQuery();
			SchoolsDao schoolsDao = SchoolsDao.getInstance();
			while (results.next()) {
				int financialAidId = results.getInt("FinancialAidId");
				int resultUnitId = results.getInt("UnitId");
				int year = results.getInt("Year");
				BigDecimal ratioFedLoan = results.getBigDecimal("RatioFedLoan");
				BigDecimal debtMedian = results.getBigDecimal("DebtMedian");
				BigDecimal gradDebtMedian = results.getBigDecimal("GradDebtMedian");
				BigDecimal lowIncomeDebtMedian = results.getBigDecimal("LowIncomeDebtMedian");
				BigDecimal medIncomeDebtMedian = results.getBigDecimal("MedIncomeDebtMedian");
				BigDecimal hiIncomeDebtMedian = results.getBigDecimal("HiIncomeDebtMedian");
				BigDecimal depDebtMedian = results.getBigDecimal("DepDebtMedian");
				BigDecimal indepDebtMedian = results.getBigDecimal("IndepDebtMedian");
				BigDecimal femaleDebtMedian = results.getBigDecimal("FemaleDebtMedian");
				BigDecimal maleDebtMedian = results.getBigDecimal("MaleDebtMedian");

				Schools school = schoolsDao.getSchoolById(resultUnitId);
				FinancialAid financialAid = new FinancialAid(financialAidId, school, year, ratioFedLoan, debtMedian,
						gradDebtMedian, lowIncomeDebtMedian, medIncomeDebtMedian, hiIncomeDebtMedian, depDebtMedian,
						indepDebtMedian, femaleDebtMedian, maleDebtMedian);
				financialAids.add(financialAid);
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
		return financialAids;
	}

	public List<FinancialAid> getFinancialAidsByYear(int year) throws SQLException {
		List<FinancialAid> financialAids = new ArrayList<FinancialAid>();
		String selectFinancialAids = "SELECT "
				+ "FinancialAidId, UnitId, Year, RatioFedLoan, DebtMedian, GradDebtMedian, "
				+ "LowIncomeDebtMedian, MedIncomeDebtMedian, HiIncomeDebtMedian, "
				+ "DepDebtMedian, IndepDebtMedian, FemaleDebtMedian, MaleDebtMedian "
				+ "FROM FinancialAid WHERE Year=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectFinancialAids);
			selectStmt.setInt(1, year);
			results = selectStmt.executeQuery();
			SchoolsDao schoolsDao = SchoolsDao.getInstance();
			while (results.next()) {
				int financialAidId = results.getInt("FinancialAidId");
				int unitId = results.getInt("UnitId");
				int resultYear = results.getInt("Year");
				BigDecimal ratioFedLoan = results.getBigDecimal("RatioFedLoan");
				BigDecimal debtMedian = results.getBigDecimal("DebtMedian");
				BigDecimal gradDebtMedian = results.getBigDecimal("GradDebtMedian");
				BigDecimal lowIncomeDebtMedian = results.getBigDecimal("LowIncomeDebtMedian");
				BigDecimal medIncomeDebtMedian = results.getBigDecimal("MedIncomeDebtMedian");
				BigDecimal hiIncomeDebtMedian = results.getBigDecimal("HiIncomeDebtMedian");
				BigDecimal depDebtMedian = results.getBigDecimal("DepDebtMedian");
				BigDecimal indepDebtMedian = results.getBigDecimal("IndepDebtMedian");
				BigDecimal femaleDebtMedian = results.getBigDecimal("FemaleDebtMedian");
				BigDecimal maleDebtMedian = results.getBigDecimal("MaleDebtMedian");

				Schools school = schoolsDao.getSchoolById(unitId);
				FinancialAid financialAid = new FinancialAid(financialAidId, school, resultYear, ratioFedLoan,
						debtMedian, gradDebtMedian, lowIncomeDebtMedian, medIncomeDebtMedian, hiIncomeDebtMedian,
						depDebtMedian, indepDebtMedian, femaleDebtMedian, maleDebtMedian);
				financialAids.add(financialAid);
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
		return financialAids;
	}

	public FinancialAid delete(FinancialAid financialAid) throws SQLException {
		String deleteFinancialAid = "DELETE FROM FinancialAid WHERE FinancialAidId = ?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteFinancialAid);
			deleteStmt.setInt(1, financialAid.getFinancialAidId());
			int affectedRows = deleteStmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(
						"No records available to delete for FinancialAidId=" + financialAid.getFinancialAidId());
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
