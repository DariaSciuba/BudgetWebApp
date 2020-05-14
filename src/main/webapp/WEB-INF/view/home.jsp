<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/main.css">
    <title>Personal Budget</title>
</head>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<%@ include file="header.jsp" %>

<aside>
    <h2>Lorem Ipsum...</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis sem sit amet quam pretium aliquam. Cras ut
        ullamcorper justo. Vivamus diam ex, interdum non porta in, laoreet vel orci. Ut volutpat sodales nunc sed
        tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tortor urna, pharetra nec nisi in,
        faucibus feugiat arcu. Quisque pharetra pretium urna, vel congue lacus mollis id.

        Sed viverra auctor risus eu efficitur. Etiam a odio sapien. Integer luctus vitae felis vitae volutpat.
        Suspendisse dui augue, porttitor sodales risus nec, vestibulum maximus magna. Suspendisse placerat mauris
        molestie ex rutrum, in dignissim neque volutpat. Fusce erat ante, ullamcorper vitae euismod ac, sollicitudin
        ut lacus. Maecenas eget luctus justo. Nunc ut justo tristique, interdum ipsum a, molestie ex. Etiam congue
        imperdiet eros. Aenean lacinia justo ut odio commodo, in aliquam quam vulputate. Phasellus tristique risus
        est, at iaculis diam scelerisque eu. Mauris commodo ex non felis aliquet volutpat. Aliquam vitae erat vitae
        enim pretium placerat. Integer sit amet est a sapien egestas luctus. Ut ipsum massa, pellentesque at
        condimentum feugiat, gravida vel justo. Maecenas et lobortis magna, ac consequat metus.</p>
</aside>

<main>
    <h1>Hello!</h1>
    <h2>Welcome to your personal budget app!</h2>

    <h3>This is a place where you can manage your own budget! Check how easy it is.</h3>
        <p>
            In the begging you can customize your categories <a href="/app/subcategory/customize">here</a>.<br>
            Then you can add your <a href="/app/income/list">incomes</a> and <a href="/app/expense/list">expenses</a>!
        </p>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>




