<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.group11.app.zephyr.*" %>
<!DOCTYPE html>
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
            	<div>
                    <h2 style="margin-left: 360px;">SCOREBOARD:</h2>
                    <div id="hrule" style="height: 40px"></div> 
                    	<table class="tableizer-table " style="margin-left: 200px;">
                    	<tr class="tableizer-firstrow"><th></th><th></th><th> </th><th></th></tr>
                    	<tr >
                    		<td><font size = 5px><b> Name Of Event &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td> 
                    		<td><font size = 5px><b> Person &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td>
                    		<td><font size = 5px><b> Rank &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td>
                    		
                    	</tr>  
						
						<%
						
					ArrayList<Tuple> a = new ArrayList<Tuple>();
					
					RankList rl = new RankList();
					
					a = rl.getRank();
					
					for(int i=0; a.size(); i++)
					{	
						out.println("<tr>");
                    	out.println("<td><font size = 5px>" + a.get(i).comp.name + "</font></td>");
                    	out.println("<td><font size = 5px>" + a.get(i).stud.getFname() + "</font></td>");
                    	out.println("<td><font size = 5px>" + a.get(i).rank + "</font></td>");
                    	out.println("</tr>");
					}

					%>
						
						
						
						</table>
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
