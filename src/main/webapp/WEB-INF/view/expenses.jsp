<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<head>
    <title>Expenses</title>
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

        <h1>Expenses List</h1>

        <div class="backgroundContainer">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Date</th>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Note</th>

                </tr>

                <c:forEach var = "expense" items = "${expenses}">
                    <tr>
                        <td><c:out value = "${expense.id}"/></td>
                        <td><c:out value = "${expense.date}"/></td>
                        <td><c:out value = "${expense.subcategory.name}"/></td>
                        <td><c:out value = "${expense.amount}"/></td>
                        <td><c:out value = "${expense.note}"/></td>
                    </tr>
                </c:forEach>

            </table>

            <a href="/app/expense/add"><button class="link-button">Add new expense!</button></a>

        </div>

    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>