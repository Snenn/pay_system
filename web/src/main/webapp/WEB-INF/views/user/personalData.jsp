<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div STYLE="border-radius: 4px; background-color:#fffb7b; width: 900px; height: 30px">
    <div style="font: 'Times New Roman'; font-size: 120%; margin-left: 20px;">Персональные данные</div>
    <div>
        <div style="float: left; width: 50%; margin-top: 20px; margin-left: 20px ">
            Surname: ${user.surname}<br><br>
            Name: ${user.name}<br><br>
            Login: ${user.login}<br><br>
        </div>
        <div style="float: left; width: -10%; margin-top: 20px; margin-left: 10px ">
            Total accounts: ${countAccounts}<br><br>
            Total credit cards: ${countCards}<br><br>
            Total balance: ${sumBalance} byn<br><br>
        </div>

    </div>
</div>
