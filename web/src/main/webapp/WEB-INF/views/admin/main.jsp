<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/resourses/include/begin-html.jsp" %>
<%@ include file="/WEB-INF/views/admin/admin.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" style="margin-top: 30px">

        <div STYLE="border-radius: 4px; background-color: ghostwhite; width: 750px;  height: 530px; float: right">
            <%@ include file="/WEB-INF/views/admin/creditCards.jsp" %>
        </div>


        <div STYLE="border-radius: 4px; background-color: ghostwhite; width: 360px; height: 250px">
            <br><p style="text-align: center; margin-top: 20px">Личные данные администратора</p><br>
            <p style="margin-left: 20px">Фамилия:   ${user.surname}</p>
            <p style="margin-left: 20px">Имя:   ${user.name}</p>
            <p style="margin-left: 20px">Логин: ${user.login}</p>
            <p style="margin-left: 20px">Пароль:    ${user.password}</p>

        </div>

        <div STYLE="border-radius: 4px; background-color: ghostwhite; margin-top: 30px; width: 360px; height: 250px">
            <br><p style="text-align: center; margin-top: 20px">Общие данные системы платежей</p><br>
            <p style="margin-left: 20px">Общее число клиентов:  </p>
            <p style="margin-left: 20px">Общее число счетов:    </p>
            <p style="margin-left: 20px">Общее число кредитных карт:    </p>
            <p style="margin-left: 20px">Всего денег на всех счетах:    </p>
        </div>






    </div>
<br>
<%@ include file="/resourses/include/end-html.jsp" %>
</html>