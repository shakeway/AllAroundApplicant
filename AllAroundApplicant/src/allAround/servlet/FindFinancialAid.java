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


@WebServlet("/findfinancialaid")

public class FindFinancialAid extends HttpServlet {
    
    protected FinancialAidDao financialAidDao;
    
    @Override
    public void init() throws ServletException {
    	financialAidDao = FinancialAidDao.getInstance();
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<FinancialAid> financialAids = new ArrayList<FinancialAid>();
        
        // Retrieve and validate name.
        // schoolnName is retrieved from the URL query string.
        String schoolName = req.getParameter("schoolname");
        if (schoolName == null || schoolName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
            // Retrieve BlogUsers, and store as a message.
            try {
                financialAids = financialAidDao.getFinancialAidsBySchoolName(schoolName);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
            messages.put("success", "Displaying results for " + schoolName);
            // Save the previous search term, so it can be used as the default
            // in the input box when rendering FindUsers.jsp.
            messages.put("previousSchoolName", schoolName);
        }
        req.setAttribute("financialAids", financialAids);
        
        req.getRequestDispatcher("/FindFinancialAid.jsp").forward(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<FinancialAid> financialAids = new ArrayList<FinancialAid>();
        
        // Retrieve and validate name.
        // schoolname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String schoolName = req.getParameter("schoolname");
        if (schoolName == null || schoolName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
            // Retrieve BlogUsers, and store as a message.
            try {
                financialAids = financialAidDao.getFinancialAidsBySchoolName(schoolName);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
            messages.put("success", "Displaying results for " + schoolName);
        }
        req.setAttribute("financialAids", financialAids);
        
        req.getRequestDispatcher("/FindFinancialAid.jsp").forward(req, resp);
    }
}