<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
	<title>Monthly Statement</title>
	<!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
         
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
        	$('#monthlystat1').datepicker();
	    })
		}
	</script>

</head>

<body>

  <div class="container">
	<a  href="#" ><p class="text-right">Logout</p></a>
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
      <input type="date1" class="form-control" id="monthlystat1" placeholder="Input Date">
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
    </body>
</html>