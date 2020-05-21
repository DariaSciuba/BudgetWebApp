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
    <h3>Edit subcategory!</h3>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="subcategoryDTO" action="/app/subcategory/edit/${subcategoryDTO.id}">

            <label for="name">Subcategory name</label>
            <form:input id="name" type="text" path="subcategoryName" placeholder="${subcategoryDTO.subcategoryName}" class="form-control" required="true"/>

            <label for="category">Category type</label>
            <form:select id="category" path="categoryDTO.id" placeholder="${subcategoryDTO.categoryDTO.categoryName}" class="form-control" required="true">
                <form:options itemValue="id" itemLabel="categoryName" items="${categories}"/>
            </form:select>
            <input type="submit" value="Edit"/>
        </form:form>
    </div>

</aside>

<%@ include file="footer.jsp" %>

</body>
</html>
