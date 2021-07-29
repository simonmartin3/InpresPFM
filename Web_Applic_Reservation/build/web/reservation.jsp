<%-- 
    Document   : reservation
    Created on : 3 déc. 2020, 14:42:32
    Author     : Simon
--%>

<%@page import="BeanBDAccess.Destination"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Réservation</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #999999;">
	<div class="limiter">
        <div class="container-login100">
            <div class="login100-more" style="background-image: url('images/background.jpg');"></div>
		<div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-20">
					Réservation
				</span>

				<!--<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Your Name</span>
					<input class="input100" type="text" name="name" placeholder="Enter your name">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
					<span class="label-input100">Email</span>
					<input class="input100" type="text" name="email" placeholder="Enter your email addess">
					<span class="focus-input100"></span>
				</div>-->
                                
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Destination</span>
					<div>
						<select class="selection-2" name="destination">
							<option>Choose Destination</option>
							<%List<Destination> dList =  
                                                        (List<Destination>)request.getAttribute("dest"); 
                                                        for(Destination s:dList){%>
                                                        <option value="<%=s.getVille()%>"><%=s.getVille()%></option>
							<%}%>
						</select>
					</div>
					<span class="focus-input100"></span>
				</div>
                                
                                <div class="wrap-input100 validate-input" data-validate = "Valid id container is required: X-000-XXX">
					<span class="label-input100">Container ID</span>
					<input class="input100" type="text" name="idContainer" placeholder="Enter id container">
					<span class="focus-input100"></span>
				</div>
                                
                                <div class="wrap-input100 validate-input" data-validate = "Contenu is required">
					<span class="label-input100">Container contenu</span>
					<input class="input100" type="text" name="contenu" placeholder="Enter contenu">
					<span class="focus-input100"></span>
				</div>
                                
                                <div class="wrap-input100 validate-input" data-validate = "Capacity is required">
					<span class="label-input100">Container capacity</span>
					<input class="input100" type="text" name="capacity" placeholder="Enter capacity">
					<span class="focus-input100"></span>
				</div>
                                
                                <div class="wrap-input100 validate-input">
					<span class="label-input100">Container Danger</span>
					<input class="input100" type="text" name="danger" placeholder="Enter Danger">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Valid id transporteur is required: 000-000-000">
					<span class="label-input100">Transporteur ID</span>
					<input class="input100" type="text" name="idTransporteur" placeholder="Enter id transporteur">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
						<button class="login100-form-btn" name="request" value="reserve">
							<span>
                                                            Reserve
                                                            <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
							</span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
        </div>


	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

</body>
</html>