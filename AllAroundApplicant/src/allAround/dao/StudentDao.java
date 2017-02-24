package allAround.dao;

import allAround.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class StudentDao {
    protected ConnectionManager connectionManager;

    private static StudentDao instance = null;
    protected StudentDao(){
        connectionManager = new ConnectionManager();
    }

    public static StudentDao getInstance(){
        if(instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    public Student create(Student student) throws SQLException {
        String insertstudent =
                "INSERT INTO Student(Year,UnitId,Size,EnrollmentAll,"
                + "DemographicsRaceEthnicityWhite,DemographicsRaceEthnicityBlack,"
                + "DemographicsRaceEthnicityHispanic,DemographicsRaceEthnicityAsian,"
                + "DemographicsRaceEthnicityAian,DemographicsRaceEthnicityNhpi,"
                + "DemographicsRaceEthnicityTwoOrMore,DemographicsRaceEthnicityNonResidentAlien,"
                + "DemographicsRaceEthnicityUnknown,DemographicsRaceEthnicityWhiteNonHispanic,"
                + "DemographicsRaceEthnicityBlackNonHispanic,DemographicsRaceEthnicityAsianPacificIslander,"
                + "DemographicsRaceEthnicityAianPrior2009,DemographicsRaceEthnicityHispanicPrior2009,"
                + "DemographicsNonResidentAliens2000,DemographicsRaceEthnicityUnknown2000,"
                + "DemographicsRaceEthnicityWhite2000,DemographicsRaceEthnicityBlack2000,"
                + "DemographicsRaceEthnicityApi2000,DemographicsRaceEthnicityAian2000,"
                + "DemographicsRaceEthnicityHispanic2000,PartTimeShare,PartTimeShare2000) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertstudent,
                Statement.RETURN_GENERATED_KEYS);
            insertStmt.setInt(1, student.getYear());
            insertStmt.setInt(2, student.getSchool().getUnitId());
            insertStmt.setInt(3, student.getSize());
            insertStmt.setInt(4, student.getEnrollmentAll());
            insertStmt.setString(5, student.getDemographicsRaceEthnicityWhite());
            insertStmt.setString(6, student.getDemographicsRaceEthnicityBlack());
            insertStmt.setString(7, student.getDemographicsRaceEthnicityHispanic());
            insertStmt.setString(8, student.getDemographicsRaceEthnicityAsian());
            insertStmt.setString(9, student.getDemographicsRaceEthnicityAian());
            insertStmt.setString(10, student.getDemographicsRaceEthnicityNhpi());
            insertStmt.setString(11, student.getDemographicsRaceEthnicityTwoOrMore());
            insertStmt.setString(12, student.getDemographicsRaceEthnicityNonResidentAlien());
            insertStmt.setString(13, student.getDemographicsRaceEthnicityUnknown());
            insertStmt.setString(14, student.getDemographicsRaceEthnicityWhiteNonHispanic());
            insertStmt.setString(15, student.getDemographicsRaceEthnicityBlackNonHispanic());
            insertStmt.setString(16, student.getDemographicsRaceEthnicityAsianPacificIslander());
            insertStmt.setString(17, student.getDemographicsRaceEthnicityAianPrior2009());
            insertStmt.setString(18, student.getDemographicsRaceEthnicityHispanicPrior2009());
            insertStmt.setString(19, student.getDemographicsNonResidentAliens2000());
            insertStmt.setString(20, student.getDemographicsRaceEthnicityUnknown2000());
            insertStmt.setString(21, student.getDemographicsRaceEthnicityWhite2000());
            insertStmt.setString(22, student.getDemographicsRaceEthnicityBlack2000());
            insertStmt.setString(23, student.getDemographicsRaceEthnicityApi2000());
            insertStmt.setString(24, student.getDemographicsRaceEthnicityAian2000());
            insertStmt.setString(25, student.getDemographicsRaceEthnicityHispanic2000());
            insertStmt.setString(26, student.getPartTimeShare());
            insertStmt.setString(27, student.getPartTimeShare2000());

            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int reviewId = -1;
            if(resultKey.next()) {
                reviewId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            student.setStudentId(reviewId);
            return student;
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

    public Student getStudentByStudentId(int studentId) throws SQLException {
        String selectstudent =
            "SELECT StudentId,Year,UnitId,Size,EnrollmentAll,"
                + "DemographicsRaceEthnicityWhite,DemographicsRaceEthnicityBlack,"
                + "DemographicsRaceEthnicityHispanic,DemographicsRaceEthnicityAsian,"
                + "DemographicsRaceEthnicityAian,DemographicsRaceEthnicityNhpi,"
                + "DemographicsRaceEthnicityTwoOrMore,DemographicsRaceEthnicityNonResidentAlien,"
                + "DemographicsRaceEthnicityUnknown,DemographicsRaceEthnicityWhiteNonHispanic,"
                + "DemographicsRaceEthnicityBlackNonHispanic,DemographicsRaceEthnicityAsianPacificIslander,"
                + "DemographicsRaceEthnicityAianPrior2009,DemographicsRaceEthnicityHispanicPrior2009,"
                + "DemographicsNonResidentAliens2000,DemographicsRaceEthnicityUnknown2000,"
                + "DemographicsRaceEthnicityWhite2000,DemographicsRaceEthnicityBlack2000,"
                + "DemographicsRaceEthnicityApi2000,DemographicsRaceEthnicityAian2000,"
                + "DemographicsRaceEthnicityHispanic2000,PartTimeShare,PartTimeShare2000 " +
            "FROM Student " +
            "WHERE StudentId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectstudent);
            selectStmt.setInt(1, studentId);
            results = selectStmt.executeQuery();
            SchoolsDao schoolDao = SchoolsDao.getInstance();

            if(results.next()) {
                
                int year = results.getInt("year");
                int UnitId = results.getInt("UnitId");
                int size = results.getInt("Size");
                int enrollmentAll = results.getInt("EnrollmentAll");
                Double demographicsRaceEthnicityWhite = results.getDouble("DemographicsRaceEthnicityWhite");
                Double demographicsRaceEthnicityBlack = results.getDouble("DemographicsRaceEthnicityBlack");
                Double demographicsRaceEthnicityHispanic = results.getDouble("DemographicsRaceEthnicityHispanic");
                Double demographicsRaceEthnicityAsian = results.getDouble("DemographicsRaceEthnicityAsian");
                Double demographicsRaceEthnicityAian = results.getDouble("DemographicsRaceEthnicityAian");
                Double demographicsRaceEthnicityNhpi = results.getDouble("DemographicsRaceEthnicityNhpi");
                Double demographicsRaceEthnicityTwoOrMore = results.getDouble("DemographicsRaceEthnicityTwoOrMore");
                Double demographicsRaceEthnicityNonResidentAlien = results.getDouble("DemographicsRaceEthnicityNonResidentAlien");
                Double demographicsRaceEthnicityUnknown = results.getDouble("DemographicsRaceEthnicityUnknown");
                Double demographicsRaceEthnicityWhiteNonHispanic = results.getDouble("DemographicsRaceEthnicityWhiteNonHispanic");
                Double demographicsRaceEthnicityBlackNonHispanic = results.getDouble("DemographicsRaceEthnicityBlackNonHispanic");
                Double demographicsRaceEthnicityAsianPacificIslander = results.getDouble("DemographicsRaceEthnicityAsianPacificIslander");
                Double demographicsRaceEthnicityAianPrior2009 = results.getDouble("DemographicsRaceEthnicityAianPrior2009");
                Double demographicsRaceEthnicityHispanicPrior2009 = results.getDouble("DemographicsRaceEthnicityHispanicPrior2009");
                Double demographicsNonResidentAliens2000 = results.getDouble("DemographicsNonResidentAliens2000");
                Double demographicsRaceEthnicityUnknown2000 = results.getDouble("DemographicsRaceEthnicityUnknown2000");
                Double demographicsRaceEthnicityWhite2000 = results.getDouble("DemographicsRaceEthnicityWhite2000");
                Double demographicsRaceEthnicityBlack2000 = results.getDouble("DemographicsRaceEthnicityBlack2000");
                Double demographicsRaceEthnicityApi2000 = results.getDouble("DemographicsRaceEthnicityApi2000");
                Double demographicsRaceEthnicityAian2000 = results.getDouble("DemographicsRaceEthnicityAian2000");
                Double demographicsRaceEthnicityHispanic2000 = results.getDouble("DemographicsRaceEthnicityHispanic2000");
                Double partTimeShare = results.getDouble("PartTimeShare");
                Double partTimeShare2000 = results.getDouble("PartTimeShare2000");
                Schools school = schoolDao.getSchoolById(UnitId);

                Student student = new Student (studentId, year, school, size, enrollmentAll,
            		 demographicsRaceEthnicityWhite, demographicsRaceEthnicityBlack,
            		 demographicsRaceEthnicityHispanic, demographicsRaceEthnicityAsian,
            		 demographicsRaceEthnicityAian, demographicsRaceEthnicityNhpi,
            		 demographicsRaceEthnicityTwoOrMore, demographicsRaceEthnicityNonResidentAlien,
            		 demographicsRaceEthnicityUnknown, demographicsRaceEthnicityWhiteNonHispanic,
            		 demographicsRaceEthnicityBlackNonHispanic, demographicsRaceEthnicityAsianPacificIslander,
            		 demographicsRaceEthnicityAianPrior2009, demographicsRaceEthnicityHispanicPrior2009,
            		 demographicsNonResidentAliens2000, demographicsRaceEthnicityUnknown2000,
            		 demographicsRaceEthnicityWhite2000, demographicsRaceEthnicityBlack2000,
            		 demographicsRaceEthnicityApi2000, demographicsRaceEthnicityAian2000,
            		 demographicsRaceEthnicityHispanic2000, partTimeShare, partTimeShare2000);
                return student;
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


    public List<Student> getStudentBySchoolId(int UnitId) throws SQLException {
        List<Student> students = new ArrayList<Student>();
    	String selectstudent =
        		"SELECT StudentId,Year,UnitId,Size,EnrollmentAll,"
                        + "DemographicsRaceEthnicityWhite,DemographicsRaceEthnicityBlack,"
                        + "DemographicsRaceEthnicityHispanic,DemographicsRaceEthnicityAsian,"
                        + "DemographicsRaceEthnicityAian,DemographicsRaceEthnicityNhpi,"
                        + "DemographicsRaceEthnicityTwoOrMore,DemographicsRaceEthnicityNonResidentAlien,"
                        + "DemographicsRaceEthnicityUnknown,DemographicsRaceEthnicityWhiteNonHispanic,"
                        + "DemographicsRaceEthnicityBlackNonHispanic,DemographicsRaceEthnicityAsianPacificIslander,"
                        + "DemographicsRaceEthnicityAianPrior2009,DemographicsRaceEthnicityHispanicPrior2009,"
                        + "DemographicsNonResidentAliens2000,DemographicsRaceEthnicityUnknown2000,"
                        + "DemographicsRaceEthnicityWhite2000,DemographicsRaceEthnicityBlack2000,"
                        + "DemographicsRaceEthnicityApi2000,DemographicsRaceEthnicityAian2000,"
                        + "DemographicsRaceEthnicityHispanic2000,PartTimeShare,PartTimeShare2000 " +
            "FROM Student " +
            "WHERE UnitId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectstudent);
            selectStmt.setInt(1, UnitId);
            results = selectStmt.executeQuery();
            SchoolsDao schoolDao = SchoolsDao.getInstance();

            while(results.next()) {
            	 int studentId = results.getInt("StudentId");
            	 int year = results.getInt("year");
                 int size = results.getInt("Size");
                 int enrollmentAll = results.getInt("EnrollmentAll");
                 Double demographicsRaceEthnicityWhite = results.getDouble("DemographicsRaceEthnicityWhite");
                 Double demographicsRaceEthnicityBlack = results.getDouble("DemographicsRaceEthnicityBlack");
                 Double demographicsRaceEthnicityHispanic = results.getDouble("DemographicsRaceEthnicityHispanic");
                 Double demographicsRaceEthnicityAsian = results.getDouble("DemographicsRaceEthnicityAsian");
                 Double demographicsRaceEthnicityAian = results.getDouble("DemographicsRaceEthnicityAian");
                 Double demographicsRaceEthnicityNhpi = results.getDouble("DemographicsRaceEthnicityNhpi");
                 Double demographicsRaceEthnicityTwoOrMore = results.getDouble("DemographicsRaceEthnicityTwoOrMore");
                 Double demographicsRaceEthnicityNonResidentAlien = results.getDouble("DemographicsRaceEthnicityNonResidentAlien");
                 Double demographicsRaceEthnicityUnknown = results.getDouble("DemographicsRaceEthnicityUnknown");
                 Double demographicsRaceEthnicityWhiteNonHispanic = results.getDouble("DemographicsRaceEthnicityWhiteNonHispanic");
                 Double demographicsRaceEthnicityBlackNonHispanic = results.getDouble("DemographicsRaceEthnicityBlackNonHispanic");
                 Double demographicsRaceEthnicityAsianPacificIslander = results.getDouble("DemographicsRaceEthnicityAsianPacificIslander");
                 Double demographicsRaceEthnicityAianPrior2009 = results.getDouble("DemographicsRaceEthnicityAianPrior2009");
                 Double demographicsRaceEthnicityHispanicPrior2009 = results.getDouble("DemographicsRaceEthnicityHispanicPrior2009");
                 Double demographicsNonResidentAliens2000 = results.getDouble("DemographicsNonResidentAliens2000");
                 Double demographicsRaceEthnicityUnknown2000 = results.getDouble("DemographicsRaceEthnicityUnknown2000");
                 Double demographicsRaceEthnicityWhite2000 = results.getDouble("DemographicsRaceEthnicityWhite2000");
                 Double demographicsRaceEthnicityBlack2000 = results.getDouble("DemographicsRaceEthnicityBlack2000");
                 Double demographicsRaceEthnicityApi2000 = results.getDouble("DemographicsRaceEthnicityApi2000");
                 Double demographicsRaceEthnicityAian2000 = results.getDouble("DemographicsRaceEthnicityAian2000");
                 Double demographicsRaceEthnicityHispanic2000 = results.getDouble("DemographicsRaceEthnicityHispanic2000");
                 Double partTimeShare = results.getDouble("PartTimeShare");
                 Double partTimeShare2000 = results.getDouble("PartTimeShare2000");
                 Schools school = schoolDao.getSchoolById(UnitId);

                 Student student = new Student (studentId, year, school, size, enrollmentAll,
             		 demographicsRaceEthnicityWhite, demographicsRaceEthnicityBlack,
             		 demographicsRaceEthnicityHispanic, demographicsRaceEthnicityAsian,
             		 demographicsRaceEthnicityAian, demographicsRaceEthnicityNhpi,
             		 demographicsRaceEthnicityTwoOrMore, demographicsRaceEthnicityNonResidentAlien,
             		 demographicsRaceEthnicityUnknown, demographicsRaceEthnicityWhiteNonHispanic,
             		 demographicsRaceEthnicityBlackNonHispanic, demographicsRaceEthnicityAsianPacificIslander,
             		 demographicsRaceEthnicityAianPrior2009, demographicsRaceEthnicityHispanicPrior2009,
             		 demographicsNonResidentAliens2000, demographicsRaceEthnicityUnknown2000,
             		 demographicsRaceEthnicityWhite2000, demographicsRaceEthnicityBlack2000,
             		 demographicsRaceEthnicityApi2000, demographicsRaceEthnicityAian2000,
             		 demographicsRaceEthnicityHispanic2000, partTimeShare, partTimeShare2000);
                 students.add(student);
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
        return students;
    }
    public List<Student> getStudentBySchoolName(String schoolName) throws SQLException {
        List<Student> students = new ArrayList<Student>();
    	String selectstudent =
        		"SELECT StudentId,Year,UnitId,Size,EnrollmentAll,"
                        + "DemographicsRaceEthnicityWhite,DemographicsRaceEthnicityBlack,"
                        + "DemographicsRaceEthnicityHispanic,DemographicsRaceEthnicityAsian,"
                        + "DemographicsRaceEthnicityAian,DemographicsRaceEthnicityNhpi,"
                        + "DemographicsRaceEthnicityTwoOrMore,DemographicsRaceEthnicityNonResidentAlien,"
                        + "DemographicsRaceEthnicityUnknown,DemographicsRaceEthnicityWhiteNonHispanic,"
                        + "DemographicsRaceEthnicityBlackNonHispanic,DemographicsRaceEthnicityAsianPacificIslander,"
                        + "DemographicsRaceEthnicityAianPrior2009,DemographicsRaceEthnicityHispanicPrior2009,"
                        + "DemographicsNonResidentAliens2000,DemographicsRaceEthnicityUnknown2000,"
                        + "DemographicsRaceEthnicityWhite2000,DemographicsRaceEthnicityBlack2000,"
                        + "DemographicsRaceEthnicityApi2000,DemographicsRaceEthnicityAian2000,"
                        + "DemographicsRaceEthnicityHispanic2000,PartTimeShare,PartTimeShare2000 " +
            "FROM Student " +
            "WHERE UnitId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectstudent);
            SchoolsDao schoolDao = SchoolsDao.getInstance();
            int unitId = schoolDao.getSchoolBySchoolName(schoolName).getUnitId();
            selectStmt.setInt(1, unitId);
            results = selectStmt.executeQuery();
            

            while(results.next()) {
            	 int studentId = results.getInt("StudentId");
            	 int year = results.getInt("year");
                 int size = results.getInt("Size");
                 int enrollmentAll = results.getInt("EnrollmentAll");
                 Double demographicsRaceEthnicityWhite = results.getDouble("DemographicsRaceEthnicityWhite");
                 Double demographicsRaceEthnicityBlack = results.getDouble("DemographicsRaceEthnicityBlack");
                 Double demographicsRaceEthnicityHispanic = results.getDouble("DemographicsRaceEthnicityHispanic");
                 Double demographicsRaceEthnicityAsian = results.getDouble("DemographicsRaceEthnicityAsian");
                 Double demographicsRaceEthnicityAian = results.getDouble("DemographicsRaceEthnicityAian");
                 Double demographicsRaceEthnicityNhpi = results.getDouble("DemographicsRaceEthnicityNhpi");
                 Double demographicsRaceEthnicityTwoOrMore = results.getDouble("DemographicsRaceEthnicityTwoOrMore");
                 Double demographicsRaceEthnicityNonResidentAlien = results.getDouble("DemographicsRaceEthnicityNonResidentAlien");
                 Double demographicsRaceEthnicityUnknown = results.getDouble("DemographicsRaceEthnicityUnknown");
                 Double demographicsRaceEthnicityWhiteNonHispanic = results.getDouble("DemographicsRaceEthnicityWhiteNonHispanic");
                 Double demographicsRaceEthnicityBlackNonHispanic = results.getDouble("DemographicsRaceEthnicityBlackNonHispanic");
                 Double demographicsRaceEthnicityAsianPacificIslander = results.getDouble("DemographicsRaceEthnicityAsianPacificIslander");
                 Double demographicsRaceEthnicityAianPrior2009 = results.getDouble("DemographicsRaceEthnicityAianPrior2009");
                 Double demographicsRaceEthnicityHispanicPrior2009 = results.getDouble("DemographicsRaceEthnicityHispanicPrior2009");
                 Double demographicsNonResidentAliens2000 = results.getDouble("DemographicsNonResidentAliens2000");
                 Double demographicsRaceEthnicityUnknown2000 = results.getDouble("DemographicsRaceEthnicityUnknown2000");
                 Double demographicsRaceEthnicityWhite2000 = results.getDouble("DemographicsRaceEthnicityWhite2000");
                 Double demographicsRaceEthnicityBlack2000 = results.getDouble("DemographicsRaceEthnicityBlack2000");
                 Double demographicsRaceEthnicityApi2000 = results.getDouble("DemographicsRaceEthnicityApi2000");
                 Double demographicsRaceEthnicityAian2000 = results.getDouble("DemographicsRaceEthnicityAian2000");
                 Double demographicsRaceEthnicityHispanic2000 = results.getDouble("DemographicsRaceEthnicityHispanic2000");
                 Double partTimeShare = results.getDouble("PartTimeShare");
                 Double partTimeShare2000 = results.getDouble("PartTimeShare2000");
                 Schools school = schoolDao.getSchoolById(unitId);

                 Student student = new Student (studentId, year, school, size, enrollmentAll,
             		 demographicsRaceEthnicityWhite, demographicsRaceEthnicityBlack,
             		 demographicsRaceEthnicityHispanic, demographicsRaceEthnicityAsian,
             		 demographicsRaceEthnicityAian, demographicsRaceEthnicityNhpi,
             		 demographicsRaceEthnicityTwoOrMore, demographicsRaceEthnicityNonResidentAlien,
             		 demographicsRaceEthnicityUnknown, demographicsRaceEthnicityWhiteNonHispanic,
             		 demographicsRaceEthnicityBlackNonHispanic, demographicsRaceEthnicityAsianPacificIslander,
             		 demographicsRaceEthnicityAianPrior2009, demographicsRaceEthnicityHispanicPrior2009,
             		 demographicsNonResidentAliens2000, demographicsRaceEthnicityUnknown2000,
             		 demographicsRaceEthnicityWhite2000, demographicsRaceEthnicityBlack2000,
             		 demographicsRaceEthnicityApi2000, demographicsRaceEthnicityAian2000,
             		 demographicsRaceEthnicityHispanic2000, partTimeShare, partTimeShare2000);
                 students.add(student);
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
        return students;
    }

    public Student delete(Student student) throws SQLException {
        String deletestudent = "DELETE FROM Student WHERE StudentId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deletestudent);
            deleteStmt.setInt(1, student.getStudentId());
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
