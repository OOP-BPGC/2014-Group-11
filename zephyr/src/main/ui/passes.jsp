<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" type="text/css" href="res/css/main.css">
        <link rel="stylesheet" type="text/css" href="res/css/header.css">
        <link rel="stylesheet" type="text/css" href="res/css/footer.css">
        <title>BUY TSHIRT</title>
    </head>
    
    <body>
        
        <a name="top"></a>
        
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

            <a href="student.jsp" id="info">Home
                <p>Zephyr '15 Home-page</p>
            </a>

            <a href="comp.jsp" id="info">Competitions                                                       <!-- need to set action link-->
                <p>View the details of the competitions</p>
            </a>

            <a href="score.jsp" id="info">Score-board                                                <!-- need to set action link-->
                <p>View the score-board</p>
            </a>
            <a href="logout" id="info">Log-out                                                       <!-- need to set action link-->
                <p>If you're done and dusted</p>
            </a>

            <div id="hrule"></div>
        </div>
        
        
        
        <div id="body" class="unselect">
            
            <div id="content">

                <div id="competitions">
    
                    <div id="hrule" style="height: 50px"></div>
                    <div id="hrule" style="height: 20px"></div>
    

                    <div id="hrule" style="height: 0px" ></div>

                    <!--show tshirt-->
					<div id="hrule" style="height: 60px"></div>
					
					
					<div style="margin-left: 360px;">
					
					
					<form action="" method="post" > <h1>BUY PASSES</h1><br/><br/>          
				
                    <%
                        Class.forName("org.sqlite.JDBC");
                        Connection conn = DriverManager.getConnection("jdbc:sqlite:../common");     //change the link
                        Statement stat = conn.createStatement();
                        ResultSet rs = stat.executeQuery("select * from passes;");  //passid picpath passname
                        int i = 1;
                        while (rs.next()) {
                            out.println("<h2>" + rs.getString("passname") + "</h2>");
                            out.println("<img src=" + rs.getString("picpath") + " width=400px height=300px>");
 
                            out.println("<div id=\"hrule\" style=\"height: 0px\" ></div>");
                            
                            out.println("GET THE PASS: <input type=\"checkbox\" name=pass" + i + " value=\"Yes\"> <br/><br/>");
                            
							out.println("<div id=\"hrule\" style=\"height: 0px\" ></div>");
							i++;
                        }       
                        rs.close();
                        conn.close();
                    %>
                    
                    	<input type="submit" value="SUBMIT">
    				</form>
    				
    				</div>
    				
                    <div id="hrule" style="height: 60px"></div>
                    <div id="hrule" style="height: 60px"></div>
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

