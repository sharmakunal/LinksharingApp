<%@ page import="com.kunal.Entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/dashboardCSS.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <style type="text/css">

    </style>
</head>
<body>

<div class="container">
    <header>
        <%
            User user=(User)session.getAttribute("user");
            if (user==null)
                response.sendRedirect("/");
        %>
        <div class="row ">
            <div class="col-md-12 header">
                <div class="linkshare">
                    <a href="#">Link Sharing</a>
                </div>
                <div class="icon">
               	     <span class="searchSpan">
	                     <span class="glyphicon glyphicon-search"></span>
	                     <input type="text" class="noborder" placeholder="Search">
	                     <span class="glyphicon glyphicon-remove-sign"></span>
	                  </span>

                    <%@include file="createtopic.jsp" %>
                    <%@include file="invitation.jsp" %>
                    <%@include file="urlresource.jsp" %>
                    <%@include file="documentresources.jsp"%>
                    <img src="/springbean/displayImage" class="imagethumbnail" style="width:30px;height:30px "/>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                            <% out.print(user.getUsername());%>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <%-- --%>
                            <li><a href="<c:url value="edit-profile"/>">
                                Profile</a></li>
                            <li><a href="#">Users</a></li>
                            <li><a href="#">Topices</a></li>
                            <li><a href="#">Posts</a></li>
                            <li><a href="<c:url value="logout"/>">Logout</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </header>