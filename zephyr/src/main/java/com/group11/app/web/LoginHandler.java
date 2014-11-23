package com.group11.app.web;

import com.group11.app.zephyr.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class LoginHandler extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("user-id") != null) {
            response.sendRedirect("student.jsp");
        }
        else {
            RequestDispatcher loginView = request.getRequestDispatcher("login.jsp");
            loginView.forward(request, response);            
        }

    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

                
        int userid = Integer.parseInt(request.getParameter("username"));
        String password = request.getParameter("password");
        
        Student s = new Student(userid, null, null, null); //bad code! I am going to shoot myself!
        s.setPassword(password);
        Login l = new Login(s);        
        
        request.setAttribute("check", "true");
        
        
        if(l.checkCredentials()) {
            request.getSession().setAttribute("user-id", userid);
            
            boolean hr = checkHR(s);
            if(!hr) {

                RequestDispatcher studentView = request.getRequestDispatcher("student.jsp");
                studentView.forward(request, response);
            }

            else {
                RequestDispatcher hrView = request.getRequestDispatcher("hr.jsp");
                hrView.forward(request, response);
                
            }
        }

        else {
            String check = "false";
            request.setAttribute("check", check);
            RequestDispatcher loginView = request.getRequestDispatcher("login.jsp");
            loginView.forward(request, response);
            }

    }

    private boolean checkHR(Student s) {
        boolean check = false;
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/var/lib/tomcat7/webapps/zephyr/data/common");
            stmt = c.createStatement() ;

            
            ResultSet rs = stmt.executeQuery("SELECT type from person WHERE id = " + s.getID() );
            if(rs.getInt("type") == 1) {
                check = true;
            }
            else {
                check = false;
            }

        } catch(SQLException e) {
            e.printStackTrace();            
            
        } finally {

            try {
                stmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }


            try {
                c.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }


            return check;
        }
    }


}
