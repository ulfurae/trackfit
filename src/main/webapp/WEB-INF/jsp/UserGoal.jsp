<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>TrackFit - Goal Log</title>
        <%--Bootstrap CSS--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <%--Local CSS--%>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/trackFitMain.css"/>"/>
    </head>
    <body >

        <main class="container-fluid" style="height:100%">
            <div class="main-container">
                <a href="/"><span class="logo glyphicon glyphicon-link" ></span></a>

                <h2 class="title">Goal ${goal[0]}</h2>


                <div class="goal-box">
                    <p><label>Exercise:</label>
                        <span>${goal[1]}</span></p>
                    <p><label>Start:</label>
                        <span>${goal[4]}</span></p>
                    <p><label>End</label>
                        <span>${goal[5]}</span></p>

                    <p><label>Reps:</label>
                        <span>${goal[2]}</span></p>
                    <p><label>Kilograms: </label>
                        <span>${goal[3]}</span></p>
                    <p><label>Status:</label>
                        <span>${goal[8]}</span></p>
                </div>



            </div>
        </main>


    </body>
</html>
