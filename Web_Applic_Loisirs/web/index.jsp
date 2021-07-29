<%-- 
    Document   : index
    Created on : 20 nov. 2020, 14:53:36
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<title>PFM Loisirs</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
<!--===============================================================================================-->
</head>
<body>
    <div class="limiter">
	<div class="container-login100" style="background-image: url('images/background.jpg');">
            <div class="wrap-login100">
                <form class="login100-form validate-form" action="LoginServlet" method="POST">
                    <span class="login100-form-logo">
			<i class="zmdi zmdi-landscape"></i>
                    </span>

                    <span class="login100-form-title p-t-27">
			Bienvenue sur PFM Loisir
                    </span>
					
                    <span class="login100-form-subtitle p-b-34">
			Le site des loisirs près de chez vous                                          
                    </span>

                    <div class="wrap-input100 validate-input" data-validate = "Enter username">
			<input class="input100" type="text" name="username" placeholder="Username">
                        <span class="focus-input100" data-placeholder="&#xf207;"></span>
                    </div>

                    <div class="wrap-input100" data-validate="Enter password">
                        <input class="input100" type="text" name="pass" placeholder="Password">
                        <span class="focus-input100" data-placeholder="&#xf191;"></span>
                    </div>

                    <div class="container-login100-form-btn p-b-34">
                        <button class="login100-form-btn" name="request" value="login">
                            Login
			</button>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" name="request" value="nopass">
                            No password ?
			</button>
                    </div>
		</form>
            </div>
        </div>
    </div>
    
    <div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/vendor/daterangepicker/moment.min.js"></script>
	<script src="<%=request.getContextPath()%>/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/js/main.js"></script>

</body>
</html>
