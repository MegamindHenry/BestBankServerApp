<%--
  Created by IntelliJ IDEA.
  User: jorge
  Date: 22/05/15
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Banco del Peru</title>

      <style>
          body {
              padding-top: 40px;
              padding-bottom: 40px;
              background-color: #eee;
          }

          .form-signin {
              max-width: 330px;
              padding: 15px;
              margin: 0 auto;
          }
          .form-signin .form-signin-heading,
          .form-signin .checkbox {
              margin-bottom: 10px;
          }
          .form-signin .checkbox {
              font-weight: normal;
          }
          .form-signin .form-control {
              position: relative;
              height: auto;
              -webkit-box-sizing: border-box;
              -moz-box-sizing: border-box;
              box-sizing: border-box;
              font-size: 16px;
              margin-bottom: 10px;
          }
          .form-signin .form-control:focus {
              z-index: 2;
          }
          .form-signin input[type="email"] {
              margin-bottom: -1px;
              border-bottom-right-radius: 0;
              border-bottom-left-radius: 0;
          }
          .form-signin input[type="password"] {
              margin-bottom: 10px;
              border-top-left-radius: 0;
              border-top-right-radius: 0;
          }
          .box .col-md-4 {
              padding-top: 5px;
          }
      </style>

      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  </head>
  <body>

  <%
      if(session.getAttribute("login") != null && !session.getAttribute("login").equals("")){
          response.sendRedirect("dashboard.jsp");
          // demo de David	
          // oja una mas
      }
  %>

      <div class="container">

          <form action="login" class="form-signin" method="POST">

              <div class="box">
                  <div class="col-md-4">
                      <label for="userid" >User ID</label>
                  </div>
                  <div class="col-md-8">
                      <input type="text" name="username" id="userid" class="form-control" placeholder="User ID" required autofocus>
                  </div>
                  <div class="col-md-4">
                      <label for="inputPassword" >Password</label>
                  </div>
                  <div class="col-md-8">
                      <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                  </div>
              </div>
              <div class="clearfix"></div>
              <div class="checkbox">
                  <label>
                      <input type="checkbox" value="remember-me"> Remember me
                  </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>

              <a href="#" class="btn btn-link">Forgot Password</a>
              <a href="#" class="btn btn-link">Create Account</a>

          </form>

      </div> <!-- /container -->

  </body>
</html>
