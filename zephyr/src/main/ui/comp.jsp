<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="res/css/main.css">
        <link rel="stylesheet" type="text/css" href="res/css/header.css">
        <link rel="stylesheet" type="text/css" href="res/css/footer.css">
		<title>Competitions</title>
</head>
<body>

        <div id="topp">
            <div>
                <img id="logo" src="res/images/zephyr.jpg">
                <div>
                    <p style="font-size:60px">Zephyr'14</p>
                    <p style="font-size:22px">Inter Hostel Fest</p>
                </div>
                <div id="hrule"></div>
            </div>
        </div>
        
        <div id="header" class="unselect">

            <a href="index.html" id="info">Home
                <p>Zephyr '15 Home-page</p>
            </a>

            <a href="" id="info">Competitions                                                           <!-- need to set action link-->
                <p>View the details of the competitions</p>
            </a>

            <a href="" id="info">Score-board                                                            <!-- need to set action link-->
                <p>View the score-board</p>
            </a>
            
            <a href="" id="info">Schedule                                                               <!-- need to set action link-->
                <p>View the Time and Venue of Zephyr'15</p>
            </a>
            <a href="login.html" id="info">Login                    
                <p>Log into your account</p>
            </a>
            <div id="hrule"></div>
        </div>
        
        
        
        <div id="body" class="unselect">
            <div id="content">
                    <%
						Class.forName("org.sqlite.JDBC");
						Connection conn =
                     DriverManager.getConnection("jdbc:sqlite:C:\\Users\\praveen\\git_workspace\\Group-11\\zephyr\\common");
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery("select * from competition;");
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getString("venue") + "</td>");
                    out.println("<td>" + rs.getInt("month") + " </td>");
                    out.println("<td>" + rs.getInt("date") + "</td>");
                    out.println("</tr>");
                }		
						rs.close();
						conn.close();
					%>  
                <div id="hrule" style="height: 60px"></div>
                
            </div> 
        </div>
         
        <div id="footer" class="unselect">
            <a id="info" href="http://www.bits-pilani.ac.in/Goa/" target="_blank">BPGC
                <p>Go to BITS Pilani,Goa Homepage</p>
            </a>

            <a href="developers.html" id="info">Developers                                                           
                <p>Get to know the people involved in the development of this website</p>
            </a>

            <div id="hrule"></div>    
        </div>
        
        <a name="bottom"></a>
        
    </body>
</html>
