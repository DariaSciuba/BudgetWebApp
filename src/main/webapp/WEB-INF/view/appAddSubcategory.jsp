<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <h3>Add new Subcategory!</h3>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="newSubcategoryDto" action="/app/subcategory/add">

            <label for="name">Subcategory name</label>
            <form:input id="name" type="text" path="subcategoryName" placeholder="Subcategory..." class="form-control" required="true"/>

            <label for="category">Category type</label>
            <form:select id="category" path="categoryDTO.id" class="form-control" required="true">
                <form:option value="">Choose category</form:option>
                <form:options itemValue="id" itemLabel="categoryName" items="${categories}"/>
            </form:select>
            <input type="submit" value="Add"/>
        </form:form>
    </div>

