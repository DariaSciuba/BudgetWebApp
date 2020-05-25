<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/main.css">
    <link rel="stylesheet" href="/fontello/css/fontello.css">

    <title>Incomes</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <aside>
        <%@ include file="appAddIncome.jsp"%>
    </aside>

    <main>

        <h3>Incomes List</h3>

        <div class="backgroundContainer">
        <c:forEach var="date" items="${incomes}">
                <button class="accordion"><c:out value="${date.key}"/></button>
                <div class="panel">
                    <table>
                        <c:forEach var="income" items="${date.value}">
                        <tr>
                                <td><c:out value="${income.amount}"/></td>
                                <td><c:out value="${income.subcategory.name}"/></td>
                                <td><c:out value="${income.incomeSource.companyName}"/></td>
                                <td><c:out value="${income.note}"/></td>
                                <td>
                                    <a href="#" onclick="confirmDeleteIncome(${income.id},${income.amount},'${income.subcategory.name}')">
                                        <i class="icon-delete red"></i></a>
                                    <a href="/app/income/edit/${income.id}">
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
                acc[i].addEventListener("click", function() {
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
            function confirmDeleteIncome(id, amount, subcategory) {
                if (confirm("Are you sure you want to delete income \"" + amount + "\" from category \"" + subcategory + "\"?")) {
                    window.location.href = "/app/income/delete/" + id;
                }
            }
        </script>

    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>