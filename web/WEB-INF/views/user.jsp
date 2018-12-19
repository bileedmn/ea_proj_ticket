<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Members</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Control Panel</h1>
            <p>Dear ${user.userCredentials.username}, Welcome to your Personal Space</p>
        </div>
        <a href="<spring:url value="/user/reset" />" class="btn btn-danger btn-mini pull-right">Reset Pass</a>
        <br>
    </div>
</section>

<section class="container">
    <div class="row">
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
            <div class="thumbnail">
                <div class="caption">
                    <h3>First Name - ${user.firstName}</h3>
                    <h3>Last Name - ${user.lastName}</h3>
                    <p>Age - ${user.age}</p>
                    <p>Title - ${user.title} </p>
                    <p>NUMBER - ${user.memberNumber} </p>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
