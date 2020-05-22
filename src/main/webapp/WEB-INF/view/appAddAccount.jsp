<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Add new Account!</h3>

<div class="backgroundContainer">
    <form:form method="POST" modelAttribute="newAccountDto" action="/app/account/add">

        <label for="name">Bank name</label>
        <form:input id="name" type="text" path="bankName" placeholder="Bank name..." class="form-control" required="true"/>

        <label for="number">Account number</label>
        <form:input id="number" type="text" path="accountNumber" placeholder="Account number..." minlength="8" maxlength="28" class="form-control" required="true"/>

        <label for="type">Account type</label>
        <form:select id="type" path="accountType" class="form-control" required="true">
            <form:option value="">Choose type</form:option>
            <form:option value="debit">debit</form:option>
            <form:option value="credit">credit</form:option>
            <form:option value="savings">savings</form:option>
        </form:select>

        <label for="currency">Currency</label>
        <form:input id="currency" type="text" path="currency" placeholder="PLN/EUR/USD" minlength="1" maxlength="3" class="form-control" required="true"/>

        <label for="balance">Currency</label>
        <form:input id="balance" type="number" path="balanceDTO" placeholder="1500.00" step="0.01" class="form-control" required="true"/>

        <input type="submit" value="Add"/>

    </form:form>
</div>




