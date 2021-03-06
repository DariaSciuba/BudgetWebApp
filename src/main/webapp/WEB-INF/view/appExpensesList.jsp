<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <link rel="stylesheet" href="/fontello/css/fontello.css">

    <title>Expenses</title>
</head>
<body>
<%@ include file="header.jsp" %>

<aside>
     <%@ include file="appAddExpense.jsp" %>
</aside>

<main>

    <h3>Expenses List</h3>

    <div class="backgroundContainer">

        <c:forEach var="date" items="${expenses}">
            <button class="accordion"><c:out value="${date.key}"/></button>
            <div class="panel">
                <table>
                    <c:forEach var="expense" items="${date.value}">
                    <tr>
                        <td><c:out value="${expense.amount}"/></td>
                        <td><c:out value="${expense.subcategory.name}"/></td>
                        <td><c:out value="${expense.note}"/></td>
                        <td>
                            <a href="#" onclick="confirmDeleteExpense(${expense.id},${expense.amount},'${expense.subcategory.name}')">
                                <i class="icon-delete red"></i></a>
                            <a href="/app/expense/edit/${expense.id}">
                                <i class="icon-update green"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </c:forEach>
    </div>

    <script>
        var acc = document.getElementsByClassName("accordion");
        var i;

        for (i = 0; i < acc.length; i++) {
            acc[i].addEventListener("click", function () {
                this.classList.toggle("active");
                var panel = this.nextElementSibling;
                if (panel.style.display === "block") {
                    panel.style.display = "none";
                } else {
                    panel.style.display = "block";
                }
            });
        }
    </script>

    <script>
        function confirmDeleteExpense(id, amount, subcategory) {
            if (confirm("Are you sure you want to delete expense \"" + amount + "\" from category \"" + subcategory + "\"?")) {
                window.location.href = "/app/expense/delete/" + id;
            }
        }
    </script>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>