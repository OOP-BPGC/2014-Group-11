<%@ page import="java.util.*" %>
<html>
    <head>

        <link rel="stylesheet" type="text/css" href="res/css/main.css">
        <link rel="stylesheet" type="text/css" href="res/css/header.css">
        <link rel="stylesheet" type="text/css" href="res/css/footer.css">
        <title>LOG-IN</title>
        
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

                    <div id="header" class="unselect">

            <a href="index.html" id="info">Home
                <p>Zephyr '15 Home-page</p>
            </a>

            <a href="comp.jsp" id="info">Competitions                          
                <p>View the details of the competitions</p>
            </a>

            <a href="score.js[" id="info">Score-board  
                <p>View the score-board</p>
            </a>
            
            <a href="logout" id="info">Logout                   
                <p>Log into your account</p>
            </a>
            <div id="hrule"></div>
        </div>
        
        
        
        <div id="body" class="unselect">
            

                
            <link rel="stylesheet" type="text/css" href="res/css/home.css">
                <div style="float: left; margin-left: 100px; margin-right : 100px; margin-top : 50px;">
                    <form  method="post" > <h3>LOGIN</h3><br/><br/>                        <!-- need to set action link-->
                    Username: <input type="text" name="username" placeholder="Username"> <br/><br/>
                    Password: <input type="password" name="password" placeholder="Password"> <br/><br/>
                    <%
                    String check = (String) request.getAttribute("check");
                    if(check != null) {
                    if(check.equals("false")) {
                      out.println("<h5 style=\"color:red\">   Invalid Credentials </h5>");
                    }
                    }
                    %>
                    <input type="submit" value="Login">
                    </form>

            </div>
            
        </div>
        
        <div id="footer" class="unselect">
            <a id="info" href="http://www.bits-pilani.ac.in/Goa/" target="_blank">BPGC
                <p>Go to BITS Pilani,Goa Homepage</p>
            </a>

            <a href="developers.html" id="info">developers                                                                     
                <p>Get to know the people involved in the development of this website</p>   
            </a>

            <div id="hrule"></div>    
        </div>
        
        <a name="bottom"></a>
        
    </body>
</html>
