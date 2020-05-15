<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <title>Customize</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>

<%@ include file="header.jsp" %>

<aside>
    <div class="editing">
        <%@ include file="appAddCategory.jsp" %>
    </div>
    <div class="editing">
        <%@ include file="appAddSubcategory.jsp" %>
    </div>
</aside>

<main>
    <h3>Categories Schema</h3>
    <div class="backgroundContainer">

        <c:forEach var="category" items="${categories}">
                <c:forEach var="type" items="${category.categoryType}">
                <ul>
                    <li><c:out value="${category.categoryName}"/> | <c:out value="${type}"/></li>
                    <c:forEach var="subcategory" items="${category.subcategoriesDTO}">
                        <ul>
                            <li><c:out value="${subcategory.subcategoryName}"/></li>
                        </ul>
                    </c:forEach>
                    </c:forEach>
                </ul>
        </c:forEach>

    </div>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>