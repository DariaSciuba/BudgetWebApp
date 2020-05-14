<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/main.css">
    <title>Incomes</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <%@ include file="header.jsp" %>

    <aside>
        <%@ include file="appAddIncome.jsp"%>
    </aside>

    <main>

        <h1>Incomes List</h1>

        <div class="backgroundContainer">
            <table>
                <tr>
                    <th>Date</th>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Note</th>

                </tr>

                <c:forEach var = "income" items = "${incomes}">
                    <tr>
                        <td><c:out value = "${income.date}"/></td>
                        <td><c:out value = "${income.subcategory.name}"/></td>
                        <td><c:out value = "${income.amount}"/></td>
                        <td><c:out value = "${income.note}"/></td>
                    </tr>
                </c:forEach>

            </table>
        </div>

    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>