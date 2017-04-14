<%@ include file="/resourses/include/begin-html.jsp" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<s:form id="registrationForm" class="form-horizontal" action="reg/signUp" modelAttribute="userForm" method="post">
<fieldset>

<!-- Form Name -->
<p align="center">Регистрация пользователя</p>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="surname">Введите фамилию</label>
  <div class="col-md-4">
  <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Введите имя</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Введите логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Введите пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="OKreg"></label>
  <div class="col-md-4">
    <button id="OKreg" name="OKreg" class="btn btn-success">Зарегестрироваться</button>
  </div>
</div>




</fieldset>
</s:form>

<%@ include file="/resourses/include/end-html.jsp" %>

