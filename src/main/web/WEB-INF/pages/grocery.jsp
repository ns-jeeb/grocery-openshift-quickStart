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

    <form:form commandName="item" id="grocery_form">
        <div>
            <div style="float: left;">
                <h2 style="background-color: #EDA698;">${beef.get(0)}</h2>
                <c:forEach items="${beef}" var="beef">
                    <c:choose>
                        <c:when test="${beef.equals('Beef')}">

                        </c:when>
                        <c:otherwise>
                            <div style="padding-right: 10px">
                                <p style="font-family: sans-serif; font-size: 5mm">
                                    <form:checkbox path="partName" value="${beef}"/>
                                    <c:out value="${beef}"/></p>
                            </div>

                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </div>
            <div style="float: left;">
                <h2 style="background-color: #EDA698;"><c:out value="${lamb.get(0)}"/></h2>
                <c:forEach items="${lamb}" var="lamb">
                    <c:choose>
                        <c:when test="${lamb.equals('Lamb')}">

                        </c:when>
                        <c:otherwise>
                            <div style="padding-right: 10px">
                                <p style="font-family: sans-serif; font-size: 5mm">
                                    <form:checkbox path="partName" value="${lamb}"/>
                                    <c:out value="${lamb}"/></p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
            <div style="float: left;">
                <h2 style="background-color: #EDA698;"><c:out value="${goat.get(0)}"/></h2>
                <c:forEach items="${goat}" var="goat">
                    <c:choose>
                        <c:when test="${goat.equals('Goat')}">

                        </c:when>
                        <c:otherwise>
                            <div style="padding-right: 10px">
                                <p style="font-family: sans-serif; font-size: 5mm">
                                    <form:checkbox path="partName" value="${goat}"/>
                                    <c:out value="${goat}"/></p>
                            </div>
                        </c:otherwise>
                    </c:choose>


                </c:forEach>
            </div>
            <div style="float: left;">
                <h2 style="background-color: #EDA698;"><c:out value="${chicken.get(0)}"/></h2>
                <c:forEach items="${chicken}" var="chicken">
                    <c:choose>
                        <c:when test="${chicken.equals('Chicken')}">

                        </c:when>
                        <c:otherwise>
                            <div style="padding-right: 10px">
                                <p style="font-family: sans-serif; font-size: 5mm">
                                    <form:checkbox path="partName" value="${chicken}"/>
                                    <c:out value="${chicken}"/></p>
                            </div>

                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </div>
            <div style="float: left;">
                <h2 style="background-color: #EDA698;"><c:out value="${pork.get(0)}"/></h2>
                <c:forEach items="${pork}" var="pork">
                    <c:choose>
                        <c:when test="${pork.equals('Pork')}">

                        </c:when>
                        <c:otherwise>
                            <div style="padding-right: 10px">
                                <p style="font-family: sans-serif; font-size: 5mm">
                                    <form:checkbox path="partName" value="${pork}"/>
                                    <c:out value="${pork}"/></p>
                            </div>

                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
            <div style="float: left;">

                <h2 style="background-color: #069E18;"><c:out value="${vegetable.get(0)}"/></h2>

                <div id="first" style="height: 600px;overflow-y: scroll;">
                    <c:forEach items="${vegetable}" var="vege">
                        <c:choose>
                            <c:when test="${vege.equals('Vegetable')}">

                            </c:when>
                            <c:otherwise>
                                <p style="font-family: sans-serif; font-size: 5mm">
                                    <form:checkbox path="partName" value="${vege}"/>
                                    <c:out value="${vege}"/>
                                </p>

                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </div>

            </div>
            <div style="float: left;">
                <h2 style="background-color: #069E18; padding-left: 20px;"><c:out value="${fruit.get(0)}"/></h2>

                <div contenteditable="true" style="overflow-y: scroll;height: 600px;">
                    <c:forEach items="${fruit}" var="fruit">
                        <c:choose>
                            <c:when test="${fruit.equals('Fruit')}">

                            </c:when>
                            <c:otherwise>
                                <p style="font-family: sans-serif; padding-left: 20px; font-size: 5mm">
                                    <form:checkbox path="partName" value="${fruit}"/>
                                    <c:out value="${fruit}"/>
                                </p>

                            </c:otherwise>
                        </c:choose>

                    </c:forEach>

                </div>
            </div>




        </div>


        <div style="width: 200px">
            <form:button value="Submit" class="btn_submit" name="createTable">Create Table</form:button>

        </div>


    </form:form>







