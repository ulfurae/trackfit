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
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body >

        <main class="container-fluid" style="height:100%">
            <div class="main-container">
                <a href="/"><span class="logo glyphicon glyphicon-link" ></span></a>

                <h1 class="title">Add new goal</h1>
                
                <sf:form method="POST" commandName="goalForm" action="/addGoal" id="saveForm">

                    <div class="form-exercise col-md-4">
                        <div class="form-group">

                           <label>Choose exercise:</label>
                           <sf:select path="exerciseID"  placeholder="Chose exercise" class="form-control" required="true">
                                <sf:option value="1" >Power Clean</sf:option>
                                <sf:option value="2" >Back squat</sf:option>
                            </sf:select>

                           <label>Units:</label>
                           <div class="form-group">
                             <sf:input path="unit1" type="number" placeholder="kg" min="0" max="1000" class="form-control" required="true" style="width:33%;  float: left;  margin-right: 5px;"/>
                             <span  style="float: left; margin: 0px 5px 0px 1px;">x</span>
                             <sf:input path="unit2" type="number" placeholder="reps" min="0" max="1000" class="form-control" required="true" style="width:33%; float: left; "/>
                           </div>
                           <label>Start and end date:</label>
                           <div class="form-group">
                              <sf:input type="text" id="startdatepicker" required="true" path="startDate" class="form-control" placeholder="Start date" style="width:45%;  float: left;  margin-right: 5px;"/>
                                <sf:input type="text" id="enddatepicker" required="true" path="endDate" class="form-control" placeholder="End date" style="width:45%;  float: left;"/>
                           </div>
                        </div>
                        <br><br>
                        <div class="form-group">
                            <input type="submit" VALUE="Save Goal" class="btn btn-primary btn-lg btn-block"/>
                        </div>
                    </div>
                </sf:form>
                <br>
                <div class="form-exercise col-md-4">
                    <a class="btn btn-block btn-md btn-success" href="/goalLog" role="button">Goal Log</a>
                </div>

            </div>
        </main>

        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>

             $("#enddatepicker").datepicker();
             $("#startdatepicker").datepicker();
             $("#startdatepicker").datepicker().bind("change",function(){
                                                           var minValue = $(this).val();
                                                           minValue.setDate(minValue.getDate()+1);
                                                           $("#enddatepicker").datepicker( "option", "minDate", minValue );
                                                           });

             $("#saveForm" ).find("input[type='number']").val("");
             $("#saveForm" ).find("input[type='text']").val("");

        </script>
    </body>
</html>
