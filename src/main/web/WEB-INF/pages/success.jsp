<%--
  Created by IntelliJ IDEA.
  User: Jeeb
  Date: 10/27/2015
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>

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
</script>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/taglibs.jsp" %>
<form:form commandName="tempTable">
    <%--<c:forEach items="${rib}" var="meatParts">--%>
        <%--<div>--%>
            <%--<form:checkbox path="items" value="${meatParts}"/>--%>
            <%--<c:out value="${meatParts}"/>--%>


        <%--</div>--%>
    <%--</c:forEach>--%>

    <form:button value="Submit" name="CompleteGrocery" >Complated Grocery</form:button>
</form:form>
${good}
