<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 1/18/16
  Time: 9:24 PM
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
<%-- @elvariable id="vehicles" type="com.george.nileperch" -->
<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
  <div class="box-header with-border">
    <h3 class="box-title">MANAGE VEHICLES</h3>
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
    <div class="table-responsive">
      <div class="row">
        <div class="col-sm-3">
          <a href="/admin/nileperch/vehicleForm" class="navbar-brand"> Add </a>
        </div>
      </div>
      <c:if test="${message}">
        <div class="alert alert-success alert-dismissable">
          Deleted ....
        </div>
      </c:if>
      <c:choose>
        <c:when test="${empty vehicles}">
          <h5>No Vehicles available</h5>
        </c:when>
        <c:otherwise>
          <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
              <th>#</th>
              <th>Reg No</th>
              <th>Owner Name</th>
              <th>Drivers Name</th>
              <th>Conductors Name</th>
            </tr>
            </thead>
            <c:forEach items="vehicles" var="vh">
              <tbody>
              <td>${vh.id}</td>
              <td>${vh.regNo}</td>
              <td>${vh.ownerName}</td>
              <td>${vh.driversName}</td>
              <td>${vh.conductorsName}</td>
              <td></td>
              <td></td>
              <td>
                <a href="/admin/nileperch/vehicle/${vh.id}">Show</a>
              </td>
              <td>
                <a href="/admin/nileperch/vehicle/${vh.id}/edit">Edit</a>
              </td>
              <th>
                <a href="/admin/nileperch/vehicle/${vh.id}/delete">Delete</a>
              </th>
              </tbody>
            </c:forEach>
          </table>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>

