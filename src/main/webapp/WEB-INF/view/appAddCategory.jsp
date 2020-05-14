<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <h3>Add new Category!</h3>

    <div class="backgroundContainer">
            <form:form method="POST" modelAttribute="newCategoryDto" action="/app/category/add">

                <label for="name">Category name</label>
                <form:input id="name" type="text" path="categoryName" placeholder="Category..." class="form-control" required="true"/>

                <label for="type">Category type</label>
                <form:select id="type" path="categoryType" class="form-control" required="true">
                    <form:option value="">Choose type</form:option>
                    <form:option value="expense">expense</form:option>
                    <form:option value="income">income</form:option>
                </form:select>

                <input type="submit" value="Add"/>

            </form:form>
    </div>




