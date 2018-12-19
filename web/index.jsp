<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="container">
        <a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a>
    </div>
    <div class="pull-left"><h3>${SpecialBlurb}</h3></div>
</section>

</body>
</html>
