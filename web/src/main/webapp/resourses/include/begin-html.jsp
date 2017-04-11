<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<e:url value="/j_spring_security_check" var="loginUrl" />
<head >
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>pay</title>
    <link href="resourses/css/bootstrap.css" rel="stylesheet" />
    <script src="resourses/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>

<body>

<div class="container">

        <div class="navbar-header" style=" margin-top: 7px" >
                    <img src="../../resourses/images/logo.png" height="40" width="40" >
        </div>
        
        <div class="navbar-header">
            <ul class="nav navbar-nav navbar-right">
                <c:set var="locale" value="${pageContext.response.locale}"/>
                    <li><a href="?locale=en" ><spring:message code="title.en"/>  <img src="../../resourses/images/eng.png"></a></li>
                    <li><a href="?locale=ru"><spring:message code="title.ru"/>  <img src="../../resourses/images/rus.png"></a></li>
            </ul>
        </div>
        
    <div class="navbar-collapse collapse">

        <div class="navbar-header navbar-right" role="form">
            <sec:authorize access="isAuthenticated()">
                <a class="navbar-brand"><spring:message code="title.hello"/> <sec:authentication property="principal.displayName"/></a>
                <a type="submit" style="margin-top: 10px" class="btn btn-default" href=/logout><spring:message code="title.logout"/></a>
            </sec:authorize>
        </div>

        <sec:authorize access="!isAuthenticated()">
        <form class="navbar-form navbar-right" role="form" method="post"  action="${loginUrl}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <input id="j_username" name="j_username" type="text" placeholder="<spring:message code="title.login"/>" class="form-control">
            </div>
            <div class="form-group">
                <input id="j_password" name="j_password" type="password" placeholder="<spring:message code="title.password"/>" class="form-control">
            </div>
            <button type="submit" class="btn btn-default"><spring:message code="title.signIn"/></button>
            <a type="submit" class="btn btn-default" href=/reg><spring:message code="title.signUp"/></a>
        </form>
        </sec:authorize>

    </div>
</div>


</div>