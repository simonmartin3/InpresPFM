<%-- 
    Document   : articles
    Created on : 27 nov. 2020, 22:48:33
    Author     : Simon
--%>

<%@page import="BeanBDAccess.Article"%>
<%@page import="java.util.List"%>
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
                <form class="login100-form validate-form" action="CaddieServlet" method="POST">
                    <span class="login100-form-logo">
			<i class="zmdi zmdi-landscape"></i>
                    </span>

                    <span class="login100-form-title p-t-5">
                        <%=nsession.getAttribute("user.session")%>
                    </span>
                    
                    <span class="login100-form-title p-t-27">
			Bienvenue sur PFM Loisir
                    </span>
					
                    <span class="login100-form-subtitle p-b-34">
			Le site des loisirs près de chez vous                                          
                    </span>

                    <table border ="1" align="center"> 
                        <tr> 
                            <th><b>Article Name</b></th> 
                            <th><b>Article Price</b></th> 
                            <th><b>Article Quantity</b></th>
                            <th><b>Add</b></th>
                        </tr> 
                        <%List<Article> aList =  
                            (List<Article>)request.getAttribute("data"); 
                        for(Article s:aList){%> 
                        <tr> 
                            <td><%=s.getNom()%></td> 
                            <td><%=s.getPrix()%></td> 
                            <td class="select"><select id="<%=s.getQuantite()%>" name="<%=s.getIdArticle()%>">
                                <%for(int i = 0; i < s.getQuantite()+1; i++) 
                                {%>
                                    <option value="<%=i%>"><%=i%></option>
                                <%}%>
                            </td>
                            <td class="add">
                                <button class="icon" name="add" value="<%=s.getIdArticle()%>">
                                    <i class="fa fa-eur" aria-hidden="true"></i>
                                </button>
                            </td> 
                        </tr> 
                        <%}%> 
                    </table>
                       
                    <span class="login100-form-subtitle p-t-27 p-b-8">
                        Panier
                    </span>
                    <table border ="1" align="center"> 
                        <tr> 
                            <th><b>Article Name</b></th> 
                            <th><b>Article Price</b></th> 
                            <th><b>Article Quantity</b></th>
                        </tr>
                        <%if(request.getAttribute("panier") != null)
                        {
                            float total = 0;
                            List<Article> pList =  
                            (List<Article>)request.getAttribute("panier"); 
                            for(Article s:pList){
                            total = total + s.getPrix()*s.getQuantite();    
                        %> 
                        <tr> 
                            <td><%=s.getNom()%></td> 
                            <td><%=s.getPrix()%></td> 
                            <td><%=s.getQuantite()%></td>
                        </tr> 
                        <%}%>
                        <tr>
                            <td colspan="2">
                                Total :
                            </td>
                            
                            <td><%=total%>€</td>
                        </tr>
                        <%}else
                        {
                        %>
                        <tr>
                            <td colspan="2">
                                Total :
                            </td>
                            
                            <td>0.00€</td>
                        </tr>
                        <%
                        }%>
                    </table>

                    <div class="container-login100-form-btn p-t-27 p-b-34">
                        <button class="login100-form-btn" name="request" value="next">
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
