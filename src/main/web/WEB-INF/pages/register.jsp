
<%--
  Created by IntelliJ IDEA.
  User: Jeeb
  Date: 10/27/2015
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../layout/taglibs.jsp"%>
${user.name}
<div class="formClass" style="padding-top: 20px;">
    <h2>This page is not under constructed</h2>
    <%--<h2>Message : ${message}</h2>--%>
    <%--<h2>Message : ${title}</h2>--%>

    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
        <%--<h3>User Info : ${pageContext.request.userPrincipal.name}--%>
            <%--| <a href="<c:url value="/" />" >Logout</a></h3>--%>
    <%--</c:if>--%>

    <%--<form:form name='f' commandName="user"  method='POST'>--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>User:</td>--%>
                <%--<td><form:input type='text' name='username' value='' path="name"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Password:</td>--%>
                <%--<td><form:input type='password' name='password'  path="password"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td><input name="submit" type="submit" value="submit" /></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</form:form>--%>
    <%--${message}--%>


    <form:form commandName="user" cssClass="form-horizontal">

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <form:input path="password" cssClass="form-control"/>
            </div>
        </div>
    <div class="form-group">
         <div class="col-sm-2">
             <input type="submit" value="Save" class="btn btn-lg btn-primary" />
            </div>
        </div>

</form:form>

</div>