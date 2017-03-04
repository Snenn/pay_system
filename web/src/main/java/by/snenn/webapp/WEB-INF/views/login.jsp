<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/assests/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-horizontal" action="do?command=LOGIN" method="POST">
    <fieldset>

        <!-- Form Name -->
        <p align="center">Добро пожаловать!</p>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" value="" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Пароль</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" value="" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль</span>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="registr"></label>
            <div class="col-md-4">
                <button id="registr" name="registr" class="btn btn-success"><a href="do?command=SignUp">Зарегистрироваться</a></button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="/assests/include/end-html.jsp" %>
