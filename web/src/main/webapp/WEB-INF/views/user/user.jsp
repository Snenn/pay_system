<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/resourses/include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 900px; height: 150px; margin-left: 200px; float: left">
    <div STYLE="border-radius: 4px; background-color:#fffb7b; width: 900px; height: 30px">
        <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Персональные данные</div>
        <div>
            <%@ include file="personalData.jsp" %>
        </div>
    </div>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 230px; height: 150px; margin-left: 1110px">
    <div STYLE="border-radius: 4px; background-color:#fffb7b; width: 230px; height: 30px">
        <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Курсы валют</div>
        <iframe style="margin-top: 20px; margin-left: 20px" src="http://www.nbrb.by/publications/wmastersd.asp?
lan=en&datatype=0&fnt=Times&fntsize=16&fntcolor=005c7b
&lnkcolor=fc7f7f&bgcolor=f1f1f8&brdcolor=fdf2e0"
                width=190 height=95 frameborder=0 scrolling=no>
        </iframe>
    </div>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 200px; height: 500px; margin-left: 200px; float: left; margin-top: 10px">
    <div STYLE="border-radius: 4px; background-color:#fffb7b; width: 200px; height: 30px">
        <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Меню</div>
        <%@ include file="menu.jsp" %>
    </div>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 690px; height: 500px; margin-left: 10px; float: left; margin-top: 10px">
    <div STYLE="border-radius: 4px; background-color:#fffb7b; width: 690px; height: 30px">
        <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">выбор</div>

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
                    <t:paginator step="8" count="6" urlprefix="?&startNumber="></t:paginator>


            </div>

    </div>
</div>
<div STYLE="border-radius: 4px; background-color: #f1f1f8; width: 230px; height: 500px; margin-left: 10px; float: left; margin-top: 10px">
    <div STYLE="border-radius: 4px; background-color:#fffb7b; width: 230px; height: 30px">
        <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px; ">Новости</div>
        <div style="margin-top: 10px">
            <!-- start feedwind code --> <script type="text/javascript" src="https://feed.mikle.com/js/fw-loader.js" data-fw-param="22680/"></script> <!-- end feedwind code -->

<%@ include file="/resourses/include/end-html.jsp" %>
