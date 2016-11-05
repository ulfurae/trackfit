<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>TrackFit - Profile</title>
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

                <h1 class="title">Profile</h1>
                
        		<table class="userProfile">
        			<tbody>
        				<tr>
        					<td id="userAttr"><b>Name:</b></td>
        					<td>${user.fullName}</td>
        				</tr>
        				<tr>
        					<td id="userAttr"><b>Birthday:</b></td>
        					<td>${user.birthday}</td>
        				</tr>
        				<tr>
        					<td id="userAttr"><b>Height:</b></td>
        					<td>${user.height}</td>
        				</tr>
        				<tr>
        					<td id="userAttr"><b>Weight:</b></td>
        					<td>${user.weight}</td>
        				</tr>
        				<tr>
        					<td id="userAttr"><b>BMI:</b></td>
        					<td>${bmi}</td>
        				</tr>
        			</tbody>
        		</table>
        		
            </div>
        </main>


    </body>
</html>
