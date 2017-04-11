<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/resourses/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="navbar-default" role="navigation">
    <div class="row">
        <b>
            <br>
            <div class=col-md-1 style="text-align: center">ID</div>
            <div class=col-md-2 style="text-align: center">Login</div>
            <div class=col-md-2 style="text-align: center">ID Account</div>
            <div class=col-md-2 style="text-align: center">Balance</div>


        </b>
    </div>
    <br><br>

    <form action="/user" method="POST">

        <div class="row">
            <b>
                <div class=col-md-1 style="text-align: center">${user.id}</div>
                <div class=col-md-2 style="text-align: center">${user.login}</div>
                <div class=col-md-2 style="text-align: center"><c:if test="${account.id!=null}">${account.id}</c:if></div>
                <div class=col-md-2 style="text-align: center"><c:if test="${account.id!=null}">${account.balance}</c:if></div>

                <c:if test="${account.id!=null}">
                    <div class=col-md-1 style="text-align: center"><input type="submit" name="resetAccount" value="reset this account" /></div><b></b>
                    <label for="sumPutMoney"></label><input id="sumPutMoney" name="sumPutMoney" type="text" ><input type="submit" name="putMoney" value="put money" />
                </c:if>

                <div class=col-md-1 style="text-align: center"><c:if test="${account.id==null}">
                    <input type="submit" name="createAccount" value="create new account" />
                </c:if></div>

                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>


            </b>
        </div>
    </form>
    <br>

    <div style="text-align: center;"><span style="font-size: x-large; font-weight: 300 "  align="center"><span
            style="color: black; "> Credit cards list    </span></span></div>
    <br>

    <div class="row">
        <b>
            <div class=col-md-2 style="text-align: center">ID CreditCard</div>
            <div class=col-md-3 style="text-align: center">BALANCE</div>
            <div class=col-md-3 style="text-align: center">ID ACCOUNT</div>
            <div class=col-md-3 style="text-align: center">STATUS CreditCard</div>


        </b>
    </div>

    <br>


    <c:forEach items="${creditCards}" var="creditCard">
        <div class="row">
            <c:if test="${creditCards!=null}">
                <div class=col-md-2 style="text-align: center">${creditCard.id}</div>
                <div class=col-md-3 style="text-align: center">${account.balance}</div>
                <div class=col-md-3 style="text-align: center">${creditCard.account.id}</div>
                <div class=col-md-3 style="text-align: center">
                    <jsp:useBean id="creditCardStatuses" scope="request" type="java.util.List"/>
                    <c:forEach items="${creditCardStatuses}" var="creditCardStatus">
                        <c:if test="${creditCardStatus.id==creditCard.creditCardStatus}">
                            ${creditCardStatus.status}
                        </c:if>
                    </c:forEach>

                </div>


            </c:if>
        </div>
        <br>
    </c:forEach>
    <form action="/user" method=POST>
        <div class="row">
            <div class=col-md-1 style="text-align: center"></div>
            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
            <input type="submit" name="createCreditCard" value="create new Credit Card" />
        </div>
    </form>
    <br>

</div>

<br><br>
<div style="text-align: center;"><form action="/user" method="POST">
    <div class=col-md-4 style="text-align: center">Enter id card<div><label for="idCardBlock"></label><input id="idCardBlock" name="idCardBlock" type="text" required=""></div><br><input type="submit" name="cardBlock" value="block the card" /></div>
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
</form></div>
<div style="text-align: center;"><form action="/user" method="POST">
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>
    <div class=col-md-4 style="text-align: center">Enter id card sender <div><label for="idCardSenderTransfer"></label><input id="idCardSenderTransfer" name="idCardSenderTransfer" type="text" required=""></div>Enter id card recipient <div><label for="idCardRecipientTransfer"></label><input id="idCardRecipientTransfer" name="idCardRecipientTransfer" type="text" required=""></div>
        Enter sum <div><label for="sumTransfer"></label><input id="sumTransfer" name="sumTransfer" type="text" required=""></div><br><input type="submit" name="transfer" value="transfer money" /></div>
</form></div>
<div style="text-align: center;"><form action="/user" method="POST">
    <div class=col-md-4 style="text-align: center">Enter id card sender <div><label for="idCardSenderPay"></label><input id="idCardSenderPay" name="idCardSenderPay" type="text" required=""></div>Enter sum <div><label for="sumPay"></label><input id="sumPay" name="sumPay" type="text" required=""></div> <br><input type="submit" name="pay" value="pay order" /></div>
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"><jsp:text/></input>

</form></div>
<br><br>
<%@ include file="/resourses/include/end-html.jsp" %>
