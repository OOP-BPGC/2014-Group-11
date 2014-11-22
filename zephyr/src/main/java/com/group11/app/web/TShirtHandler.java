package com.group11.app.web;

import com.group11.app.zephyr.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class TShirtHandler extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        if(request.getSession().getAttribute("user-id") != null) {
            int uid = Integer.parseInt(request.getSession().getAttribute("user-id"));
            Student s = new Student(uid, null, null, null);
            int notees = TShirt.getNoTShirts();
            for(int i = 0; i < notees; i++) {
                String name = request.getParameter("shirt" + i + 1);
                int id = i + 1;
                int qs = Integer.parseInt(request.getParameter("shirt" + i + 1 + "s"));
                int qm = Integer.parseInt(request.getParameter("shirt" + i + 1 + "m"));
                int ql = Integer.parseInt(request.getParameter("shirt" + i + 1 + "l"));
                int qxl = Integer.parseInt(request.getParameter("shirt" + i + 1 + "xl"));

                TShirt t = new TShirt(name, i, qs, qm, ql, qxl);

                TShirtList tl = new TShritList(t, s);
                tl.putToDatabase();
            }
        }

        else {
            response.sendRedirect("/zephyr");

        }
    }
}
