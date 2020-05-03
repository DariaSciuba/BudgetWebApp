<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp" %>

<head>
    <title>Categories</title>
</head>

<body>

<aside>
    <h2>Lorem Ipsum...</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac libero fermentum, efficitur massa eu,
        placerat nibh. Curabitur elementum nec urna id consectetur. Vestibulum gravida velit lectus, sit amet
        pulvinar ex semper nec. Nulla placerat mi sed magna sodales hendrerit. Donec mauris eros, pellentesque
        ac tincidunt commodo, euismod nec enim. Duis hendrerit nisl quis sapien hendrerit, eget dapibus ante ornare.
        Phasellus bibendum, massa sed fringilla hendrerit, nunc sapien bibendum ex, sed sodales tortor nunc ut orci.
        Aliquam tempus molestie dui, non consectetur est gravida eu. Phasellus vulputate est ac efficitur posuere.
        Duis auctor in ante et eleifend. Nulla a magna elit. Nulla posuere pulvinar ultricies. Mauris interdum
        dapibus ultricies. Vestibulum commodo fermentum odio, sit amet faucibus ex dictum a.</p>
</aside>

<main>

    <h1>Add new Subcategory!</h1>

    <div class="backgroundContainer">
        <form:form method="POST" modelAttribute="newSubcategoryDto">

            <label for="name">Subcategory name</label>
            <form:input id="name" type="text" path="name" placeholder="Subcategory..."/>

            <label for="category">Category type</label>
            <form:select id="category" path="category.id" itemValue="id" itemLabel="name" items="${categories}"/>

            <input type="submit" value="Add"/>

        </form:form>
    </div>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>