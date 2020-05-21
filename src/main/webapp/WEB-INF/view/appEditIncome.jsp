<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <title>Edit expense</title>
</head>

<body>

<%@ include file="header.jsp" %>

<aside>
    <h3>Edit expense!</h3>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="incomeDTO" action="/app/income/edit/${incomeDTO.id}">

            <label for="amount">Expense</label>
            <form:input id="amount" type="number" path="amount" placeholder="${incomeDTO.amount}" class="form-control" required="true" step="0.01"/>

            <label for="date">Date</label>
            <form:input id="date" type="date" path="dateDTO" class="form-control" required="true"/>

            <label for="subcategory">Subcategory type</label>
            <form:select id="subcategory" path="subcategoryDTO.id" placeholder="${incomeDTO.subcategoryDTO.subcategoryName}" class="form-control" required="true">
                <form:options  itemValue="id" itemLabel="subcategoryName" items="${subcategories}"/>--%>
            </form:select>

            <label for="note">Note</label>
            <form:input id="note" type="text" path="note" placeholder="${incomeDTO.note}"/>

            <input type="submit" value="Edit"/>
        </form:form>
    </div>
</aside>

<%@ include file="footer.jsp" %>

</body>
</html>