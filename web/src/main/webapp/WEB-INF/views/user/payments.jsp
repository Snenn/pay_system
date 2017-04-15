<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div STYLE="border-radius: 4px; background-color:#fffb7b; width: 690px; height: 30px">
    <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Платежи</div>

    <div style="margin-top: 20px">
        <div class="row" style="margin-left: 10px">
            <div class=col-md-2 >ID payment</div>
            <div class=col-md-3 style="text-align: center">id card</div>
            <div class=col-md-3 style="text-align: center">sum</div>
            <div class=col-md-4 style="text-align: center">data</div>
        </div>

        <br>
        <c:forEach var="payment" items="${payments}" >
            <div class="row">
                <div class=col-md-2 style="text-align: center">${payment.getId()}</div>
                <div class=col-md-3 style="text-align: center">${payment.creditCardPayment.getId()}</div>
                <div class=col-md-3 style="text-align: center">${payment.getSum()}</div>
                <div class=col-md-4 style="text-align: center">${payment.getData()}</div>
            </div>
            <br>
        </c:forEach>
        </b>
        <div style="margin-top: 400px; margin-left: 20px">
            <t:paginator step="8" count="6" urlprefix="?&startNumber="></t:paginator>
        </div>

    </div>

</div>