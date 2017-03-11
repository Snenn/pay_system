<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/assests/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<span style="color: #0f0f0f">
    Surname: ${user.getSurname()}<br>
    Name:    ${user.getName()}<br>
    Login:   ${user.getLogin()}<br>
</span>

<div style="text-align: center;"><span style="font-size: x-large; font-weight: 300 "  align="center"><span
        style="color: #0f0f0f; "> Credit cards list</span></span></div>
<br>

<div class="navbar navbar-default" role="navigation">
    <div class="container-fluid">

   <div class="row">
    <b>
        <div class=col-md-3>ID CreditCard</div>
        <div class=col-md-3>ID ACCOUNT</div>
        <div class=col-md-3>STATUS CreditCard</div>
    </b>
   </div>
   <br>



   <jsp:useBean id="creditCards" scope="request" type="java.util.List"/>
   <c:forEach var="creditCard" items="${creditCards}" >
        <div class="row">
        <form class="form-creditCard-${creditCard.getId()}" action="do?command=MAINADMIN" method=POST>
            <div class=col-md-3>${creditCard.getId()}</div>
            <div class=col-md-3>${creditCard.getAccount().getId()}</div>
            <div class=col-md-3>
                        <jsp:useBean id="creditCardStatuses" scope="request" type="java.util.List"/>
                        <c:forEach items="${creditCardStatuses}" var="creditCardStatus">
                            <c:if test="${creditCardStatus.getId()==creditCard.getCreditCardStatus()}">
                                 ${creditCardStatus.getStatus()}
                            </c:if>
                        </c:forEach>

           </div>


        </form>
        </div>
   <br>
   </c:forEach>
        <br><br>
        <t:paginator step="6" count="${adCount}" urlprefix="?command=MAINADMIN&startNumber="/>
</div>
    <div style="text-align: center;"><form action="do?command=MAINADMIN" method="POST">
        Enter Credit Card ID <div><label for="idCard"></label><input id="idCard" name="idCard" type="text" required=""></div>
        <br>
        <jsp:useBean id="startIndex" scope="request" type="java.lang.Integer"/>
        <input type="hidden" id="startIndex" name="startIndex" value="${startIndex}"/>
        <input type="submit" name="block" value="Block Credit Card" />    <input type="submit" name="unlock" value="Unlock Credit Card" />
     </form></div>
</div>
<br>


<%@ include file="/assests/include/end-html.jsp" %>
</html>