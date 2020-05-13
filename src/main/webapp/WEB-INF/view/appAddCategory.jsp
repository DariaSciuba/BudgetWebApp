<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <h1>Add new Category!</h1>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="newCategoryDto" action="/app/category/add">

            <label for="name">Category name</label>
            <form:input id="name" type="text" path="categoryName" placeholder="Category..."/>

            <label for="type">Category type</label>
            <form:select id="type" path="categoryType">
                <form:option value="expense">expense</form:option>
                <form:option value="income">income</form:option>
            </form:select>

            <input type="submit" value="Add"/>

        </form:form>
    </div>




