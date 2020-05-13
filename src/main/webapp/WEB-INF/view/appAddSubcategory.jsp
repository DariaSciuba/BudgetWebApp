<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <h1>Add new Subcategory!</h1>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="newSubcategoryDto" action="/app/subcategory/add">

            <label for="name">Subcategory name</label>
            <form:input id="name" type="text" path="subcategoryName" placeholder="Subcategory..."/>

            <label for="category">Category type</label>
            <form:select id="category" path="categoryDTO.id" itemValue="id" itemLabel="categoryName" items="${categories}"/>

            <input type="submit" value="Add"/>

        </form:form>
    </div>

