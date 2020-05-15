<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/main.css">
    <title>Expenses</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <%@ include file="header.jsp" %>

    <aside>
        <%@ include file="appAddExpense.jsp"%>
    </aside>

    <main>

        <h3>Expenses List</h3>

        <div class="backgroundContainer">
            <table>
                <tr>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Category</th>
                    <th>Note</th>

                </tr>
                <c:forEach var = "expense" items = "${expenses}">
                    <tr>
                        <td><c:out value = "${expense.date}"/></td>
                        <td style="text-align:right"><c:out value = "${expense.amount}"/></td>
                        <td><c:out value = "${expense.subcategory.name}"/></td>
                        <td><c:out value = "${expense.note}"/></td>
                    </tr>
                </c:forEach>

            </table>

        </div>

    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>