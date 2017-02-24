package allAround.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import allAround.model.CIP;

/**
 * 
 * @author Xiao Ai
 * Nov 17, 2016
 */
public class CIPDao {
	protected ConnectionManager connectionManager;

	private static CIPDao instance = null;

	protected CIPDao() {
		connectionManager = new ConnectionManager();
	}

	public static CIPDao getInstance() {
		if (instance == null) {
			instance = new CIPDao();
		}
		return instance;
	}
	
	// insert
	public CIP create(CIP cip) throws SQLException {
		String insertCIP = "INSERT INTO CIP(CipCode,TitleDescription) VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		
		try {
			connection = connectionManager.getConnection();

			insertStmt = connection.prepareStatement(insertCIP);
			insertStmt.setInt(1, cip.getCipCode());
			insertStmt.setString(2, cip.getTitle());
			insertStmt.setString(3, cip.getDescription());

			insertStmt.executeUpdate();
			return cip;
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
		}
	}
	
	// get CIP by cipCode
	public CIP getCipByCipCode(int cipCode) throws SQLException {
		String selectCip = "SELECT * FROM CIP WHERE CipCode=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCip);
			selectStmt.setInt(1, cipCode);
			results = selectStmt.executeQuery();
			
			if (results.next()) {
				String title = results.getString("Title");
				String description = results.getString("Description");
				CIP cip = new CIP(cipCode, title, description);
				return cip;
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
}
