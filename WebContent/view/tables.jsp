<!--

=========================================================
* Now UI Dashboard - v1.5.0
=========================================================

* Product Page: https://www.creative-tim.com/product/now-ui-dashboard
* Copyright 2019 Creative Tim (http://www.creative-tim.com)

* Designed by www.invisionapp.com Coded by www.creative-tim.com

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="view/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="view/assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    BTN movie admin
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  <!-- CSS Files -->
  <link href="view/assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="view/assets/css/now-ui-dashboard.css?v=1.5.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="view/assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="orange">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
      <div class="logo">
        <a href="admin" class="simple-text logo-mini">
          ADMIN
        </a>
        <a href="http://www.creative-tim.com" class="simple-text logo-normal">
          BTN movie
        </a>
      </div>
      <div class="sidebar-wrapper" id="sidebar-wrapper">
        <ul class="nav">
          <li>
            <a href="admin">
              <i class="now-ui-icons design_app"></i>
              <p>Dashboard</p>
            </a>
          </li>
          
          <li>
            <a href="adduser">
              <i class="now-ui-icons users_single-02"></i>
              <p>Add user</p>
            </a>
          </li>
          <li>
            <a href="addvideo">
              <i class="now-ui-icons users_single-02"></i>
              <p>Add movie</p>
            </a>
          </li>
          <li class="active ">
            <a href="table">
              <i class="now-ui-icons design_bullet-list-67"></i>
              <p>Table List</p>
            </a>
          </li>
          
        </ul>
      </div>
    </div>
    <div class="main-panel" id="main-panel">
     <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent  bg-primary  navbar-absolute">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="#pablo">${userfullname }</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
            
            <ul class="navbar-nav">
              

              <li class="nav-item">
                <a class="nav-link" href="logout">
                  <form action="logout" method="post">
                  <button style="border:none;background-color:#285280"><p style="color:white;font-size:15px">LOGOUT</p></button>
                  </form>
                  <p>
                    <span class="d-lg-none d-md-block">Account</span>
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="panel-header panel-header-sm">
      </div>
      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h4 class="card-title"> USER LIST</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table">
                    <thead class=" text-primary">
                      <th>
                        ID
                      </th>
                      <th>
                        Username
                      </th>
                      <th>
                        Password
                      </th>
                      <th >
                        Email
                      </th>
                      <th >
                        Admin
                      </th>
                      <th >
                        Edit
                      </th>
                    </thead>
                    <tbody>
                    <c:forEach var="i" begin="0" end="${indexuser }">
                      <tr>
                        <td>
                          ${listuser[i].id }
                        </td>
                        <td>
                          ${listuser[i].username }
                        </td>
                        <td>
                          ${listuser[i].password }
                        </td>
                        <td >
                          ${listuser[i].email }
                        </td>
                        <td >
                          ${listuser[i].admin }
                        </td>
                        <td >
                          <form action="edituser" method="post"> 
                          <input name="iduser" type="hidden" value="${listuser[i].id }">
                          <button style="border:none;background-color:white;">Edit</button>
                          </form>
                        </td>
                      </tr>
                     </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="card card-plain">
              <div class="card-header">
                <h4 class="card-title"> LIST MOVIES</h4>
               
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table">
                    <thead class=" text-primary">
                      <th>
                        ID
                      </th>
                      <th>
                        Title
                      </th>
                      <th>
                        Poster
                      </th>
                      
                      
                      <th>
                        Views
                      </th>
                      <th>
                        Active
                      </th>
                      <th>
                        Edit
                      </th>
                      
                    </thead>
                    <tbody>
                    <c:forEach var="i" begin="0" end="${indexsize }">
                      <tr>
                        <td>
                          ${listaz[i].id }
                        </td>
                        <td>
                          ${listaz[i].title }
                        </td>
                        <td>
                          ${listaz[i].poster }
                        </td>
                        <td>
                          ${listaz[i].view }
                        </td>
                        <td>
                          ${listaz[i].active }
                        </td>
                        <td>
                        <form action ="editvideo" method="post"> 
                          <input name="idvideo" type="hidden" value="${listaz[i].id }">
                          <button style="border:none;background-color:light-gray;">Edit</button>
                          </form>
                        </td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="view/assets/js/core/jquery.min.js"></script>
  <script src="view/assets/js/core/popper.min.js"></script>
  <script src="view/assets/js/core/bootstrap.min.js"></script>
  <script src="view/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="view/assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="view/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="view/assets/js/now-ui-dashboard.min.js?v=1.5.0" type="text/javascript"></script><!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
  <script src="view/assets/demo/demo.js"></script>
</body>

</html>