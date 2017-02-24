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
@WebServlet("/findschools")
public class FindSchools extends HttpServlet{
	protected SchoolsDao schoolsDao;
	
	@Override
	public void init() throws ServletException {
		schoolsDao = SchoolsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<Schools> schools = new ArrayList<Schools>();

        // Retrieve and validate name.
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		if (city == null || city.trim().isEmpty() || state == null || state.trim().isEmpty()) {
			messages.put("success", "Please enter a valid name.");
		} else {
			try {
				schools = schoolsDao.getSchoolsByCityAndState(city, state);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for " + city + "and " + state);
		}
		req.setAttribute("schools", schools);

		req.getRequestDispatcher("/FindSchools.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<Schools> schools = new ArrayList<Schools>();

		String city = req.getParameter("city");
		String state = req.getParameter("state");
		if (city == null || city.trim().isEmpty() || state == null || state.trim().isEmpty()) {
			messages.put("success", "Please enter a valid name.");
		} else {
			try {
				schools = schoolsDao.getSchoolsByCityAndState(city, state);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results in " + city + ", " + state);
		}
		req.setAttribute("schools", schools);

		req.getRequestDispatcher("/FindSchools.jsp").forward(req, resp);
	}
}

