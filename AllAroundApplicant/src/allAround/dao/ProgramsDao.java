package allAround.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import allAround.model.CIP;
import allAround.model.Programs;
import allAround.model.Schools;

/**
 * 
 * @author Xiao Ai Nov 17, 2016
 */
public class ProgramsDao {
	protected ConnectionManager connectionManager;

	private static ProgramsDao instance = null;

	protected ProgramsDao() {
		connectionManager = new ConnectionManager();
	}

	public static ProgramsDao getInstance() {
		if (instance == null) {
			instance = new ProgramsDao();
		}
		return instance;
	}

	// get program by programId
	public Programs getProgramsByProgramId(int programId) throws SQLException {
		String selectProgram = "SELECT * FROM Programs programId=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectProgram);
			selectStmt.setInt(1, programId);
			results = selectStmt.executeQuery();

			if (results.next()) {
				CIPDao cipDao = CIPDao.getInstance();
				SchoolsDao schoolsDao = SchoolsDao.getInstance();
				int year = results.getInt("Year");
				double percentage = results.getDouble("Percentage");
				boolean cert1 = results.getBoolean("Cert1");
				boolean cert2 = results.getBoolean("Cert2");
				boolean cert4 = results.getBoolean("Cert4");
				boolean associate = results.getBoolean("Associate");
				boolean bachelor = results.getBoolean("Bachelor");

				CIP cip = cipDao.getCipByCipCode(results.getInt("CipCode"));
				Schools school = schoolsDao.getSchoolById(results.getInt("UnitId"));

				Programs program = new Programs(programId, year, percentage, cert1, cert2, cert4, associate, bachelor,
						cip, school);
				return program;

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

	// get programs by schoolId
	public List<Programs> getProgramsBySchoolId(int unitId) throws SQLException {
		String selectPrograms = "SELECT * FROM Programs WHERE UnitId=?;";
		List<Programs> programs = new ArrayList<Programs>();

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrograms);
			selectStmt.setInt(1, unitId);
			results = selectStmt.executeQuery();

			while (results.next()) {
				CIPDao cipDao = CIPDao.getInstance();
				SchoolsDao schoolsDao = SchoolsDao.getInstance();
				int programId = results.getInt("programId");
				int year = results.getInt("Year");
				double percentage = results.getDouble("Percentage");
				boolean cert1 = results.getBoolean("Cert1");
				boolean cert2 = results.getBoolean("Cert2");
				boolean cert4 = results.getBoolean("Cert4");
				boolean associate = results.getBoolean("Associate");
				boolean bachelor = results.getBoolean("Bachelor");

				CIP cip = cipDao.getCipByCipCode(results.getInt("CipCode"));
				Schools school = schoolsDao.getSchoolById(unitId);

				Programs program = new Programs(programId, year, percentage, cert1, cert2, cert4, associate, bachelor,
						cip, school);

				programs.add(program);
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
		return programs;
	}

	// get programs by school name and program name
	public List<Programs> getProgramsBySchoolNameAndProgramName(String schoolName, String programName)
			throws SQLException {
		String selectPrograms = "SELECT Year, Percentage, Cert1, Cert2, Cert4, Associate, Bachelor, CIP.Title, ProgramId, CIP.CipCode  "
				+ "FROM Programs INNER JOIN CIP ON Programs.CipCode=CIP.CipCode INNER JOIN Schools "
				+ "ON Programs.UnitId=Schools.UnitId WHERE CIP.Title=? AND Schools.Name=?;";
		List<Programs> programs = new ArrayList<Programs>();

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrograms);
			selectStmt.setString(1, programName);
			selectStmt.setString(2, schoolName);
			results = selectStmt.executeQuery();

			while (results.next()) {
				CIPDao cipDao = CIPDao.getInstance();
				SchoolsDao schoolsDao = SchoolsDao.getInstance();
				int programId = results.getInt("programId");
				int year = results.getInt("Year");
				double percentage = results.getDouble("Percentage");
				boolean cert1 = results.getBoolean("Cert1");
				boolean cert2 = results.getBoolean("Cert2");
				boolean cert4 = results.getBoolean("Cert4");
				boolean associate = results.getBoolean("Associate");
				boolean bachelor = results.getBoolean("Bachelor");

				CIP cip = cipDao.getCipByCipCode(results.getInt("CipCode"));
				Schools school = schoolsDao.getSchoolBySchoolName(schoolName);

				Programs program = new Programs(programId, year, percentage, cert1, cert2, cert4, associate, bachelor,
						cip, school);

				programs.add(program);
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
		return programs;
	}

}
