
<%--
  Created by IntelliJ IDEA.
  User: Jeeb
  Date: 10/27/2015
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/taglibs.jsp" %>
<%@include file="/layout/allJquriandcssLinks.jsp" %>

<script>
    $(function(){
        $("p").draggable();
    });
</script>

<!-- Datepicker -->
<div class="input-group date" >
<h2>This page is not under constructed</h2>
</div>

<div class="input-group date">
    <form:form commandName="user">
        <form:input path="datepicker" id="datepick"/>
        <form:button value="submit">submit</form:button>
    </form:form>
</div>
<p>${user.datepicker}</p>
