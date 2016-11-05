<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>TrackFit - Add Exercise</title>
        <%--Bootstrap CSS--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <%--Local CSS--%>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/trackFitMain.css"/>"/>
    </head>
    <body >

        <main class="container-fluid" style="height:100%">
            <div class="main-container">
                <a href="/"><span class="logo glyphicon glyphicon-link" ></span></a>

                <h1 class="title">Add new exercise</h1>

                <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
                <%--that is added to the model that is passed to the view.--%>
                <%--See exerciseController, method addExerciseViewGet(), and find where this attribute is added to the model.--%>
                <sf:form method="POST" commandName="exerciseForm" action="/addExercise">

                    <div class="form-exercise col-md-4">
                        <div class="form-group">
                            <label> Name:</label>
                            <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                            <sf:input path="name" type="text" placeholder="Enter name" class="form-control"/>

                            <label>Notes:</label>
                            <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                            <sf:textarea path="note" type="text" placeholder="Note text here" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" VALUE="Save exercise" class="btn btn-success btn-block"/>
                        </div>
                    </div>
                </sf:form>
                
                <div class="form-exercise col-md-4">
                <div class="form-group">
                    <form method="get" action="/viewPerformance">
                        <input type="submit" VALUE="Performance History" class="btn btn-success btn-block"/>
                    </form>
                </div>
				</div>
				
            </div>
        </main>


    </body>
</html>
