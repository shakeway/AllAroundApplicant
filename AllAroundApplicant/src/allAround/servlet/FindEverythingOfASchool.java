package allAround.servlet;

import allAround.dao.*;
import allAround.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findeverythingofaschool")

public class FindEverythingOfASchool extends HttpServlet{
	protected SchoolsDao schoolsDao;
    protected AdmissionDao admissionDao;
  //  protected CompletionDao completionDao;
    protected CostDao costDao;
    protected EarningsDao earnginsDao;
    protected FinancialAidDao financialAidDao;
   // protected ProgramsDao programsDao;
    protected StudentDao studentDao;

    @Override
    public void init() throws ServletException {
    	schoolsDao = SchoolsDao.getInstance();
        admissionDao = AdmissionDao.getInstance();
      //  completionDao = CompletionDao.getInstance();
        costDao = CostDao.getInstance();
        earnginsDao = EarningsDao.getInstance();
        financialAidDao = FinancialAidDao.getInstance();
    //    programsDao = ProgramsDao.getInstance();
        studentDao = StudentDao.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Schools> schools = new ArrayList<Schools>();
        List<Admission> admissions = new ArrayList<Admission>();
        List<Completion> completionList = new ArrayList<Completion>();
        List<Cost> costs = new ArrayList<Cost>();
        List<Earnings> earningsList = new ArrayList<Earnings>();
        List<FinancialAid> financialAids = new ArrayList<FinancialAid>();
       // List<Programs> programs = new ArrayList<Programs>();
        List<Student> students = new ArrayList<Student>();

        // Retrieve and validate name.
        // schoolname is retrieved from the URL query string.
        String schoolName = req.getParameter("schoolname");
        if (schoolName == null || schoolName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
            // Retrieve BlogUsers, and store as a message.
            try {

            	schools.add(schoolsDao.getSchoolBySchoolName(schoolName));
                admissions = admissionDao.getAdmissionBySchoolName(schoolName);
            //    completionList = completionDao.getCompletionBySchoolName(schoolName);
                costs = costDao.getCostsBySchoolName(schoolName);
                earningsList = earnginsDao.getEarningsBySchoolName(schoolName);
                financialAids = financialAidDao.getFinancialAidsBySchoolName(schoolName);

                students = studentDao.getStudentBySchoolName(schoolName);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
            messages.put("success", "Displaying results for " + schoolName);
            // Save the previous search term, so it can be used as the default
            // in the input box when rendering FindUsers.jsp.
            messages.put("previousSchoolName", schoolName);
        }

        req.setAttribute("schools", schools);
        req.setAttribute("admissions", admissions);
        req.setAttribute("compleiton", completionList);
        req.setAttribute("costs", costs);
        req.setAttribute("earnings", earningsList);
        req.setAttribute("financialAids", financialAids);
        //req.setAttribute("programs", programs);
        req.setAttribute("students", students);

        req.getRequestDispatcher("/FindEverythingOfASchool.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Schools> schools = new ArrayList<Schools>();
        List<Admission> admissions = new ArrayList<Admission>();
        List<Completion> completionList = new ArrayList<Completion>();
        List<Cost> costs = new ArrayList<Cost>();
        List<Earnings> earningsList = new ArrayList<Earnings>();
        List<FinancialAid> financialAids = new ArrayList<FinancialAid>();
       // List<Programs> programs = new ArrayList<Programs>();
        List<Student> students = new ArrayList<Student>();

        // Retrieve and validate name.
        // schoolName is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindSchool.jsp).
        String schoolName = req.getParameter("schoolname");
        if (schoolName == null || schoolName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
            // Retrieve BlogUsers, and store as a message.
            try {
            	
            	schools.add(schoolsDao.getSchoolBySchoolName(schoolName));
                admissions = admissionDao.getAdmissionBySchoolName(schoolName);
               // completionList = completionDao.getCompletionBySchoolName(schoolName);
                costs = costDao.getCostsBySchoolName(schoolName);
                earningsList = earnginsDao.getEarningsBySchoolName(schoolName);
                financialAids = financialAidDao.getFinancialAidsBySchoolName(schoolName);
             //   programs = programsDao.getProgramsBySchoolNameAndProgramName(schoolName, programName);
                students = studentDao.getStudentBySchoolName(schoolName);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
            messages.put("success", "Displaying results for " + schoolName);
        }
        
        req.setAttribute("schools", schools);
        req.setAttribute("admissions", admissions);
        req.setAttribute("compleiton", completionList);
        req.setAttribute("costs", costs);
        req.setAttribute("earnings", earningsList);
        req.setAttribute("financialAids", financialAids);
       // req.setAttribute("programs", programs);
        req.setAttribute("students", students);

        req.getRequestDispatcher("/FindEverythingOfASchool.jsp").forward(req, resp);
    }

}
