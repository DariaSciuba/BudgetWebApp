<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <title>Edit table</title>
</head>
<body>
<%@ include file="header.jsp" %>
<aside>
    <h3>Edit Category!</h3>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="categoryDTO" action="/app/category/edit/${categoryDTO.id}">

            <label for="name">Category name</label>
            <form:input id="name" type="text" path="categoryName" placeholder="${categoryDTO.categoryName}" class="form-control" required="true"/>

            <label for="type">Category type</label>
            <form:select id="type" path="categoryType" placeholder="${categoryDTO.categoryType}" class="form-control" required="true">
                <form:option value="expense">expense</form:option>
                <form:option value="income">income</form:option>
            </form:select>

            <input type="submit" value="Edit"/>

        </form:form>
    </div>

</aside>

<%@ include file="footer.jsp" %>

</body>
</html>
