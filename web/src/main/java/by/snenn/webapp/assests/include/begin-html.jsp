<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>pay</title>
    <link href="assests/css/bootstrap.css" rel="stylesheet" />
    <script src="assests/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <style>
        body {
            background-image: url("/assests/include/background.jpg");
        }
    </style>

<body>

<div class="container">

      <!-- Static navbar, смотрите пример тут: http://bootstrap-3.ru/examples/navbar/ -->

      <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
              <sec:authorize access="isAuthenticated()">
                  <a class="navbar-brand">Hello, <sec:authentication property="principal.displayName"/></a>
                  <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
              </sec:authorize>
          </div>

          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <a class="navbar-brand" href=/login>Войти</a>
                    <a class="navbar-brand" href=/reg>Зарегестрироваться</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
                    <a class="navbar-brand" href=/logout>Выйти</a>
                </sec:authorize>

            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>


</div>