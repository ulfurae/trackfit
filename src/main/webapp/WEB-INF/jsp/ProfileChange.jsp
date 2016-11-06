<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>TrackFit - Profile Change</title>
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

                <h1 class="title">Change Profile</h1>
        		
        		<sf:form method="POST" commandName="newUser" action="/viewProfile">

                    <div class="form-exercise col-md-4">
                        <div class="form-group">
                            <label>Weight:</label>
                            <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                            <sf:input path="weight" type="text" placeholder="Enter weight" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" VALUE="Change Weight" class="btn btn-success btn-block"/>
                        </div>
                    </div>
                </sf:form>
            </div>
        </main>


    </body>
</html>
