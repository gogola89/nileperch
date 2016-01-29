<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 1/18/16
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="/WEB-INF/jsp/common/adminHeader.jsp">
    <jsp:param name="title" value="NILEPERCH"/>
  </jsp:include>
</head>
<jsp:include page="/WEB-INF/jsp/common/adminHead.jsp"/>

<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
  <div class="box-header with-border">
    <h3 class="box-title">NILEPERCH ADMIN</h3>
    <div class="box-tools">
      <%--<div class="input-group">--%>
      <%--<input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>--%>
      <%--<div class="input-group-btn">--%>
      <%--<button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>--%>
      <%--</div>--%>
      <%--</div>--%>
    </div>
  </div><!-- /.box-header -->
  <div class="box-body table-responsive no-padding">
    <%--<h3>Welcome To Admin Panel</h3> --%>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <c:set var="val" value="${action}" />
      <c:choose>
        <c:when test="${val=='CREATE'}"><h1 class="page-header">Add Member</h1></c:when>
        <c:otherwise><h1 class="page-header">Edit Member</h1></c:otherwise>
      </c:choose>


      <form:form acceptCharset="UTF-8" action="/admin/nileperch/member/${action}" method="post" modelAttribute="member" cssClass="form-horizontal" role="form">

        <div class="form-group">
          <label for="firstName" class="col-sm-2 control-label">First Name</label>
          <div class="col-sm-4">
            <form:input path="firstName" id="firstName" type="text" cssClass="form-control" placeholder="firstName" />
            <form:errors path="firstName" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="secondName" class="col-sm-2 control-label"> Second Name</label>
          <div class="col-sm-4">
            <form:input path="secondName" id="secondName" type="text" cssClass="form-control" />
            <form:errors path="secondName" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="sirName" class="col-sm-2 control-label"> Sirname</label>
          <div class="col-sm-4">
            <form:input path="sirName" id="sirName" type="text" cssClass="form-control" />
            <form:errors path="sirName" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="idNumber" class="col-sm-2 control-label">ID Number</label>
          <div class="col-sm-4">
            <form:input path="idNumber" id="idNumber" cssClass="form-control" placeholder="idNumber" />
            <form:errors path="idNumber" cssClass="form-inline" />
            <form:input path="id" type="hidden"/>
          </div>
        </div>
        <div class="form-group">
          <label for="email" class="col-sm-2 control-label">Email</label>
          <div class="col-sm-4">
            <form:input path="email" id="email" type="email" cssClass="form-control" placeholder="email" />
            <form:errors path="email" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>
          <div class="col-sm-4">
            <form:input path="phoneNumber" id="phoneNumber"  cssClass="form-control" placeholder="Phone Number" />
            <form:errors path="phoneNumber" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="kraPin" class="col-sm-2 control-label">KRA PIN</label>
          <div class="col-sm-4">
            <form:input path="kraPin" id="kraPin" cssClass="form-control" placeholder="KRA PIN" />
            <form:errors path="kraPin" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">Sex</label>
          <div class="radio">
            <label>
              <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Male
            </label>
          </div>
          <div class="radio">
            <label>
              <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Female
            </label>
          </div>
        </div>
        <div class="form-group">
          <label>Good Conduct</label>
          <input type="file">
        </div>
        <div class="form-group">
          <label>Tax Compliance</label>
          <input type="file">
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <input class="btn btn-success" type="submit" value="Submit">
          </div>
        </div>
      </form:form>
    </div>
  </div>

</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>

