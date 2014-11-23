package com.group11.app.web;

import com.group11.app.zephyr.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class TShirtHandler extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        if(request.getSession().getAttribute("user-id") != null) {
            int uid = (Integer) request.getSession().getAttribute("user-id");
            Student s = new Student(uid, null, null, null);
            int notees = TShirt.getNoTShirts();
            System.out.println("Hey " + notees);
            for(int i = 0; i < notees; i++) {
                int id = i + 1;

                int qs = Integer.parseInt(request.getParameter("shirt" + id + "s"));
                int qm = Integer.parseInt(request.getParameter("shirt" + id + "m"));
                int ql = Integer.parseInt(request.getParameter("shirt" + id + "l"));
                int qxl = Integer.parseInt(request.getParameter("shirt" + id + "xl"));

                if(qs != 0 || qm != 0 || ql !=0 || qxl != 0) {
                    TShirt t = new TShirt(null, i, qs, qm, ql, qxl);
                    TShirtList tl = new TShirtList(t, s);
                    tl.putToDatabase();

                }
            }

            response.sendRedirect("successful.html");
        }

        else {
            response.sendRedirect("/zephyr");

        }
    }
}
