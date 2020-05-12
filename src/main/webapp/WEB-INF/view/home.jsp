<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Your budget!</title>
</head>

<body>

<%@ include file="header.jsp" %>

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
        <h1>Hello!</h1>
        <h2>Welcome to your budget app!</h2>

        <p>This is a place where you can manage your own budget! Check what easy it is.</p>
        
        <ul>
            <li><a href="/app/category/list">Categories list</a></li>
            <li><a href="/app/subcategory/list">Subcategories list</a></li>
            <li><a href="/app/expense/list">Expenses list</a></li>
            <li><a href="/app/income/list">Incomes list</a></li>
        </ul>

    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>



