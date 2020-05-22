<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <link rel="stylesheet" href="/fontello/css/fontello.css">

    <title>Accounts customizing</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>

<%@ include file="header.jsp" %>

<aside>
    <div class="editing">
        <%@ include file="appAddAccount.jsp" %>
    </div>
</aside>

<main>
    <h3>Accounts</h3>
    <div class="backgroundContainer">

        <c:forEach var="account" items="${accounts}">
                <ul>
                    <li><c:out value="${account.bankName}"/> | <c:out value="${account.type}"/> account
<%--                        <a href="#" onclick="">--%>
<%--                            <i class="icon-delete red"></i></a>--%>
<%--                        <a href="/app/account/edit/${account.id}">--%>
<%--                            <i class="icon-update green"></i></a>--%>
                    </li>
                    <ol>Account number: <c:out value="${account.number}"/></ol>
                    <ol>Account balance: <c:out value="${account.balance}"/> <c:out value="${account.currency}"/> </ol>
                </ul>
        </c:forEach>

    </div>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>