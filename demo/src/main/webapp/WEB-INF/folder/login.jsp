<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="utf-8" class="no-js"> <![endif]-->
<!--[if !(IE)]><!--><html lang="utf-8" class="no-js"> <!--<![endif]-->
<head>
	<title>UOS25 Login</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="description" content="QueenAdmin - Beautiful Bootstrap Admin Dashboard Theme">
	<meta name="author" content="The Develovers">

	<!-- CSS -->
	<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="resources/css/ionicons.css" rel="stylesheet" type="text/css">
	<link href="resources/css/main.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,300,400,700' rel='stylesheet' type='text/css'>

	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/queenadmin-favicon144x144.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/queenadmin-favicon114x114.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/queenadmin-favicon72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="57x57" href="resources/ico/queenadmin-favicon57x57.png">
	<link rel="shortcut icon" href="resources/ico/favicon.png">

</head>
<body class="middle-content page-login">
	<div class="top-bar text-center"><a href="index.html"><img src="resources/img/uos25.png" alt="UOS25 Logo"></a></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5 col-sm-offset-1 col-lg-4 col-lg-offset-2">
				<div class="content-box-bordered login-box box-with-help">
					<h1>Log in to your account</h1>
					<form class="form-horizontal" role="form" method="post" action="/authenticate">
						${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'Bad credentials', 'Username/Password are incorrect')}
						<div class="form-group">
							<label for="inputId" class="control-label sr-only">Id</label>
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<input type="text" class="form-control" id="inputId" placeholder="Id" name="id">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3b" class="control-label sr-only">Password</label>
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-cloud"></i></span>
									<input type="password" class="form-control" id="inputPassword3b" placeholder="Password" name="pw">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<label class="fancy-checkbox">
									<input type="checkbox">
									<span>Remember me</span>
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-7">
								<button type="submit" class="btn btn-success btn-block">Sign in</button>
							</div>
							<div class="col-xs-5 text-right">
								<a href="#"><em>forgot password?</em></a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-5 col-lg-4">
				<div class="login-copytext">
					<h2>About UOS25</h2>
					<p>모두의 삶에 가치를 더하는 UOS25는 언제 어디서나 최상의 상품과 서비스를 제공하여 고객가치를 실현하고 사회발전에 공헌하는 기업으로 성장하고자 합니다.</p>
					<p>UOS25, which adds value to everyone's lives, aims to grow into a company that realizes customer value and 
					contributes to social development by providing the best products and services whenever and wherever.</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascript -->
	<script src="resources/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="resources/js/bootstrap/bootstrap.js"></script>
	<script src="resources/js/queen-form-layouts.js"></script>

</body>
</html>