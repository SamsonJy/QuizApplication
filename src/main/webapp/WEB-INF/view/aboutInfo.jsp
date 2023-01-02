
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Page</title>
        <jsp:include page="include/css.jsp"/>        
    </head>

    <body id="page-top">


        <jsp:include page="include/header.jsp"/>

        <div id="wrapper">

            <jsp:include page="include/menu.jsp"/>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">${user.name}</a>
                        </li>
                        <li class="breadcrumb-item active">About</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="jumbotron">
                        <h1>About project</h1></br>


                        <h1>Contact info</h1></br>
                        <p><i class="fas fa-envelope"></i> <a href="#" target="_blank">  </a></p>
                        <p><i class="fab fa-github"></i> <a href="https://github.com/zikord" target="_blank"></a> </p>
                        <p><i class="fab fa-linkedin"></i> <a href="#"></a></p>

                    </div>

                </div>
            </div>

        </div>
        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>
    </body>
</html>
