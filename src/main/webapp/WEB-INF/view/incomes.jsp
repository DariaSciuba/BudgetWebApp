<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<head>
    <title>Incomes</title>
</head>

<body>

<aside>
    <h2>Lorem Ipsum...</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac libero fermentum, efficitur massa eu,
        placerat nibh. Curabitur elementum nec urna id consectetur. Vestibulum gravida velit lectus, sit amet
        pulvinar ex semper nec. Nulla placerat mi sed magna sodales hendrerit. Donec mauris eros, pellentesque
        ac tincidunt commodo, euismod nec enim. Duis hendrerit nisl quis sapien hendrerit, eget dapibus ante ornare.
        Phasellus bibendum, massa sed fringilla hendrerit, nunc sapien bibendum ex, sed sodales tortor nunc ut orci.
        Aliquam tempus molestie dui, non consectetur est gravida eu. Phasellus vulputate est ac efficitur posuere.
        Duis auctor in ante et eleifend. Nulla a magna elit. Nulla posuere pulvinar ultricies. Mauris interdum
        dapibus ultricies. Vestibulum commodo fermentum odio, sit amet faucibus ex dictum a.</p>    </aside>

<main>

    <h1>Incomes List</h1>

    <div class="backgroundContainer">
        <table>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Category</th>
                <th>Amount</th>
                <th>Note</th>

            </tr>

            <c:forEach var = "income" items = "${incomes}">
                <tr>
                    <td><c:out value = "${income.id}"/></td>
                    <td><c:out value = "${income.date}"/></td>
                    <td><c:out value = "${income.subcategory.name}"/></td>
                    <td><c:out value = "${income.amount}"/></td>
                    <td><c:out value = "${income.note}"/></td>
                </tr>
            </c:forEach>

        </table>

        <a href="/app/income/add"><button class="link-button">Add new income!</button></a>

    </div>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>