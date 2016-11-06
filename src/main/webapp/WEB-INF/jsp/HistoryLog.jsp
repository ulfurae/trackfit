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
                
                <c:choose>
                    <%--If the model has an attribute with the name `exercises`--%>
                    <c:when test="${not empty exercises}">
                        <%--Create a table--%>
                        <table class="table">
                        	<thead>
                        		<th>
                        			<td><b>Date</b></td>
                        			<td><b>Exercise</b></td>
                        			<td><b>Reps</b</td>
                        			<td><b>Kilograms</b></td>
                        		</th>
                        	</thead>
							<tbody>
                            <c:forEach var="exercise" items="${exercises}">
                                <tr>
                                	<td></td>
                                    <td>${exercise.date}</td>
                                    <td>${exercise.exerciseID}</td>
                                    <td>${exercise.unit2}</td>
                                    <td>${exercise.unit1}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
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
