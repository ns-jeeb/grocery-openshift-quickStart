
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
    $(document).ready(function(){
        $("#ordDatePicker").datepicker();
        $("#shipDatePicker").datepicker();

    })
</script>


<form:form method="post" commandName="order">
    <table border="1">
        <tr>
            <th>&nbsp;</th>
            <th>Add Order</th>
        </tr>
        <tr>
            <td bgcolor="cyan">Customer:</td>
            <td><form:input path="customer" size="40" />
                <font color="#FF0000"><form:errors path="customer" /></font></td>
        </tr>
        <tr>
            <td bgcolor="cyan">Product:</td>
            <td><form:input path="product" size="40" />
                <font color="#FF0000"><form:errors path="product" /></font></td>
        </tr>
        <tr>
            <td bgcolor="cyan">Order date:</td>
            <td><form:input path="orderDate" size="40"  id="ordDatePicker"/>
                <font color="#FF0000"><form:errors path="orderDate" /></font></td>
        </tr>
        <tr>
            <td bgcolor="cyan">Ship date:</td>
            <td><form:input path="shipDate" size="40" id="shipDatePicker" />
                <font color="#FF0000"><form:errors path="shipDate" /></font></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>
    </table>

    <form:hidden path="id" />
</form:form>
<%--${order}--%>
<p>${order.customer}</p>
<p>${order.orderDate}</p>
<p>${order.product}</p>
<p>${order.shipDate}</p>