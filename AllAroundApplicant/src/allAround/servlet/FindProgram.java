package allAround.servlet;
import allAround.dao.*;
import allAround.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/findprogram")
public class FindProgram extends HttpServlet{
	protected ProgramsDao programsDao;
	
	@Override
	public void init() throws ServletException {
		programsDao = ProgramsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<Programs> programs = new ArrayList<Programs>();

        // Retrieve and validate name.
		String schoolName = req.getParameter("schoolname");
		String programName = req.getParameter("programname");
		if (schoolName == null || schoolName.trim().isEmpty() || programName == null || programName.trim().isEmpty()) {
			messages.put("success", "Please enter a valid name.");
		} else {
			try {
				programs = programsDao.getProgramsBySchoolNameAndProgramName(schoolName, programName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for " + schoolName + "and " + programName);
			// messages.put("Searched programs by SchoolName", programName);
		}
		req.setAttribute("programs", programs);

		req.getRequestDispatcher("/FindProgram.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<Programs> programs = new ArrayList<Programs>();

		String schoolName = req.getParameter("schoolname");
		String programName = req.getParameter("programname");
		if (schoolName == null || schoolName.trim().isEmpty() || programName == null || programName.trim().isEmpty()) {
			messages.put("success", "Please enter a valid name.");
		} else {
			try {
				programs = programsDao.getProgramsBySchoolNameAndProgramName(schoolName, programName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for " + schoolName);
		}
		req.setAttribute("programs", programs);

		req.getRequestDispatcher("/FindProgram.jsp").forward(req, resp);
	}
}

