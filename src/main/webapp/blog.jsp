<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath}/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/clean-blog.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">

        <c:choose>

            <c:when test="${sessionScope.username != null}">

                <div class="text-white">Witaj ${sessionScope.username}</div>

                <form action="${pageContext.request.contextPath}/login" method="post">
                    <input type="hidden" name="action" value="logout">
                    <input class="btn btn-info button-with-margin" type="submit" value="Log out">
                </form>

                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/new">New post</a>
                        </li>
                    </ul>
                </div>

            </c:when>

            <c:otherwise>

                <form class="form-inline" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="form-group mb-2">
                        <label for="name" class="sr-only">Username</label>
                        <input type="text" class="form-control ${param.hasError ? 'is-invalid' : ''} ${param.registered ? 'is-valid' : ''}" id="name" placeholder="email@example.com"  name="username">
                    </div>

                    <div class="form-group mx-sm-3 mb-2">
                        <label for="password" class="sr-only">Password</label>
                        <input type="password" class="form-control ${param.hasError ? 'is-invalid' : ''} ${param.registered ? 'is-valid' : ''}" id="password" placeholder="Password" name="password">
                    </div>

                    <button type="submit" class="btn btn-primary mb-2" name="action" value="login">Log in</button>
                    <button type="submit" class="btn btn-primary mb-2 button-with-margin" name="action" value="register">Register</button>
                </form>

            </c:otherwise>

        </c:choose>
    </div>
</nav>

<!-- Page Header -->
<header class="masthead" style="background-image: url('${pageContext.request.contextPath}/static/img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Clean Blog</h1>
                    <span class="subheading">A Blog Theme by Start Bootstrap</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <c:forEach items="${requestScope.posts}" var="post" varStatus="status">
                <div class="post-preview">
                    <a href="${pageContext.request.contextPath}/post?id=${post.id}">
                        <h2 class="post-title">
                            ${post.title}
                        </h2>
                    </a>
                    <p class="post-meta">Posted by
                        <a href="#">${post.authorName}</a>
                    </p>
                </div>

                <c:if test="${!status.last}">
                    <hr>
                </c:if>
            </c:forEach>

            <!-- Pager -->
            <div class="clearfix">
                <a class="btn btn-primary float-right" href="#">Older Posts &rarr;</a>
            </div>
        </div>
    </div>
</div>

<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Copyright &copy; Your Website 2019</p>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="${pageContext.request.contextPath}/static/js/clean-blog.min.js"></script>

</body>

</html>