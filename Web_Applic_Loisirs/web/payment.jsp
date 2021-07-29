<%-- 
    Document   : payment
    Created on : 27 nov. 2020, 19:30:12
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%
HttpSession nsession = request.getSession();
%>
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
                <form class="login100-form validate-form" action="ShopServlet" method="POST">
                    <span class="login100-form-logo">
			<i class="zmdi zmdi-landscape"></i>
                    </span>
                    
                    <span class="login100-form-title p-t-27">
			Payement
                    </span>

                    <div class="wrap-input100">
			<input class="input25" type="radio" id="visite" name="shop" value="end" checked>
                        <label class="input75" for="visite">Payement et déconnexion</label>
                    </div>

                    <div class="container-login100-form-btn p-b-34">
                        <button class="login100-form-btn" name="request" value="end">
                            Continuer
			</button>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" name="request" value="cancel">
                            Cancel
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
