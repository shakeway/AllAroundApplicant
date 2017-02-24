package allAround.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import allAround.tools.ToolBox;


import allAround.model.Schools;

/**
 * 
 * @author Xiao Ai Nov 16, 2016
 */
public class SchoolsDao {
	protected ConnectionManager connectionManager;

	private static SchoolsDao instance = null;

	protected SchoolsDao() {
		connectionManager = new ConnectionManager();
	}

	public static SchoolsDao getInstance() {
		if (instance == null) {
			instance = new SchoolsDao();
		}
		return instance;
	}

	// TODO: insert

	// get by shcool id
	public Schools getSchoolById(int unitId) throws SQLException {
		String selectSchool = "SELECT * FROM Schools WHERE unitId=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectSchool);
			selectStmt.setInt(1, unitId);
			results = selectStmt.executeQuery();

			if (results.next()) {
				String name = results.getString("Name");
				String city = results.getString("City");
				String state = results.getString("State");
				int zip = results.getInt("Zip");
				double lat = results.getDouble("Lat");
				double lon = results.getDouble("Lon");
				String schoolUrl = results.getString("SchoolUrl");
				String priceCalculatorUrl = results.getString("PriceCalculatorUrl");
				boolean mainCampus = results.getBoolean("MainCampus");
				int branches = results.getInt("Branches");
				int predominant = results.getInt("Predominant");
				int highest = results.getInt("Highest");
				int ownership = results.getInt("Ownership");
				int stateFips = results.getInt("StateFips");
				int regionId = results.getInt("RegionId");
				int carnegieBasic = results.getInt("CarnegieBasic");
				int carnegieUndergrad = results.getInt("CarnegieUndergrad");
				int carnegieSizeSetting = results.getInt("CarnegieSizeSetting");
				boolean menOnly = results.getBoolean("MenOnly");
				boolean womenOnly = results.getBoolean("WomenOnly");
				int religiousAffiliation = results.getInt("ReligiousAffiliation");
				Schools school = new Schools(unitId, name, city, state, zip, lat, lon, schoolUrl, priceCalculatorUrl,
						mainCampus, branches, predominant, highest, ownership, stateFips, regionId, carnegieBasic,
						carnegieUndergrad, carnegieSizeSetting, menOnly, womenOnly, religiousAffiliation);
				return school;
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
	
	// get school by school name, return a school by exact match
	public Schools getSchoolBySchoolName(String name) throws SQLException {
		String selectSchool = "SELECT * FROM Schools WHERE Name=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectSchool);
			selectStmt.setString(1, name);
			results = selectStmt.executeQuery();
			
			if (results.next()) {
				int unitId = results.getInt("UnitId");
				String schoolName = results.getString("Name");
				String city = results.getString("City");
				String state = results.getString("State");
				int zip = results.getInt("Zip");
				double lat = results.getDouble("Lat");
				double lon = results.getDouble("Lon");
				String schoolUrl = results.getString("SchoolUrl");
				String priceCalculatorUrl = results.getString("PriceCalculatorUrl");
				boolean mainCampus = results.getBoolean("MainCampus");
				int branches = results.getInt("Branches");
				int predominant = results.getInt("Predominant");
				int highest = results.getInt("Highest");
				int ownership = results.getInt("Ownership");
				int stateFips = results.getInt("StateFips");
				int regionId = results.getInt("RegionId");
				int carnegieBasic = results.getInt("CarnegieBasic");
				int carnegieUndergrad = results.getInt("CarnegieUndergrad");
				int carnegieSizeSetting = results.getInt("CarnegieSizeSetting");
				boolean menOnly = results.getBoolean("MenOnly");
				boolean womenOnly = results.getBoolean("WomenOnly");
				int religiousAffiliation = results.getInt("ReligiousAffiliation");
				
				Schools school = new Schools(unitId, schoolName, city, state, zip, lat, lon, schoolUrl, priceCalculatorUrl,
						mainCampus, branches, predominant, highest, ownership, stateFips, regionId, carnegieBasic,
						carnegieUndergrad, carnegieSizeSetting, menOnly, womenOnly, religiousAffiliation);
				
				return school;
				
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
	
	public List<Schools> getSchoolsByCityAndState(String city, String state) throws SQLException {
		String selectSchools = "SELECT * FROM Schools WHERE City LIKE ? AND State LIKE ?";
		List<Schools> schools = new ArrayList<Schools>();
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectSchools);
			selectStmt.setString(1, "%" + city + "%");
			selectStmt.setString(2, "%" + state + "%");
			results = selectStmt.executeQuery();
			List<String> schoolNamesSoFar = new ArrayList<String>();
			while (results.next()) {
				int unitId = results.getInt("UnitId");
				String schoolName = ToolBox.toTitleCase(results.getString("Name"));
				String resultCity = ToolBox.toTitleCase(results.getString("City"));
				String resultState = results.getString("State");
				int zip = results.getInt("Zip");
				double lat = results.getDouble("Lat");
				double lon = results.getDouble("Lon");
				String schoolUrl = results.getString("SchoolUrl");
				if (schoolUrl.toLowerCase().contains("null")){
					schoolUrl = "";
				}
				else {
					schoolUrl = "http://" + schoolUrl;
				}
				String priceCalculatorUrl = results.getString("PriceCalculatorUrl");
				boolean mainCampus = results.getBoolean("MainCampus");
				int branches = results.getInt("Branches");
				int predominant = results.getInt("Predominant");
				int highest = results.getInt("Highest");
				int ownership = results.getInt("Ownership");
				int stateFips = results.getInt("StateFips");
				int regionId = results.getInt("RegionId");
				int carnegieBasic = results.getInt("CarnegieBasic");
				int carnegieUndergrad = results.getInt("CarnegieUndergrad");
				int carnegieSizeSetting = results.getInt("CarnegieSizeSetting");
				boolean menOnly = results.getBoolean("MenOnly");
				boolean womenOnly = results.getBoolean("WomenOnly");
				int religiousAffiliation = results.getInt("ReligiousAffiliation");
				
				Schools school = new Schools(unitId, schoolName, resultCity, resultState, zip, lat, lon, schoolUrl, priceCalculatorUrl,
						mainCampus, branches, predominant, highest, ownership, stateFips, regionId, carnegieBasic,
						carnegieUndergrad, carnegieSizeSetting, menOnly, womenOnly, religiousAffiliation);
				
				if (! schoolNamesSoFar.contains(schoolName)){
					schoolNamesSoFar.add(schoolName);
					schools.add(school);		
				}
				
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
		return schools;
	}
	// get schools by school name, return a list by inexact match
	public List<Schools> getSchoolsBySchoolName(String name) throws SQLException {
		String selectSchools = "SELECT * FROM Schools WHERE Name LIKE '%?" + "%';";
		List<Schools> schools = new ArrayList<Schools>();
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectSchools);
			selectStmt.setString(1, name);
			results = selectStmt.executeQuery();
			
			while (results.next()) {
				int unitId = results.getInt("UnitId");
				String schoolName = ToolBox.toTitleCase(results.getString("Name"));
				String city = ToolBox.toTitleCase(results.getString("City"));
				String state = results.getString("State");
				int zip = results.getInt("Zip");
				double lat = results.getDouble("Lat");
				double lon = results.getDouble("Lon");
				String schoolUrl = results.getString("SchoolUrl");
				String priceCalculatorUrl = results.getString("PriceCalculatorUrl");
				boolean mainCampus = results.getBoolean("MainCampus");
				int branches = results.getInt("Branches");
				int predominant = results.getInt("Predominant");
				int highest = results.getInt("Highest");
				int ownership = results.getInt("Ownership");
				int stateFips = results.getInt("StateFips");
				int regionId = results.getInt("RegionId");
				int carnegieBasic = results.getInt("CarnegieBasic");
				int carnegieUndergrad = results.getInt("CarnegieUndergrad");
				int carnegieSizeSetting = results.getInt("CarnegieSizeSetting");
				boolean menOnly = results.getBoolean("MenOnly");
				boolean womenOnly = results.getBoolean("WomenOnly");
				int religiousAffiliation = results.getInt("ReligiousAffiliation");
				
				Schools school = new Schools(unitId, schoolName, city, state, zip, lat, lon, schoolUrl, priceCalculatorUrl,
						mainCampus, branches, predominant, highest, ownership, stateFips, regionId, carnegieBasic,
						carnegieUndergrad, carnegieSizeSetting, menOnly, womenOnly, religiousAffiliation);
				
				schools.add(school);
				
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
		return schools;
	}
}
