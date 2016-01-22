
<%--
  Created by IntelliJ IDEA.
  User: Jeeb
  Date: 10/25/2015
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglibs.jsp"%>
<tilesx:useAttribute name="current"/>
<html>
<head>
  <title><tiles:getAsString name="tiles"/></title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #8FB8B8"><nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"> </span>
            </button>
            <a class="navbar-brand"  href="<spring:url value="/"/>" >My Blog</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${current=='index' ?'active':''}"><a href="<spring:url value="/"/>">Home</a></li>
                <li class="${current=='users' ?'active':''}"><a href="<spring:url value="users"/>">Users</a></li>
                <li class="${current=='contact' ?'active':''}"><a href="<spring:url value="/"/>">Contact</a></li>
                <li class="${current=='register' ?'active':''}"><a href="<spring:url value="register"/>">Register</a></li>
                <li class="dropdown">
                    <a href="<spring:url value="/"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="caret">Community </span></a>
                    <ul class="dropdown-menu">
                        <li class="${current=='action' ?'active':''}"><a href="<spring:url value="order"/>">Kids Education</a></li>
                        <li class="${current=='a action' ?'active':''}"><a href="<spring:url value="/"/>">Community News</a></li>
                        <li class="${current=='som Else' ?'active':''}"><a href="<spring:url value="grocery"/>">Create Grocery List</a></li>
                        <li role="separator" class="divider"></li>
                        <%--<li class="dropdown-header">Nav header</li>--%>
                        <li class="${current=='separated' ?'active':''}"><a href="<spring:url value="/"/>">Separated link</a></li>
                        <li class="${current=='one more' ?'active':''}"><a href="<spring:url value="/"/>#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>
</nav>

<div id="central"  >
${current}
    <div style=" width: 1700px; margin-right: auto; margin-left: auto; ">
        <body:insertAttribute name="body"/>



    </div>

</div>
<div style="margin-bottom: 10px"><center><footer:insertAttribute name="footer"/></center></div>



</body>
</html>
