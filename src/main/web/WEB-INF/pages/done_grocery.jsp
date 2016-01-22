<%--
  Created by IntelliJ IDEA.
  User: Jeeb
  Date: 11/9/2015
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
  function confirmForChanges() {
    var r = confirm("Do you want to proceed");
    if (r) {
      alert("Your changes have been saved");
    } else {
      alert("changes not saved")
    }
    return r;//if true then submit else don't submit
  }

  $(document).ready(function(){
    $(".btn_submit").click(function(){
      $("#first").removeAttr();
    });

  });

</script>



<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="display" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/taglibs.jsp"%>



<form:form commandName="item">
  <c:forEach items="${meatsParts}" var="meatParts">
    <div>
      <form:checkbox path="animalName" value="${meatParts}"/>
      <c:out value="${meatParts}"/>

    </div>
  </c:forEach>

  <form:button value="Submit" name="CompleteGrocery"> <form:hidden path="animalName"/> Complated Grocery</form:button>
</form:form>






${message}






