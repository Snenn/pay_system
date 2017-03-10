<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/assests/include/begin-html.jsp" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<form class="form-horizontal" action="/web/logIn" method="get">
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


    </fieldset>
</form>

<%@ include file="/assests/include/end-html.jsp" %>
