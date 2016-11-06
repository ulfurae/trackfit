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
                
                <sf:form method="POST" commandName="exerciseForm" action="/addExercise">

                    <div class="form-exercise col-md-4">
                        <div class="form-group">

                           <label>Choose exercise:</label>
                           <sf:select path="exerciseID"  placeholder="Chose exercise" class="form-control">
                                <sf:option value="1" >Power Clean</sf:option>
                                <sf:option value="2" >Back squat</sf:option>
                            </sf:select>

                           <label>Units:</label>
                           <div>
                             <sf:input path="unit1" type="text" placeholder="kilo" class="form-control" style="width:33%;  float: left;  margin-right: 5px;  }"/>
                             <span  style="float: left; margin: 0px 5px 0px 1px;">x</span>
                             <sf:input path="unit2" type="text" placeholder="reps" class="form-control" style="width:33%; float: left; "/>
                           </div>
                        </div>
                        <br>
                        <br>
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
