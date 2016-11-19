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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/trackFitMain.css"/>"/>
    </head>
    <body >

        <main class="container-fluid" style="height:100%">
            <div class="main-container">
                <a href="/"><span class="logo glyphicon glyphicon-link" ></span></a>

                <h1 class="title">Goal Log</h1>
                
                <c:choose>
                    <%--If the model has an attribute with the name `goals`--%>
                    <c:when test="${not empty goals}">
                        <%--Create a table--%>
                        <table class="table">
                        	<thead>
                        		<th>
                        			<td><b>StartDate</b></td>
                        			<td><b>EndDate</b></td>
                        			<td><b>Exercise</b></td>
                        			<td><b>Reps</b</td>
                        			<td><b>Kilograms</b></td>
                        			<td><b>Status</b></td>
                        		</th>
                        	</thead>
							<tbody>
                            <c:forEach var="goal" items="${goals}">
                                <tr>
                                	<td></td>
                                    <td>${goal.startDate}</td>
                                    <td>${goal.endDate}</td>
                                    <td>${goal.exerciseID}</td>
                                    <td>${goal.unit2}</td>
                                    <td>${goal.unit1}</td>
                                    <td>${goal.status}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:when>

                    <%--If all tests are false, then do this--%>
                    <c:otherwise>
                        <h3>You have not made any goals. Where is the ambition man? </h3>
                    </c:otherwise>
                </c:choose>

            </div>
        </main>


    </body>
</html>
