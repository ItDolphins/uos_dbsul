<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%
	String pagefile = request.getParameter("page");
	if(pagefile == null) {pagefile = "home";}
%>

<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="en" class="no-js"> <![endif]-->
<!--[if !(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
	<title>UOS25 Management System</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="description" content="QueenAdmin - Beautiful Bootstrap Admin Dashboard Theme">
	<meta name="author" content="The Develovers">
	<!-- CSS -->
	<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="resources/css/ionicons.css" rel="stylesheet" type="text/css">
	<link href="resources/css/main.css" rel="stylesheet" type="text/css">
	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,300,400,700' rel='stylesheet' type='text/css'>
	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" type="image/png" sizes="144x144" href="resources/ico/queenadmin-favicon144x144.png">
	<link rel="apple-touch-icon-precomposed" type="image/png" sizes="114x114" href="resources/ico/queenadmin-favicon114x114.png">
	<link rel="apple-touch-icon-precomposed" type="image/png" sizes="72x72" href="resources/ico/queenadmin-favicon72x72.png">
	<link rel="apple-touch-icon-precomposed" type="image/png" sizes="57x57" href="resources/ico/queenadmin-favicon57x57.png">
	<link rel="shortcut icon" href="resources/ico/favicon.ico">
</head>

<body class="fixed-top-active dashboard">
<!-- WRAPPER -->
<div class="wrapper">
	<!-- TOP NAV BAR -->
	<nav class="top-bar navbar-fixed-top" role="navigation">
		<div class="logo-area">
			<a href="#" id="btn-nav-sidebar-minified" class="btn btn-link btn-nav-sidebar-minified pull-left"><i class="icon ion-arrow-swap"></i></a>
			<a class="btn btn-link btn-off-canvas pull-left"><i class="icon ion-navicon"></i></a>
			<div class="logo pull-left">
				<a href="/home">
					<img src="resources/img/uos25.png" alt="UOS25 Logo" />
				</a>
			</div>
		</div>
		<form class="form-inline searchbox hidden-xs" role="form">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="icon ion-ios-search"></i></span>
					<input type="search" class="form-control" placeholder="search the site ...">
				</div>
			</div>
		</form>
		<div class="top-bar-right pull-right">
			<div class="action-group hidden-xs hidden-sm">
				<ul>
					<!-- end skins -->
					<!-- notification: inbox -->
					<li class="action-item inbox">
						<div class="btn-group">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="icon ion-ios-email-outline"></i><span class="count">2</span>
							</a>
							<div class="arrow"></div>
							<ul class="dropdown-menu" role="menu">
								<li class="menu-item-header">You have 2 unread messages</li>
								<li class="inbox-item clearfix">
									<a href="#">
										<div class="media">
											<div class="pull-left">
												<img class="media-object" src="resources/img/user1.png" alt="Antonio">
											</div>
											<div class="media-body">
												<h5 class="media-heading name">Antonius</h5>
												<p class="text">The problem just happened this morning. I can't see ...</p>
												<span class="timestamp text-muted">4 minutes ago</span>
											</div>
										</div>
									</a>
								</li>
								<li class="inbox-item unread clearfix">
									<a href="#">
										<div class="media">
											<div class="pull-left">
												<img class="media-object" src="resources/img/user2.png" alt="Antonio">
											</div>
											<div class="media-body">
												<h5 class="media-heading name">Michael</h5>
												<p class="text">Hey dude, cool theme!</p>
												<span class="timestamp text-muted">2 hours ago</span>
											</div>
										</div>
									</a>
								</li>
								<li class="inbox-item unread clearfix">
									<a href="#">
										<div class="media">
											<div class="pull-left">
												<img class="media-object" src="resources/img/user3.png" alt="Antonio">
											</div>
											<div class="media-body">
												<h5 class="media-heading name">Stella</h5>
												<p class="text">Ok now I can see the status for each item. Thanks! :D</p>
												<span class="timestamp text-muted">Oct 6</span>
											</div>
										</div>
									</a>
								</li>
								<li class="inbox-item clearfix">
									<a href="#">
										<div class="media">
											<div class="pull-left">
												<img class="media-object" src="resources/img/user4.png" alt="Antonio">
											</div>
											<div class="media-body">
												<h5 class="media-heading name">Jane Doe</h5>
												<p class="text"><i class="icon ion-reply text-muted"></i> Please check the status of your ...</p>
												<span class="timestamp text-muted">Oct 2</span>
											</div>
										</div>
									</a>
								</li>
								<li class="inbox-item clearfix">
									<a href="#">
										<div class="media">
											<div class="pull-left">
												<img class="media-object" src="resources/img/user5.png" alt="Antonio">
											</div>
											<div class="media-body">
												<h5 class="media-heading name">John Simmons</h5>
												<p class="text"><i class="icon ion-reply text-muted"></i> I've fixed the problem :)</p>
												<span class="timestamp text-muted">Sep 12</span>
											</div>
										</div>
									</a>
								</li>
								<li class="menu-item-footer">
									<a href="#">View All Messages</a>
								</li>
							</ul>
						</div>
					</li>
					<!-- end notification: inbox -->
					<!-- notification: general -->
					<li class="action-item general">
						<div class="btn-group">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="icon ion-ios-bell-outline"></i><span class="count">8</span>
							</a>
							<ul class="dropdown-menu" role="menu">
								<li class="menu-item-header">You have 8 notifications</li>
								<li>
									<a href="#">
										<i class="icon ion-chatbubble text-success"></i>
										<span class="text">New comment on the blog post</span>
										<span class="timestamp text-muted">1 minute ago</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-person-add text-success"></i>
										<span class="text">New registered user</span>
										<span class="timestamp text-muted">12 minutes ago</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-chatbubble text-success"></i>
										<span class="text">New comment on the blog post</span>
										<span class="timestamp text-muted">18 minutes ago</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-ios-cart text-danger"></i>
										<span class="text">4 new sales order</span>
										<span class="timestamp text-muted">4 hours ago</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-edit yellow-font"></i>
										<span class="text">3 product reviews awaiting moderation</span>
										<span class="timestamp text-muted">1 day ago</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-chatbubble text-success"></i>
										<span class="text">New comment on the blog post</span>
										<span class="timestamp text-muted">3 days ago</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-chatbubble text-success"></i>
										<span class="text">New comment on the blog post</span>
										<span class="timestamp text-muted">Oct 15</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon ion-alert-circled text-danger"></i>
										<span class="text text-danger">Low disk space!</span>
										<span class="timestamp text-muted">Oct 11</span>
									</a>
								</li>
								<li class="menu-item-footer">
									<a href="#">View All Notifications</a>
								</li>
							</ul>
						</div>
					</li>
					<!-- end notification: general -->
				</ul>
			</div>
			<div class="logged-user">
				<div class="btn-group">
					<a href="#" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
						<img src="resources/img/user-loggedin.png" alt="Sebastian" /><span class="name"><sec:authentication property="principal.username"/> <i class="icon ion-ios-arrow-down"></i></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="#">
								<i class="icon ion-ios-person"></i>
								<span class="text">Profile</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="icon ion-ios-gear"></i>
								<span class="text">Settings</span>
							</a>
						</li>
						<li>
							<a href="/logout">
								<i class="icon ion-power"></i>
								<span class="text">Logout</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="action-group visible-lg-inline-block">
				<ul>
					<li class="action-item chat">
						<a href="#" id="toggle-right-sidebar" class="toggle-right-sidebar"><i class="icon ion-ios-chatboxes-outline"></i><span class="count">5</span></a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END TOP NAV BAR -->
	<!-- COLUMN LEFT -->
	<div id="col-left" class="col-left">
		<div class="main-nav-wrapper">
			<nav id="main-nav" class="main-nav">
				<h3>MAIN</h3>
				<ul class="main-menu">
						<li>
							<a href="/home"><i class="icon ion-ios-speedometer-outline"></i><span class="text">메인</span></a>
						</li>
					<sec:authorize access="hasRole('USER')">
					<li>
						<a href="/manage_employee"><i class="icon ion-ios-contact"></i><span class="text">직원 정보 관리</span></a>
					</li>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')">
					<li>
						<a href="/manage_branch"><i class="icon ion-ios-contact"></i><span class="text">지점 정보 관리</span></a>
					</li>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')">
					<li>
						<a href="/manage_admin"><i class="icon ion-ios-contact"></i><span class="text">지점 관리자 정보 관리</span></a>
					</li>
					</sec:authorize>
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-ios-flask-outline"></i><span class="text">품목 관리</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li><a href="/prod_Info"><span class="text">물품 조회</span></a></li>
							<li><a href="/prod_manage"><span class="text">물품 관리</span></a></li>
						</ul>
					</li>
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-ios-flask-outline"></i><span class="text">이벤트 관리</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li><a href="/event_Info"><span class="text">이벤트 조회</span></a></li>
							<li><a href="/event_manage"><span class="text">이벤트 추가</span></a></li>
						</ul>
					</li>
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-ios-flask-outline"></i><span class="text">물품 관리</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li><a href="/manage_order"><span class="text">발주 관리</span></a></li>
						</ul>
					</li>
					<sec:authorize access="hasRole('ADMIN')">
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-social-designernews"></i><span class="text">출고 관리</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li><a href="/show_rls"><span class="text">출고 종합</span></a></li>
							<li><a href="/show_sell"><span class="text">판매 정보</span></a></li>
						</ul>
					</li>
					</sec:authorize>
					<sec:authorize access="hasRole('USER')">
					<li>
						<a href="/sell_product"><i class="icon ion-social-designernews"></i><span class="text">판매</span></a>
					</li>
					</sec:authorize>
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-ios-copy-outline"></i><span class="text">Pages</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li><a href="page-projects.html"><span class="text">Projects</span></a></li>
							<li><a href="page-project-detail.html"><span class="text">Project Detail</span></a></li>
							<li><a href="page-user-profile.html"><span class="text">Profile</span></a></li>
							<li><a href="page-search-result.html"><span class="text">Search Result</span></a></li>
							<li><a href="page-inbox.html"><span class="text">Inbox</span><span class='badge bg-orange'>12</span></a></li>
							<li><a href="page-view-message.html"><span class="text">View Message</span></a></li>
							<li><a href="page-new-message.html"><span class="text">New Message</span></a></li>
							<li><a href="page-knowledgebase.html"><span class="text">Knowledge Base</span></a></li>
							<li><a href="page-submit-ticket.html"><span class="text">Submit Ticket</span></a></li>
							<li><a href="page-faq.html"><span class="text">FAQ</span></a></li>
							<li><a href="page-pricing-tables.html"><span class="text">Pricing Tables</span></a></li>
							<li><a href="page-invoice.html"><span class="text">Invoice</span></a></li>
							<li><a href="page-register.html"><span class="text">Register</span></a></li>
							<li><a href="page-login.html"><span class="text">Login</span></a></li>
							<li><a href="page-login-alt.html"><span class="text">Login Alt.</span></a></li>
							<li><a href="page-404.html"><span class="text">Not Found 404</span></a></li>
							<li><a href="page-505.html"><span class="text">Error 505</span></a></li>
							<li><a href="page-blank.html"><span class="text">Blank Page</span></a></li>
						</ul>
					</li>
				</ul>
				<h3>ESSENTIALS</h3>
				<ul class="main-menu">
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-ios-pie-outline"></i><span class="text">Charts</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li class="active"><a href="charts-basic.html"><span class="text">Basic</span></a></li>
							<li><a href="charts-interactive.html"><span class="text">Interactive Charts</span></a></li>
						</ul>
					</li>
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-ios-grid-view-outline"></i><span class="text">Tables</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li class="active"><a href="tables-static.html"><span class="text">Static Table</span></a></li>
							<li><a href="tables-dynamic.html"><span class="text">Dynamic Table</span></a></li>
						</ul>
					</li>
					<li><a href="maps.html"><i class="icon ion-ios-world-outline"></i><span class="text">Maps</span></a></li>
					<li><a href="typography.html"><i class="icon ion-ios-compose-outline"></i><span class="text">Typography</span></a></li>
					<li class="has-submenu">
						<a href="#" class="submenu-toggle"><i class="icon ion-navicon"></i><span class="text">Menu Levels</span></a>
						<ul class="list-unstyled sub-menu collapse">
							<li class="has-submenu">
								<a href="#" class="submenu-toggle"><span class="text">Second Lvl A</span></a>
								<ul class="list-unstyled sub-menu collapse">
									<li><a href="#"><span class="text">Third Lvl A1</span></a></li>
									<li><a href="#"><span class="text">Third Lvl A2</span></a></li>
									<li><a href="#"><span class="text">Third Lvl A3</span></a></li>
								</ul>
							</li>
							<li><a href="#"><span class="text">Second Lvl B</span></a></li>
							<li><a href="#"><span class="text">Second Lvl C</span></a></li>
							<li><a href="#"><span class="text">Second Lvl D</span></a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	
	