<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <style>
        body {
            padding-top: 50px;
        }

    </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Banco del Perú</a>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="page-header">Account Registration</h1>

    <form action="register">
        <div class="col-md-8 col-md-offset-2">

            <div class="form-group">
                <label for="username" >Username: </label>
                <input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus>
            </div>

            <div class="form-group">
                <label for="password" >Password: </label>
                <input type="password" name="password" id="password" class="form-control" placeholder="Password" required autofocus>
            </div>

            <div class="form-group">
                <label for="password_confirmation" >Re-enter password: </label>
                <input type="password" name="password_confirmation" id="password_confirmation" class="form-control" placeholder="Re-enter password" required autofocus>
            </div>

            <div class="form-group">
                <label for="email" >Email: </label>
                <input type="email" name="email" id="email" class="form-control" placeholder="Email" required autofocus>
            </div>

            <div class="form-group">
                <label for="email_confirmation" >Re-enter email: </label>
                <input type="email" name="email_confirmation" id="email_confirmation" class="form-control" placeholder="Re-enter email" required autofocus>
            </div>

            <div class="form-group">
                <label for="phone" >Phone: </label>
                <input type="phone" name="phone" id="phone" class="form-control" placeholder="Phone" required autofocus>
            </div>

            <br/>

            <div class="form-group">
                <label for="firstName" >First Name: </label>
                <input type="text" name="firstName" id="firstName" class="form-control" placeholder="First Name" required autofocus>
            </div>

            <div class="form-group">
                <label for="lastName" >Last Name: </label>
                <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Last Name" required autofocus>
            </div>

            <div class="form-group">
                <label for="ssn" >SSN: </label>
                <input type="text" name="ssn" id="ssn" class="form-control" placeholder="SSN" required autofocus>
            </div>

            <div class="form-group">
                <label for="address" >Address: </label>
                <input type="text" name="address" id="address" class="form-control" placeholder="Address" required autofocus>
            </div>

            <div class="form-group">
                <label for="city" >City: </label>
                <input type="text" name="city" id="city" class="form-control" placeholder="City" required autofocus>
            </div>

            <div class="form-group">
                <label for="province" >Province: </label>
                <input type="text" name="province" id="province" class="form-control" placeholder="Province" required autofocus>
            </div>

            <div class="form-group">
                <label for="dob" >Date of birth: </label>
                <input type="text" name="dob" id="dob" class="form-control" placeholder="Date of birth" required autofocus>
            </div>

            <br/>

            <div class="form-group">
                <label for="securityQuestion1">Question 1:</label>
                <select class="form-control" name="securityQuestion1" id="securityQuestion1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <label for="answer1">Answer 1:</label>
                <input type="text" name="answer1" id="answer1" placeholder="Answer your question 1" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="securityQuestion2">Question 2:</label>
                <select class="form-control" name="securityQuestion2" id="securityQuestion2">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <label for="answer2">Answer 2:</label>
                <input type="text" name="answer2" id="answer2" placeholder="Answer your question 2" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="securityQuestion3">Question 3:</label>
                <select class="form-control" name="securityQuestion3" id="securityQuestion3">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <label for="answer3">Answer 3:</label>
                <input type="text" name="answer3" id="answer3" placeholder="Answer your question 3" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="securityQuestion4">Question 4:</label>
                <select class="form-control" name="securityQuestion4" id="securityQuestion4">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <label for="answer4">Answer 4:</label>
                <input type="text" name="answer4" id="answer4" placeholder="Answer your question 4" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="securityQuestion5">Question 5:</label>
                <select class="form-control" name="securityQuestion5" id="securityQuestion5">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <label for="answer5">Answer 5:</label>
                <input type="text" name="answer5" id="answer5" placeholder="Answer your question 5" class="form-control"/>
            </div>


            <button type="submit" class="btn btn-primary btn-block">Submit</button>

        </div>
    </form>

</div>


</body>


</html>
