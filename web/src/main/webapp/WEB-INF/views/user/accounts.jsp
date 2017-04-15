<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div STYLE="border-radius: 4px; background-color:#fffb7b; width: 690px; height: 30px">
    <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Счета</div>

    <div style="margin-top: 20px">

        <div style="float: left; margin-left: 10%">ID Account</div>
        <div style="float: left; margin-left: 25%">Balance</div>
        <div style="float: left; margin-left: 25%">Count card</div>

        <br>
        <c:forEach var="account" items="${accounts}" >
            <div class="row">
                <div class=col-md-4 style="text-align: center">${account.getId()}</div>
                <div class=col-md-4 style="text-align: center">${account.getBalance()}</div>
                <div class=col-md-4 style="text-align: center">count</div>
            </div>
            <br>
        </c:forEach>
        </b>
        <div style="margin-top: 400px; margin-left: 20px">
        <t:paginator step="8" count="6" urlprefix="?&startNumber="></t:paginator>
        </div>

    </div>

</div>