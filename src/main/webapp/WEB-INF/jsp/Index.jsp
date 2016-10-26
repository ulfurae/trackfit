<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en" >

    <head>
        <title>TrackFit</title>
        <%--Bootstrap CSS--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <%--Local CSS--%>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/trackFitMain.css"/>"/>
    </head>
    <body >
        <main class="container-fluid" style="height:100%">
            <div class="main-container">
                <a href="/"><span class="logo glyphicon glyphicon-link" ></span></a>
                <h1>TrackFit</h1>
                <p>The web app that helps you stay fit.</p>

                <ul style="width:500px; margin:0 auto;">
                    <a class="btn btn-block btn-lg btn-danger btn-main" href="/addExercise" role="button">Add exercise</a>
                </ul>

            </div>
        </main>
    </body>

</html>
