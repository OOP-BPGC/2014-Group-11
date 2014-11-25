package com.group11.app.web;

import com.group11.app.zephyr.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class PassHandler extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("user-id") != null) {
            int uid = (Integer) request.getSession().getAttribute("user-id");
            Student s = new Student(uid, null, null, null);
            int nopass = Pass.getNoPasses();

            int id;
            String name;
            
            for(int i=0; i < nopass; i++) {
                id = i + 1;                
                String active = request.getParameter("pass" + i + 1);
                if(active.equals("Yes")) {
                    Pass p = new Pass(id, null, null);
                    p.putToDatabase();
                }
            }
        }
    }

}