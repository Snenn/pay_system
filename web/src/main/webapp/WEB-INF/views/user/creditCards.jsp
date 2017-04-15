<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div STYLE="border-radius: 4px; background-color:#fffb7b; width: 690px; height: 30px">
    <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Кредитные карты</div>

    <div style="margin-top: 20px">

        <div style="float: left; margin-left: 10%">ID credit cart</div>
        <div style="float: left; margin-left: 25%">ID account</div>
        <div style="float: left; margin-left: 25%">Balance</div>

        <br>
        <c:forEach var="card" items="${cards}" >
            <div class="row">
                <div class=col-md-4 style="text-align: center">${card.getId()}</div>
                <div class=col-md-4 style="text-align: center">${card.account.getId()}</div>
                <div class=col-md-4 style="text-align: center">${card.account.getBalance()}</div>
            </div>
            <br>
        </c:forEach>
        </b>
        <div style="margin-top: 400px; margin-left: 20px">
            <t:paginator step="8" count="6" urlprefix="?&startNumber="></t:paginator>
        </div>

    </div>

</div>