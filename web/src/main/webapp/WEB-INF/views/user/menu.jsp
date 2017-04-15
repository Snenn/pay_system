<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<div STYLE="border-radius: 4px; background-color:#fffb7b; width: 200px; height: 30px">
<div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Меню</div>
<div style="margin-top: 30px; margin-left: 20px; font-size: 120%">
    <div style="border-bottom: solid #314f80; width: 170px"> <a href="/user">СЧЕТА</a></div>
        <a class="menu-downLevel" href="/user/createAccount">создать счет</a><br>
        <a class="menu-downLevel" href="/user/replenishAccount">пополнить счет</a><br>
        <a class="menu-downLevel" href="/user/deleteAccount">удалить счет</a><br><br>
    <div style="border-bottom: solid #314f80; width: 170px"><a href="/user/cards" >КРЕДИТНЫЕ КАРТЫ</a></div>
        <a class="menu-downLevel" href="/user/createCard">создать карту</a><br>
        <a class="menu-downLevel" href="/user/deleteCard">удалить карту</a><br><br>
    <div style="border-bottom: solid #314f80; width: 170px"><a href="/user/payments" >ПЛАТЕЖИ</a></div>
        <a class="menu-downLevel" href="/user/createPayment">совершить платеж</a><br><br>
    <div style="border-bottom: solid #314f80; width: 170px"><a href="/user/transfers" >ПЕРЕВОДЫ</a></div>
        <a class="menu-downLevel" href="/user/createTransfer">совершить перевод</a><br><br>

</div>
</div>