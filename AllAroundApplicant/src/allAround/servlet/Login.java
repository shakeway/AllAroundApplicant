package allAround.servlet;
import allAround.dao.*;
import allAround.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet{
	protected UsersDao usersDao;
	
	@Override
	public void init() throws ServletException {
		usersDao = UsersDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		String login_username = req.getParameter("login_username");
		String login_password = req.getParameter("login_password");
		String password = new String();
		if (login_username == null || login_username.trim().isEmpty() || login_password == null || login_password.trim().isEmpty()) {
			messages.put("success", "Please enter a valid name.");
		} else {
			try {
				password = usersDao.getPasswordByUserName(login_username);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			if(login_password == password){
				messages.put("success", "Welcome " + login_username);
				req.setAttribute("username", login_username);
			}
		}		
		req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		String login_username = req.getParameter("login_username");
		String login_password = req.getParameter("login_password");
		String password = new String();
		if (login_username == null || login_username.trim().isEmpty() || login_password == null || login_password.trim().isEmpty()) {
			messages.put("success", "Please enter a valid name.");
		} else {
			try {
				password = usersDao.getPasswordByUserName(login_username);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			if(login_password == password){
				messages.put("success", "Welcome " + login_username);
				req.setAttribute("username", login_username);
				System.out.println("<script>alert('Successful!');window.location.href='index.jsp'</script>");
			}
		}		
		req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	}
}

