<!DOCTYPE html>
<%@ page import="java.util.*" %> 
<%@ page import="java.time.*" %>
<%
	class Person
	{
		private String fName ; 
		private String lName ; 
		private String hostel ; 
		private String type ; /* Can be normal, hr or controls */ 
		public Person(String fn, String ln, String host, String ty)
		{
			fName = fn ; 
			lName = ln ; 
			hostel = host ; 
			type = ty ;
		}
		public void setFName(String fn)
		{
			this.fName = fn ; 
		}
		public void setLName(String ln)
		{
			this.lName = ln ; 
		}
		public void setHostel(String host)
		{
			hostel = host ; 
		}
		public void setType(String ty)
		{
			type = ty ; 
		}
		public String getFName()
		{
			return fName ; 
		}
		public String getLName()
		{
			return lName ; 
		}
		public String getHostel()
		{
			return hostel ; 
		}
		public String getType()
		{
			return type ; 
		}
	}
	class Pair
	{
		Person p ; 
		int rank ; 
		public Pair(String fn, String ln, String host, String ty, int rn)
		{
			p = new Person(fn,ln,host,ty) ; 
			rank = rn ; 
		}
		public int getRank()
		{
			return rank ; 
		}
		public Person getPerson()
		{
			return p ; 
		}
	}
	class CustomComparator implements Comparator<Pair> 
	{
		@Override 
		public int compare(Pair p1, Pair p2)
		{
			if(p1.getRank() < p2.getRank())
				return 1 ; 
			else
				return 0 ; 
		}
	}
	class Event
	{
		private ArrayList<Pair> participants = new ArrayList<Pair> () ; 
		private String venue; 	
		private int year ; 
		private int month ; 
		private int date ; 
		public ArrayList<Pair> getParticipants()
		{
			Collections.sort(participants, new CustomComparator()) ; 
			return participants ; 
		}
		public int getYear()
		{
			return year ; 
		}
		public int getMonth()
		{
			return month ; 
		}
		public int getDate()
		{
			return date ; 
		}
		public void setYear(int ye)
		{
			year = ye ; 
		}
		public void setMonth(int mon)
		{
			month = mon ; 
		}
		public void setDate(int da)
		{
			date = da ; 
		}
	}
	class Zephyr /* This class will contain all the info regarding zephyr at inital loading of application. */ 
	{
		public ArrayList<Event> events = new ArrayList<Event> () ; 
	}	

		
%>
<html>
    <head>

        <link rel="stylesheet" type="text/css" href="main.css">
        <link rel="stylesheet" type="text/css" href="header.css">
        <link rel="stylesheet" type="text/css" href="footer.css">
        <title>ZEPHYR</title>
        
    </head>
    
    <body>
        
        <div id="topp">
            <div>
                <img id="logo" src="zephyr.jpg">
                <div>
                    <p style="font-size:60px">Zephyr'14</p>
                    <p style="font-size:22px">Inter Hostel Fest</p>
                </div>
                <div id="hrule"></div>
            </div>
        </div>
        
        <div id="header" class="unselect">

            <a href="?page=home" id="info">Home
                <p>Zephyr '15 Home-page</p>
            </a>

            <a href="" id="info">Competitions
                <p>View the details of the competitions</p>
            </a>

            <a href="" id="info">Score-board
                <p>View the score-board</p>
            </a>
            
            <a href="" id="info">Schedule
                <p>View the Time and Venue of Zephyr'15</p>
            </a>

            <div id="hrule"></div>
        </div>
        
        
        
        <div id="body" class="unselect">
            
            <div id="content">
                
            <link rel="stylesheet" type="text/css" href="res/css/home.css">

            <title>ZZZZZ</title>

            <div id="home">
                <div class="container">
                    <div  id="slides">
                        <img id = "logo" src="zephyr.jpg">
                    </div>
                </div>
                <div id="hrule" style="height: 20px"></div>
                    <h2 style="margin-left: 300px;">About</h2>
                        <h4 style="margin-left: 300px;">
                            The annual intra-college (inter-hostel) festival of BITS Pilani K.K. Birla Goa Campus. <br/>
                            Zephyr'14 Dates: 25-28 September<br/>
                            Theme: Outwit.Outplay.Outlast.<br/>
                            Spread over 3 days with over 60 sports, technical and cultural events. 
                            The campus turns into a battleground with 14 hostels trying to prove their worth. This year from September 26-29.
                        </h4>

                    <div id="hrule" style="height: 180px"></div>

                    <table class="tableizer-table">
                    <tr class="tableizer-firstrow"><th></th><th></th><th></th><th></th></tr>
                        <tr>
                            <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                                <img alt="Zephyr Convener" src=""  width="150" /></a> </td>
                                    <td ><h4>Convener</h4>
                                        <a href="https://www.facebook.com/srinath.rajagopalan.94" target="_blank">
                                            <b><h5><u>Srinath R</u></h5></b></a>
        &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;Some Designation<br />&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;Something<br />
        &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;Mail - f2012xxx@xxx<br />&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;Contact: +91-xxxxxxxxxx<br />
                            </td>

                            <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                                <img alt="Zephy Manager" src="" width="150" height="150" /></a></td>
                                    <td><h4>Manager</h4>
                                        <a href="https://www.facebook.com/deepika.ghodki" target="_blank">
                                            <b><h5><u>Deepika G</u></h5></b></a><br />&nbsp;&nbsp;
            &nbsp;&nbsp; &nbsp;&nbsp;Mail - f2012yyy@gggsdf <br />&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; Contact: +91-xxxxxxxxxx</td>
                        </tr>
                    </table>

                    <div id="hrule" style="height: 50px"></div>

                </div>
                
                <div id="hrule" style="height: 60px"></div>
                
            </div>
            
        </div>
        
        <div id="footer" class="unselect">
            <a id="info" href="http://www.bits-pilani.ac.in/Goa/" target="_blank">BPGC
                <p>Go to BITS Pilani,Goa Homepage</p>
            </a>

            <a href="?page=developers" id="info">Developers
                <p>Get to know the people involved in the development of this website</p>
            </a>

            <div id="hrule"></div>    
        </div>
        
        <a name="bottom"></a>
        
    </body>
</html>
