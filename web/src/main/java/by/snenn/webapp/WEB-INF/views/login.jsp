<%@ include file="/assests/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e" %>
<e:url value="/j_spring_security_check" var="loginUrl" />
<form class="form-horizontal" method="post"  action="${loginUrl}">

<fieldset>

        <!-- Form Name -->
        <p align="center">Добро пожаловать!</p>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="j_username">Логин</label>
            <div class="col-md-4">
                <input id="j_username" name="j_username" type="text" value="" placeholder="login" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="j_password">Пароль</label>
            <div class="col-md-4">
                <input id="j_password" name="j_password" type="password"  class="form-control input-md" required="">
                <span class="help-block">Введите пароль</span>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
            </div>
        </div>


    </fieldset>
</form>
    <%@ include file="/assests/include/end-html.jsp" %>
