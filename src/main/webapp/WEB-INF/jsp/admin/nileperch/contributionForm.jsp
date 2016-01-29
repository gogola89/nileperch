<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 1/22/16
  Time: 3:55 PM
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
        <c:when test="${val=='CREATE'}"><h1 class="page-header">Add Cntribution</h1></c:when>
        <c:otherwise><h1 class="page-header">Edit Contribution</h1></c:otherwise>
      </c:choose>


      <form:form acceptCharset="UTF-8" action="/admin/nileperch/contribution/${action}" method="post" modelAttribute="contribution" cssClass="form-horizontal" role="form">

        <div class="form-group">
          <label for="regNo" class="col-sm-2 control-label">Vehicle RegNo</label>
          <div class="col-sm-4">
            <form:input path="regNo" id="regNo" type="text" cssClass="form-control" placeholder="VehicleReg" />
            <form:errors path="regno" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="officeCont" class="col-sm-2 control-label"> Office Contribution</label>
          <div class="col-sm-4">
            <form:input path="officeCont" id="officeCont" cssClass="form-control" />
            <form:errors path="office" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="shareCont" class="col-sm-2 control-label"> Share Contribution</label>
          <div class="col-sm-4">
            <form:input path="shareCont" id="shareCont" cssClass="form-control" />
            <form:errors path="share" cssClass="form-inline" />
          </div>
        </div>
        <div class="form-group">
          <label for="paidBy" class="col-sm-2 control-label"> Paid By</label>
          <div class="col-sm-4">
            <form:input path="paidBy" id="conductorsName" type="text" cssClass="form-control" />
            <form:errors path="payer" cssClass="form-inline" />
          </div>
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

