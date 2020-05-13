<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp" %>

<head>
    <title>Add income</title>
</head>

<body>

<main>

    <h1>Add new income!</h1>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="newIncomeDto">

            <label for="amount">Expense</label>
            <form:input id="amount" type="number" path="amount"/>

            <label for="date">Date</label>
            <form:input id="date" type="date" path="dateDTO"/>

            <label for="subcategory">Subcategory type</label>
            <form:select id="subcategory" path="subcategoryDTO.id" itemValue="id" itemLabel="subcategoryName" items="${subcategories}"/>

            <label for="note">Note</label>
            <form:input id="note" type="text" path="note"/>

            <input type="submit" value="Add"/>

        </form:form>
    </div>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>