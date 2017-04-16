<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/resourses/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 900px; height: 150px; margin-left: 200px; float: left">
    <%@ include file="personalData.jsp" %>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 230px; height: 150px; margin-left: 1110px">
    <%@ include file="exchangeRates.jsp" %>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 200px; height: 500px; margin-left: 200px; float: left; margin-top: 10px">
    <%@ include file="menu.jsp" %>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 690px; height: 500px; margin-left: 10px; float: left; margin-top: 10px">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div STYLE="border-radius: 4px; background-color:#fffb7b; width: 690px; height: 30px">
        <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Создание перевода</div>

        <div style="margin-left: 20px; margin-top: 20px">

        Ваша карта не должна быть заблокирована.<br><br>
        Выберите карту с которой будет произведен перевод.<br><br>
        Остаток средств на карте должен быть больше или равен сумму перевода.<br><br>
            <form action="/user/createTransfer" method="post">
                <select class="form-control" style="width: 400px" name="selectCard">
                    <c:forEach var="card" items="${cards}">
                        <option>ID ${card.getId()} balance ${card.account.getBalance()} byn </option>
                    </c:forEach>
                </select><br>
        Сумма перевода должна быть целой<br><br>
        <input style="width: 400px" id="sum" name="sum" type="text" placeholder="input sum" class="form-control input-md" required="">
        <br>
        Карта получателя должна существовать и не должна быть заблокирована.<br><br>
        <input style="width: 400px" id="idRecipient" name="idRecipient" type="text" placeholder="input id card Recipient" class="form-control input-md" required="">
        <br>

        <button class="btn btn-success" type="submit" name="createTransfer" >Создать перевод</button>
        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
        </form>
        </div>
    </div>


</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 230px; height: 500px; margin-left: 10px; float: left; margin-top: 10px">
    <%@ include file="news.jsp" %>
</div>
<%@ include file="/resourses/include/end-html.jsp" %>
