<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div STYLE="border-radius: 4px; background-color:#fffb7b; width: 690px; height: 30px">
    <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Платежи</div>

    <div style="margin-top: 20px">
        <div class="row" style="margin-left: 10px">
            <div class=col-md-2 >ID transfer</div>
            <div class=col-md-2 style="text-align: center">id card sender</div>
            <div class=col-md-3 style="text-align: center">id card recipient</div>
            <div class=col-md-1 style="text-align: center">sum</div>
            <div class=col-md-4 style="text-align: center">data</div>
        </div>

        <br>
        <c:forEach var="transfer" items="${transfers}" >
            <div class="row">
                <div class=col-md-2 style="text-align: center">${transfer.getId()}</div>
                <div class=col-md-2 style="text-align: center">${transfer.cardSender.getId()}</div>
                <div class=col-md-3 style="text-align: center">${transfer.cardRecipient.getId()}</div>
                <div class=col-md-1 style="text-align: center">${transfer.getSum()}</div>
                <div class=col-md-4 style="text-align: center">${transfer.getData()}</div>
            </div>
            <br>
        </c:forEach>
        </b>
        <div style="margin-top: 400px; margin-left: 20px">
            <t:paginator step="8" count="6" urlprefix="?&startNumber="></t:paginator>
        </div>

    </div>

</div>