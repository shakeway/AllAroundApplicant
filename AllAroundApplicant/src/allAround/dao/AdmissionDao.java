package allAround.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import allAround.model.*;

public class AdmissionDao {
	protected ConnectionManager connectionManager;
	private static AdmissionDao instance = null;
	protected AdmissionDao() {
		connectionManager = new ConnectionManager();
	}
	public static AdmissionDao getInstance() {
		if(instance == null) {
			instance = new AdmissionDao();
		}
		return instance;
	}
	public Admission create(Admission admission) throws SQLException{
		String InsertAdmission = "INSERT INTO Admission(UnitId,Year,AdmissionRateOverall,"
				+ "AdmissionRateByOpeId,SatScores25thPercentileCriticalReading,"
				+ "SatScores75thPercentileCriticalReading,SatScores25thPercentileMath,"
				+ "SatScores75thPercentileMath,SatScores25thPercentileWriting,"
				+ "SatScores75thPercentileWriting,SatScoresMidpointCriticalReading,"
				+ "SatScoresMidpointMath,SatScoresMidpointWriting,"
				+ "ActScores25thPercentileCumulative,ActScores75thPercentileCumulative,"
				+ "ActScores25thPercentileEnglish,ActScores75thPercentileEnglish,"
				+ "ActScores25thPercentileMath,ActScores75thPercentileMath,"
				+ "ActScores25thPercentileWriting,ActScores75thPercentileWriting,"
				+ "ActScoresMidpointCumulative,ActScoresMidpointEnglish,"
				+ "ActScoresMidpointMath,ActScoresMidpointWriting,SatScoresAverageOverall,SatScoresAverageByOpeId)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(InsertAdmission,Statement.RETURN_GENERATED_KEYS);
			insertStmt.setInt(1, admission.getSchool().getUnitId());
			insertStmt.setInt(2, admission.getYear());
			insertStmt.setString(3, admission.getAdmissionRateOverall());
			insertStmt.setString(4, admission.getAdmissionRateByOpeId());
			insertStmt.setInt(5,admission.getSatScores25thPercentileCriticalReading());
			insertStmt.setInt(6,admission.getSatScores75thPercentileCriticalReading());
			insertStmt.setInt(7,admission.getSatScores25thPercentileMath());
			insertStmt.setInt(8,admission.getSatScores75thPercentileMath());
			insertStmt.setInt(9,admission.getSatScores25thPercentileWriting());
			insertStmt.setInt(10,admission.getSatScores75thPercentileWriting());
			insertStmt.setInt(11,admission.getSatScoresMidpointCriticalReading());
			insertStmt.setInt(12,admission.getSatScoresMidpointMath());
			insertStmt.setInt(13,admission.getSatScoresMidpointWriting());
			insertStmt.setInt(14,admission.getActScores25thPercentileCumulative());
			insertStmt.setInt(15,admission.getActScores75thPercentileCumulative());
			insertStmt.setInt(16,admission.getActScores25thPercentileEnglish());
			insertStmt.setInt(17,admission.getActScores75thPercentileEnglish());
			insertStmt.setInt(18,admission.getActScores25thPercentileMath());
			insertStmt.setInt(19,admission.getActScores75thPercentileMath());
			insertStmt.setInt(20,admission.getActScores25thPercentileWriting());
			insertStmt.setInt(21,admission.getActScores75thPercentileWriting());
			insertStmt.setInt(22,admission.getActScoresMidpointCumulative());
			insertStmt.setInt(23,admission.getActScoresMidpointEnglish());
			insertStmt.setInt(24,admission.getActScoresMidpointMath());
			insertStmt.setInt(25,admission.getActScoresMidpointWriting());
			insertStmt.setInt(26,admission.getSatScoresAverageOverall());
			insertStmt.setInt(27,admission.getSatScoresAverageByOpeId());
			insertStmt.executeUpdate();
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int admissionId = -1;
			if(resultKey.next()) {
				admissionId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			admission.setAdmissionId(admissionId);
			return admission;
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
	public Admission delete(Admission admission) throws SQLException{
		String deleteAdmission = "DELETE FROM Admission WHERE AdmissionId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteAdmission);
			deleteStmt.setInt(1, admission.getAdmissionId());
			deleteStmt.executeUpdate();

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
	public List<Admission> getAdmissionByUnitId(int unitId) throws SQLException {
		List<Admission> admissions = new ArrayList<Admission>();
		String selectAdmissions =
				"SELECT AdmissionId,UnitId,Year,AdmissionRateOverall,"
				+ "AdmissionRateByOpeId,SatScores25thPercentileCriticalReading,"
				+ "SatScores75thPercentileCriticalReading,SatScores25thPercentileMath,"
				+ "SatScores75thPercentileMath,SatScores25thPercentileWriting,"
				+ "SatScores75thPercentileWriting,SatScoresMidpointCriticalReading,"
				+ "SatScoresMidpointMath,SatScoresMidpointWriting,"
				+ "ActScores25thPercentileCumulative,ActScores75thPercentileCumulative,"
				+ "ActScores25thPercentileEnglish,ActScores75thPercentileEnglish,"
				+ "ActScores25thPercentileMath,ActScores75thPercentileMath,"
				+ "ActScores25thPercentileWriting,ActScores75thPercentileWriting,"
				+ "ActScoresMidpointCumulative,ActScoresMidpointEnglish,"
				+ "ActScoresMidpointMath,ActScoresMidpointWriting,SatScoresAverageOverall,SatScoresAverageByOpeId " +
				"FROM Admission " +
				"WHERE UnitId=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectAdmissions);
				selectStmt.setInt(1, unitId);
				results = selectStmt.executeQuery();
				SchoolsDao schoolsDao = SchoolsDao.getInstance();
				while(results.next()) {
					int admissionId = results.getInt("AdmissionId");
					int resultUnitId = results.getInt("UnitId");
					Schools school = schoolsDao.getSchoolById(resultUnitId);
					int year = results.getInt("Year");
					double admissionRateOverall = results.getDouble("AdmissionRateOverall");
					double admissionRateByOpeId = results.getDouble("AdmissionRateByOpeId");
					int satScores25thPercentileCriticalReading = results.getInt("SatScores25thPercentileCriticalReading");
					int satScores75thPercentileCriticalReading = results.getInt("SatScores75thPercentileCriticalReading");
					int satScores25thPercentileMath = results.getInt("SatScores25thPercentileMath");
					int satScores75thPercentileMath = results.getInt("SatScores75thPercentileMath");
					int satScores25thPercentileWriting = results.getInt("SatScores25thPercentileWriting");
					int satScores75thPercentileWriting = results.getInt("SatScores75thPercentileWriting");
					int satScoresMidpointCriticalReading = results.getInt("SatScoresMidpointCriticalReading");
					int satScoresMidpointMath = results.getInt("SatScoresMidpointMath");
					int satScoresMidpointWriting = results.getInt("SatScoresMidpointWriting");
					int actScores25thPercentileCumulative = results.getInt("ActScores25thPercentileCumulative");
					int actScores75thPercentileCumulative = results.getInt("ActScores75thPercentileCumulative");
					int actScores25thPercentileEnglish = results.getInt("ActScores25thPercentileEnglish");
					int actScores75thPercentileEnglish = results.getInt("ActScores75thPercentileEnglish");
					int actScores25thPercentileMath = results.getInt("ActScores25thPercentileMath");
					int actScores75thPercentileMath = results.getInt("ActScores75thPercentileMath");
					int actScores25thPercentileWriting = results.getInt("ActScores25thPercentileWriting");
					int actScores75thPercentileWriting = results.getInt("ActScores75thPercentileWriting");
					int actScoresMidpointCumulative = results.getInt("ActScoresMidpointCumulative");
					int actScoresMidpointEnglish = results.getInt("ActScoresMidpointEnglish");
					int actScoresMidpointMath = results.getInt("ActScoresMidpointMath");
					int actScoresMidpointWriting = results.getInt("ActScoresMidpointWriting");
					int satScoresAverageOverall = results.getInt("SatScoresAverageOverall");
					int satScoresAverageByOpeId = results.getInt("SatScoresAverageByOpeId");
					Admission admission = new Admission(
							admissionId,school,year,admissionRateOverall,admissionRateByOpeId,
							satScores25thPercentileCriticalReading,
							satScores75thPercentileCriticalReading,
							satScores25thPercentileMath,satScores75thPercentileMath,
							satScores25thPercentileWriting,satScores75thPercentileWriting,
							satScoresMidpointCriticalReading,satScoresMidpointMath,satScoresMidpointWriting,
							actScores25thPercentileCumulative,actScores75thPercentileCumulative,
							actScores25thPercentileEnglish,actScores75thPercentileEnglish,actScores25thPercentileMath,
							actScores75thPercentileMath,actScores25thPercentileWriting,actScores75thPercentileWriting,
							actScoresMidpointCumulative,actScoresMidpointEnglish,actScoresMidpointMath,actScoresMidpointWriting,
							satScoresAverageOverall,satScoresAverageByOpeId);
					admissions.add(admission);
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
			return admissions;
		}
	
	public List<Admission> getAdmissionBySATScores2014(int satMath, int satReading, int satWriting) throws SQLException {
		List<Admission> admissions = new ArrayList<Admission>();
		String selectAdmissions =
				"SELECT AdmissionId,UnitId,Year,AdmissionRateOverall,"
				+ "AdmissionRateByOpeId,SatScores25thPercentileCriticalReading,"
				+ "SatScores75thPercentileCriticalReading,SatScores25thPercentileMath,"
				+ "SatScores75thPercentileMath,SatScores25thPercentileWriting,"
				+ "SatScores75thPercentileWriting,SatScoresMidpointCriticalReading,"
				+ "SatScoresMidpointMath,SatScoresMidpointWriting,"
				+ "ActScores25thPercentileCumulative,ActScores75thPercentileCumulative,"
				+ "ActScores25thPercentileEnglish,ActScores75thPercentileEnglish,"
				+ "ActScores25thPercentileMath,ActScores75thPercentileMath,"
				+ "ActScores25thPercentileWriting,ActScores75thPercentileWriting,"
				+ "ActScoresMidpointCumulative,ActScoresMidpointEnglish,"
				+ "ActScoresMidpointMath,ActScoresMidpointWriting,SatScoresAverageOverall,SatScoresAverageByOpeId " 
				+ "FROM Admission " 
				+ "WHERE SatScores25thPercentileMath<=? AND "
				+ "SatScores25thPercentileCriticalReading<=? AND "
				+ "SatScores25thPercentileWriting<=? AND "
				+ "Year=2014 "
				+ "ORDER BY SatScores25thPercentileMath DESC, SatScores25thPercentileCriticalReading DESC, SatScores25thPercentileWriting DESC, "
				+ "AdmissionRateOverall ASC "
				+ "LIMIT 50;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectAdmissions);
				SchoolsDao schoolsDao = SchoolsDao.getInstance();
				selectStmt.setInt(1, satMath);
				selectStmt.setInt(2, satReading);
				selectStmt.setInt(3, satWriting);
				results = selectStmt.executeQuery();
				
				while(results.next()) {
					int admissionId = results.getInt("AdmissionId");
					int unitId = results.getInt("UnitId");
					Schools school = schoolsDao.getSchoolById(unitId);
					int year = results.getInt("Year");
					double admissionRateOverall = results.getDouble("AdmissionRateOverall");
					double admissionRateByOpeId = results.getDouble("AdmissionRateByOpeId");
					int satScores25thPercentileCriticalReading = results.getInt("SatScores25thPercentileCriticalReading");
					int satScores75thPercentileCriticalReading = results.getInt("SatScores75thPercentileCriticalReading");
					int satScores25thPercentileMath = results.getInt("SatScores25thPercentileMath");
					int satScores75thPercentileMath = results.getInt("SatScores75thPercentileMath");
					int satScores25thPercentileWriting = results.getInt("SatScores25thPercentileWriting");
					int satScores75thPercentileWriting = results.getInt("SatScores75thPercentileWriting");
					int satScoresMidpointCriticalReading = results.getInt("SatScoresMidpointCriticalReading");
					int satScoresMidpointMath = results.getInt("SatScoresMidpointMath");
					int satScoresMidpointWriting = results.getInt("SatScoresMidpointWriting");
					int actScores25thPercentileCumulative = results.getInt("ActScores25thPercentileCumulative");
					int actScores75thPercentileCumulative = results.getInt("ActScores75thPercentileCumulative");
					int actScores25thPercentileEnglish = results.getInt("ActScores25thPercentileEnglish");
					int actScores75thPercentileEnglish = results.getInt("ActScores75thPercentileEnglish");
					int actScores25thPercentileMath = results.getInt("ActScores25thPercentileMath");
					int actScores75thPercentileMath = results.getInt("ActScores75thPercentileMath");
					int actScores25thPercentileWriting = results.getInt("ActScores25thPercentileWriting");
					int actScores75thPercentileWriting = results.getInt("ActScores75thPercentileWriting");
					int actScoresMidpointCumulative = results.getInt("ActScoresMidpointCumulative");
					int actScoresMidpointEnglish = results.getInt("ActScoresMidpointEnglish");
					int actScoresMidpointMath = results.getInt("ActScoresMidpointMath");
					int actScoresMidpointWriting = results.getInt("ActScoresMidpointWriting");
					int satScoresAverageOverall = results.getInt("SatScoresAverageOverall");
					int satScoresAverageByOpeId = results.getInt("SatScoresAverageByOpeId");
					Admission admission = new Admission(
							admissionId,school,year,admissionRateOverall,admissionRateByOpeId,
							satScores25thPercentileCriticalReading,
							satScores75thPercentileCriticalReading,
							satScores25thPercentileMath,satScores75thPercentileMath,
							satScores25thPercentileWriting,satScores75thPercentileWriting,
							satScoresMidpointCriticalReading,satScoresMidpointMath,satScoresMidpointWriting,
							actScores25thPercentileCumulative,actScores75thPercentileCumulative,
							actScores25thPercentileEnglish,actScores75thPercentileEnglish,actScores25thPercentileMath,
							actScores75thPercentileMath,actScores25thPercentileWriting,actScores75thPercentileWriting,
							actScoresMidpointCumulative,actScoresMidpointEnglish,actScoresMidpointMath,actScoresMidpointWriting,
							satScoresAverageOverall,satScoresAverageByOpeId);
					admissions.add(admission);
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
			return admissions;
		}
	
	public List<Admission> getAdmissionBySchoolName(String schoolName) throws SQLException {
		List<Admission> admissions = new ArrayList<Admission>();
		String selectAdmissions =
				"SELECT AdmissionId,UnitId,Year,AdmissionRateOverall,"
				+ "AdmissionRateByOpeId,SatScores25thPercentileCriticalReading,"
				+ "SatScores75thPercentileCriticalReading,SatScores25thPercentileMath,"
				+ "SatScores75thPercentileMath,SatScores25thPercentileWriting,"
				+ "SatScores75thPercentileWriting,SatScoresMidpointCriticalReading,"
				+ "SatScoresMidpointMath,SatScoresMidpointWriting,"
				+ "ActScores25thPercentileCumulative,ActScores75thPercentileCumulative,"
				+ "ActScores25thPercentileEnglish,ActScores75thPercentileEnglish,"
				+ "ActScores25thPercentileMath,ActScores75thPercentileMath,"
				+ "ActScores25thPercentileWriting,ActScores75thPercentileWriting,"
				+ "ActScoresMidpointCumulative,ActScoresMidpointEnglish,"
				+ "ActScoresMidpointMath,ActScoresMidpointWriting,SatScoresAverageOverall,SatScoresAverageByOpeId " +
				"FROM Admission " +
				"WHERE UnitId=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectAdmissions);
				SchoolsDao schoolsDao = SchoolsDao.getInstance();
				int unitId = schoolsDao.getSchoolBySchoolName(schoolName).getUnitId();
				selectStmt.setInt(1, unitId);
				results = selectStmt.executeQuery();
				
				while(results.next()) {
					int admissionId = results.getInt("AdmissionId");
					int resultUnitId = results.getInt("UnitId");
					Schools school = schoolsDao.getSchoolById(resultUnitId);
					int year = results.getInt("Year");
					double admissionRateOverall = results.getDouble("AdmissionRateOverall");
					double admissionRateByOpeId = results.getDouble("AdmissionRateByOpeId");
					int satScores25thPercentileCriticalReading = results.getInt("SatScores25thPercentileCriticalReading");
					int satScores75thPercentileCriticalReading = results.getInt("SatScores75thPercentileCriticalReading");
					int satScores25thPercentileMath = results.getInt("SatScores25thPercentileMath");
					int satScores75thPercentileMath = results.getInt("SatScores75thPercentileMath");
					int satScores25thPercentileWriting = results.getInt("SatScores25thPercentileWriting");
					int satScores75thPercentileWriting = results.getInt("SatScores75thPercentileWriting");
					int satScoresMidpointCriticalReading = results.getInt("SatScoresMidpointCriticalReading");
					int satScoresMidpointMath = results.getInt("SatScoresMidpointMath");
					int satScoresMidpointWriting = results.getInt("SatScoresMidpointWriting");
					int actScores25thPercentileCumulative = results.getInt("ActScores25thPercentileCumulative");
					int actScores75thPercentileCumulative = results.getInt("ActScores75thPercentileCumulative");
					int actScores25thPercentileEnglish = results.getInt("ActScores25thPercentileEnglish");
					int actScores75thPercentileEnglish = results.getInt("ActScores75thPercentileEnglish");
					int actScores25thPercentileMath = results.getInt("ActScores25thPercentileMath");
					int actScores75thPercentileMath = results.getInt("ActScores75thPercentileMath");
					int actScores25thPercentileWriting = results.getInt("ActScores25thPercentileWriting");
					int actScores75thPercentileWriting = results.getInt("ActScores75thPercentileWriting");
					int actScoresMidpointCumulative = results.getInt("ActScoresMidpointCumulative");
					int actScoresMidpointEnglish = results.getInt("ActScoresMidpointEnglish");
					int actScoresMidpointMath = results.getInt("ActScoresMidpointMath");
					int actScoresMidpointWriting = results.getInt("ActScoresMidpointWriting");
					int satScoresAverageOverall = results.getInt("SatScoresAverageOverall");
					int satScoresAverageByOpeId = results.getInt("SatScoresAverageByOpeId");
					Admission admission = new Admission(
							admissionId,school,year,admissionRateOverall,admissionRateByOpeId,
							satScores25thPercentileCriticalReading,
							satScores75thPercentileCriticalReading,
							satScores25thPercentileMath,satScores75thPercentileMath,
							satScores25thPercentileWriting,satScores75thPercentileWriting,
							satScoresMidpointCriticalReading,satScoresMidpointMath,satScoresMidpointWriting,
							actScores25thPercentileCumulative,actScores75thPercentileCumulative,
							actScores25thPercentileEnglish,actScores75thPercentileEnglish,actScores25thPercentileMath,
							actScores75thPercentileMath,actScores25thPercentileWriting,actScores75thPercentileWriting,
							actScoresMidpointCumulative,actScoresMidpointEnglish,actScoresMidpointMath,actScoresMidpointWriting,
							satScoresAverageOverall,satScoresAverageByOpeId);
					admissions.add(admission);
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
			return admissions;
		}
}
