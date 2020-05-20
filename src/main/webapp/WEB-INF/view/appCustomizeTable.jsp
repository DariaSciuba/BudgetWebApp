<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <link rel="stylesheet" href="/fontello/css/fontello.css">

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
                    <li><c:out value="${category.categoryName}"/> | <c:out value="${type}"/>
                        <a href="#" onclick="confirmDeleteCategory(${category.id},'${category.categoryName}',
                            '${category.subcategoriesDTO}')">
                            <i class="icon-delete red"></i></a>
                        <a href="/app/category/edit/${category.id}">
                            <i class="icon-update green"></i></a>
                    </li>
                    <c:forEach var="subcategory" items="${category.subcategoriesDTO}">
                        <ul>
                            <li><c:out value="${subcategory.subcategoryName}"/>
                                <a href="#" onclick="confirmDeleteSubcategory(${subcategory.id},'${subcategory.subcategoryName}', '${subcategory.expensesDTO}', '${subcategory.incomesDTO}')">
                                    <i class="icon-delete red"></i></a>
                                <a href="/app/subcategory/edit/${subcategory.id}">
                                    <i class="icon-update green"></i></a>
                            </li>
                        </ul>
                    </c:forEach>
                </ul>
            </c:forEach>
        </c:forEach>

    </div>


    <script>
        function confirmDeleteCategory(id, name, subcategory) {
            if(subcategory === "[]") {
                if (confirm("Are you sure you want to delete category \"" + name + "\"?")) {
                    window.location.href = "/app/category/delete/" + id;
                }
            } else {
                alert("Category \"" + name + "\" is not empty, please delete or assign subcategories first ");
            }
        }
    </script>

    <script>
        function confirmDeleteSubcategory(id, name, expenses, incomes) {
            if(expenses ==="[]" && incomes === "[]") {
                if (confirm("Are you sure you want to delete subcategory \"" + name + "\"?")) {
                    window.location.href = "/app/subcategory/delete/" + id;
                }
            } else {
                alert("Subcategory \"" + name + "\" is not empty, please delete or assign " + (expenses == "[]" ? "incomes" : "expenses") + " first");
            }
        }
    </script>


</main>

<%@ include file="footer.jsp" %>

</body>
</html>