
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/taglibs.jsp" %>
<%@include file="/layout/allJquriandcssLinks.jsp" %>

<!-- Carousel
================================================== -->
<h2>This page is not under constructed and it is not finished </h2>
<c:if test="${not empty users}">
<div style="float: left; margin-left: 10px;margin-top: 10px;">
    <div class="bs-example">
        <div id="hair_styl_row" class="carousel slide" data-ride="carousel">

                Hair style
                <ol class="carousel-indicators">
                    <% int i =1;%>
                    <li data-target="#hair_styl_row" data-slide-to="0" class="active"></li>
                    <c:forEach var="listValue" items="${users}">
                        <li data-target="#hair_styl_row" data-slide-to="<%=i++%>"></li>

                    </c:forEach>
                </ol>
                <div class="carousel-inner"  style="width: 390px;height: 300px;">

                    <div class="item active" style="padding: 15px;">

                            <%--<li data-target="#hair_styl_row2" data-slide-to="1"></li>--%>
                            <%--<li data-target="#hair_styl_row2" data-slide-to="2"></li>--%>

                        Name: <label>Najeeb</label><br>
                        Business: <label><a href="<spring:url value="users"/>" >Hair Salaon</a></label><br>
                        Contact: <label>(416) 858 - 5588</label><br>
                        Email: <label></label>
                    </div>
                    <c:forEach var="listValue" items="${users}">
                        <div class="item"  style="padding: 15px;">
                            <div><img style="width: 100px; height: 100px;" src="../../images/1.jpg"/> </div>
                            Name: <a href="<spring:url value="users"/>" >${listValue.name}</a><br>
                            Business: <label></label><br>
                            Contact: <label>(416) 858 - 5588</label><br>
                            Email: <label>${listValue.email}</label>
                        </div>
                    </c:forEach>
                </div>

                <a class="carousel-control left" href="#hair_styl_row" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="carousel-control right" href="#hair_styl_row" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
        </div>
    </div>
</div>
</c:if>


    <%--<div style="float: left; margin-left: 10px; margin-top: 10px;">--%>
       <%--<div class="bs-example" >--%>
            <%--<div id="real_statat_styl_row" class="carousel slide" data-ride="carousel">--%>
                <%--Real State--%>
                <%--<!-- Carousel indicators -->--%>
                <%--<ol class="carousel-indicators">--%>
                    <%--<li data-target="#real_statat_styl_row" data-slide-to="0" class="active"></li>--%>
                    <%--<li data-target="#real_statat_styl_row" data-slide-to="1"></li>--%>
                    <%--<li data-target="#real_statat_styl_row" data-slide-to="2"></li>--%>
                <%--</ol>--%>
                <%--<!-- Wrapper for carousel items -->--%>

                <%--<div class="carousel-inner" >--%>
                    <%--<div class="item active" style="width: 390px;height: 300px; background-color: blue">--%>
                        <%--Name: <label>Najeeb</label><br>--%>
                        <%--Business: <label>Hair Salaon</label><br>--%>
                        <%--Contact: <label>(416) 858 - 5588</label><br>--%>
                        <%--Email: <label>someThing@gmail.com</label>--%>
                    <%--</div>--%>
                    <%--<div class="item" style="width: 390px;height: 300px; background-color: red">--%>
                        <%--Name: <label>Najeeb</label><br>--%>
                        <%--Business: <label>Hair Salaon</label><br>--%>
                        <%--Contact: <label>(416) 858 - 5588</label><br>--%>
                        <%--Email: <label>someThing@gmail.com</label>--%>
                    <%--</div>--%>
                    <%--<div class="item" style="width: 390px;height: 300px; background-color: green">--%>
                        <%--Name: <label>Najeeb</label>--%>
                        <%--Business: <label>Hair Salaon</label>--%>
                        <%--Contact: <label>(416) 858 - 5588</label>--%>
                        <%--Email: <label>someThing@gmail.com</label>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<!-- Carousel controls -->--%>
                <%--<a class="carousel-control left" href="#real_statat_styl_row" data-slide="prev">--%>
                    <%--<span class="glyphicon glyphicon-chevron-left"></span>--%>
                <%--</a>--%>
                <%--<a class="carousel-control right" href="#real_statat_styl_row" data-slide="next">--%>
                    <%--<span class="glyphicon glyphicon-chevron-right"></span>--%>
                <%--</a>--%>

            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>