<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div>

    <div class="container-fluid">

        <br>
        <div class="row" style="margin-top: 20px">
            <b>
            <div class=col-md-3 style="text-align: center">ID</div>
            <div class=col-md-3 style="text-align: center">Login</div>
            <div class=col-md-3 style="text-align: center">Surname</div>
            <div class=col-md-3 style="text-align: center">Name</div>
            </b>
        </div>
        <br>
        <c:forEach var="user" items="${users}" >
            <div class="row">
                    <div class=col-md-3 style="text-align: center">${user.getId()}</div>
                    <div class=col-md-3 style="text-align: center">${user.getLogin()}</div>
                    <div class=col-md-3 style="text-align: center">${user.getSurname()}</div>
                    <div class=col-md-3 style="text-align: center">${user.getName()}</div>
            </div>
            <br>
        </c:forEach>
        <t:paginator step="8" count="${adCount}" urlprefix="?&startNumber="></t:paginator>
    </div>
</div>

