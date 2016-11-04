<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>TrackFit - History Log</title>
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

                <h1 class="title">History Log</h1>
                
                <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
                <%--that is added to the model that is passed to the view.--%>
                <%--See exerciseController, method addExerciseViewGet(), and find where this attribute is added to the model.--%>
                <sf:form method="POST" commandName="exerciseForm" action="/showHistoryLog">

                        <div class="form-group">
                            <input type="submit" VALUE="Show history log" class="btn btn-success btn-block"/>
                        </div>
                    </div>
                </sf:form>
                
                <%--Choose what code to generate based on tests that we implement--%>
                <c:choose>
                    <%--If the model has an attribute with the name `exercises`--%>
                    <c:when test="${not empty exercises}">
                        <%--Create a table for the exercise Notes--%>
                        <table class="notes">

                            <%--For each exercise note, that is in the list that was passed in the model--%>
                            <%--generate a row in the table--%>
                            <%--Here we set `exercise` as a singular item out of the list `exercises`--%>
                            <c:forEach var="exercise" items="${exercises}">
                                <tr>
                                    <%--We can reference attributes of the Entity by just entering the name we gave--%>
                                    <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                                    <%--Create a link based on the name attribute value--%>
                                    <td><a href="/exercises/${exercise.name}">${exercise.name}</a></td>
                                    <%--The String in the note attribute--%>
                                    <td>${exercise.note}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>

                    <%--If all tests are false, then do this--%>
                    <c:otherwise>
                        <h3>No notes!</h3>
                    </c:otherwise>
                </c:choose>

            </div>
        </main>


    </body>
</html>
