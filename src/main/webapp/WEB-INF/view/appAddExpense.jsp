<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <h3>Add new expense!</h3>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="newExpenseDto" action="/app/expense/add">

            <label for="amount">Expense</label>
            <form:input id="amount" type="number" path="amount" class="form-control" required="true" step="0.01"/>

            <label for="date">Date</label>
            <form:input id="date" type="date" path="dateDTO" class="form-control" required="true"/>

            <label for="subcategory">Subcategory type</label>
            <form:select id="subcategory" path="subcategoryDTO.id" class="form-control" required="true">
                <form:option value="">Choose subcategory</form:option>
                <form:options  itemValue="id" itemLabel="subcategoryName" items="${subcategories}"/>
            </form:select>

            <label for="account">Note</label>
            <form:select id="account" type="text" path="accountDTO.id" class="form-control" required="true">
                <form:option value="">Choose account</form:option>
                <form:options itemValue="id" itemLabel="bankName" items="${accounts}"/>
            </form:select>

            <label for="note">Note</label>
            <form:input id="note" type="text" path="note"/>

            <input type="submit" value="Add"/>

        </form:form>
    </div>
