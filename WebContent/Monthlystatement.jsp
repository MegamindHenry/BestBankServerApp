<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="trastienda.modelo.Customer" %>

<html>
  <head>
	<title>Monthly Statement</title>
	<!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
          <!-- Latest compiled and minified CSS -->


      <!-- Latest compiled and minified JavaScript -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
         
	<script type="text/javascript">
    	var datefield=document.createElement("input")
    	datefield.setAttribute("type", "date")
    	if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        	document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        	document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        	document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n') 
    	}
	</script>

	<script type="text/javascript">
    	var datefield=document.createElement("input")
    	datefield.setAttribute("type", "date1")
    	if (datefield.type!="date"){ //if browser doesn't support input type="date", load files for jQuery UI Date Picker
        	document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        	document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        	document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n') 
    	}
	</script>
	

	
	<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
 
	<script>
		if (datefield.type!="date"){ //if browser doesn't support input type="date", initialize date picker widget:
    	jQuery(function($){ //on document.ready
        	$('#monthlystat').datepicker();
    	})
		}
	</script>

	<script>
		if (datefield.type!="date1"){ //if browser doesn't support input type="date", initialize date picker widget:
    	jQuery(function($){ //on document.ready
        	$('#monthlystat1').datepicker({ dateFormat: 'dd/mm/yy'}).datepicker("setDate", new Date());
	    })
		}
	</script>
	

	

	
	  <style>
        /*
 * Base structure
 */

        /* Move down content because we have a fixed navbar that is 50px tall */
        body {
            padding-top: 50px;
        }


        /*
         * Global add-ons
         */

        .sub-header {
            padding-bottom: 10px;
            border-bottom: 1px solid #eee;
        }

        /*
         * Top navigation
         * Hide default border to remove 1px line.
         */
        .navbar-fixed-top {
            border: 0;
        }

        /*
         * Sidebar
         */

        /* Hide for mobile, show later */
        .sidebar {
            display: none;
        }
        @media (min-width: 768px) {
            .sidebar {
                position: fixed;
                top: 51px;
                bottom: 0;
                left: 0;
                z-index: 1000;
                display: block;
                padding: 20px;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
                background-color: #f5f5f5;
                border-right: 1px solid #eee;
            }
        }

        /* Sidebar navigation */
        .nav-sidebar {
            margin-right: -21px; /* 20px padding + 1px border */
            margin-bottom: 20px;
            margin-left: -20px;
        }
        .nav-sidebar > li > a {
            padding-right: 20px;
            padding-left: 20px;
        }
        .nav-sidebar > .active > a,
        .nav-sidebar > .active > a:hover,
        .nav-sidebar > .active > a:focus {
            color: #fff;
            background-color: #428bca;
        }


        /*
         * Main content
         */

        .main {
            padding: 20px;
        }
        @media (min-width: 768px) {
            .main {
                padding-right: 40px;
                padding-left: 40px;
            }
        }
        .main .page-header {
            margin-top: 0;
        }


        /*
         * Placeholder dashboard ideas
         */

        .placeholders {
            margin-bottom: 30px;
            text-align: center;
        }
        .placeholders h4 {
            margin-bottom: 0;
        }
        .placeholder {
            margin-bottom: 20px;
        }
        .placeholder img {
            display: inline-block;
            border-radius: 50%;
        }
    </style>

</head>

<body>
<!--  test -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="dashboard.jsp">Banco del Perú</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%
                    Customer c = (Customer)session.getAttribute("login");
                    String salutation = "";
                    String firstName = "";
                    String middleName = "";
                    String lastName = "";
                    String nameSuffix = "";
                    salutation = c.getSalutation();
                    firstName = c.getFirstName();
                    middleName = c.getMiddleName();
                    lastName = c.getLastName();
                    nameSuffix = c.getNameSuffix();
                    out.println("<li class=\"dropdown\">" +
                            "<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-expanded=\"false\">"+c.getUsername()+"<span class=\"caret\"></span></a>" +
                            "<ul class=\"dropdown-menu\" role=\"menu\">" +
                            "<li><a href=\"logout\">Logout</a></li>" +
                            "</ul>" +
                            "</li>");
                %>
            </ul>
        </div>
    </div>
</nav>


<!--  test -->


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="dashboard.jsp">Home</a></li>
                <li><a href="Monthlystatement.jsp">Monthly Statement</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Monthly Statement - <small><% out.println(salutation + " " + firstName + " " + middleName + " " + lastName + " " + nameSuffix); %></small></h1>

        </div>
    </div>
</div>

 <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">	
  <div class="container">
	<!--  not needed --> <!-- <a  href="#" ><p class="text-right">Logout</p></a>-->
	<h3>Monthly Statement</h3></br> 	
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">User Account: </span>
 		<div class="dropdown">
  			<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
   			 Select 
   	 		<span class="caret"></span>
  			</button>
  		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
    		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
    		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
  		</ul>
		</div>
	</div></br>
	
	<div class="col-lg3">
    <div class="input-group">
    <span class="input-group-addon" id="sizing-addon1">Start Date: </span>
      <input type="date" class="form-control" id="monthlystat" placeholder="Input Date">
    </div><!-- /input-group -->
  	</div>
 
 </br>
 
  	<div class="col-lg3">
    <div class="input-group">
    <span class="input-group-addon" id="sizing-addon1">End  Date:  </span>
      <input type="date1" class="form-control" id="monthlystat1">
    </div><!-- /input-group -->
  	</div>
  	</br>
  	<button type="button"  class="btn btn-default">Search</button>
	</br>
	
	<table class="table table-striped">
      <thead>
        <tr>
          <th>Description</th>
          <th>Date</th>
          <th>Withdrawal</th>
          <th>Deposits</th>
          <th>Balance</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row"></th>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th scope="row">Total</th>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
	<button type="button"  class="btn btn-primary">Back</button>

    </div>
   </div>	 
    </body>
</html>