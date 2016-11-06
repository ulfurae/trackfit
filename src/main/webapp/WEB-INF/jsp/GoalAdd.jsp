<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>TrackFit - Add Goal</title>
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

                <h1 class="title">Add new goal</h1>
                <form>
                    <div class="form-goal col-md-4">
                        <div class="form-group">
                            <label>Distance:</label>
                            <input type="text"/><br>

                            <label>Time:</label>
                            <input type="text"/><br>
                       		
                       		<label>Ending:</label><br>
                        </div>
                        <div class="form-group">
                            <input type="submit" VALUE="Save Goal" class="btn btn-success btn-block"/>
                        </div>
                    </div>
                </form>
            </div>
        </main>


    </body>
</html>
