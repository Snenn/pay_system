<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/assests/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

user
<%--<div class="navbar navbar-default" role="navigation">--%>
   <%--<div class="row">--%>
    <%--<b>--%>
        <%--<br>--%>
        <%--<div class=col-md-1 style="text-align: center">ID</div>--%>
        <%--<div class=col-md-2 style="text-align: center">Surname</div>--%>
        <%--<div class=col-md-2 style="text-align: center">Name</div>--%>
        <%--<div class=col-md-2 style="text-align: center">Login</div>--%>
        <%--<div class=col-md-2 style="text-align: center">ID Account</div>--%>
        <%--<div class=col-md-2 style="text-align: center">Balance</div>--%>


    <%--</b>--%>
   <%--</div>--%>
   <%--<br><br>--%>

    <%--<form action="do?command=MAINUSER" method="POST">--%>

<%--<div class="row">--%>
    <%--<b>--%>

            <%--<div class=col-md-1 style="text-align: center">${user.id}</div>--%>
            <%--<div class=col-md-2 style="text-align: center">${user.surname}</div>--%>
            <%--<div class=col-md-2 style="text-align: center">${user.name}</div>--%>
            <%--<div class=col-md-2 style="text-align: center">${user.login}</div>--%>
            <%--<div class=col-md-2 style="text-align: center"><c:if test="${account.id!=null}">${account.id}</c:if></div>--%>
            <%--<div class=col-md-2 style="text-align: center"><c:if test="${account.id!=null}">${account.balance}</c:if></div>--%>

            <%--<div class=col-md-1 style="text-align: center"><input type="submit" name="resetAccount" value="reset" /></div>--%>


    <%--</b>--%>
<%--</div>--%>
    <%--</form>--%>
<%--<br>--%>

    <%--<div style="text-align: center;"><span style="font-size: x-large; font-weight: 300 "  align="center"><span--%>
            <%--style="color: black; "> Credit cards list</span></span></div>--%>
    <%--<br>--%>

    <%--<div class="row">--%>
        <%--<b>--%>
            <%--<div class=col-md-3 style="text-align: center">ID CreditCard</div>--%>
            <%--<div class=col-md-3 style="text-align: center">BALANCE</div>--%>
            <%--<div class=col-md-3 style="text-align: center">ID ACCOUNT</div>--%>
            <%--<div class=col-md-3 style="text-align: center">STATUS CreditCard</div>--%>
        <%--</b>--%>
    <%--</div>--%>
    <%--<br>--%>


<%--<c:forEach items="${creditCards}" var="creditCard">--%>
    <%--<div class="row">--%>
        <%--<c:if test="${creditCards!=null}">--%>
        <%--<form class="form-creditCard-${creditCard.id}" action="do?command=MAINUSER" method=POST>--%>
            <%--<div class=col-md-3 style="text-align: center">${creditCard.id}</div>--%>
            <%--<div class=col-md-3 style="text-align: center">${account.balance}</div>--%>
            <%--<div class=col-md-3 style="text-align: center">${creditCard.account.id}</div>--%>
            <%--<div class=col-md-3 style="text-align: center">--%>
                <%--<jsp:useBean id="creditCardStatuses" scope="request" type="java.util.List"/>--%>
                <%--<c:forEach items="${creditCardStatuses}" var="creditCardStatus">--%>
                    <%--<c:if test="${creditCardStatus.id==creditCard.creditCardStatus}">--%>
                        <%--${creditCardStatus.status}--%>
                    <%--</c:if>--%>
                <%--</c:forEach>--%>

            <%--</div>--%>


        <%--</form>--%>
        <%--</c:if>--%>
    <%--</div>--%>
    <%--<br>--%>
<%--</c:forEach>--%>
<%--<br>--%>


<%--</div>--%>

<%--<br><br>--%>
<%--<div style="text-align: center;"><form action="do?command=MAINUSER" method="POST">--%>
    <%--<div class=col-md-4 style="text-align: center">Enter id card<div><label for="idCardBlock"></label><input id="idCardBlock" name="idCardBlock" type="text" required=""></div><br><input type="submit" name="cardBlock" value="block the card" /></div>--%>
<%--</form></div>--%>
<%--<div style="text-align: center;"><form action="do?command=MAINUSER" method="POST">--%>
    <%--<div class=col-md-4 style="text-align: center">Enter id card sender <div><label for="idCardSenderTransfer"></label><input id="idCardSenderTransfer" name="idCardSenderTransfer" type="text" required=""></div>Enter id card recipient <div><label for="idCardRecipientTransfer"></label><input id="idCardRecipientTransfer" name="idCardRecipientTransfer" type="text" required=""></div>--%>
        <%--Enter sum <div><label for="sumTransfer"></label><input id="sumTransfer" name="sumTransfer" type="text" required=""></div><br><input type="submit" name="transfer" value="transfer money" /></div>--%>
<%--</form></div>--%>
<%--<div style="text-align: center;"><form action="do?command=MAINUSER" method="POST">--%>
    <%--<div class=col-md-4 style="text-align: center">Enter id card sender <div><label for="idCardSenderPay"></label><input id="idCardSenderPay" name="idCardSenderPay" type="text" required=""></div>Enter sum <div><label for="sumPay"></label><input id="sumPay" name="sumPay" type="text" required=""></div> <br><input type="submit" name="pay" value="pay order" /></div>--%>


<%--</form></div>--%>
<%--<br><br>--%>
<%@ include file="/assests/include/end-html.jsp" %>
