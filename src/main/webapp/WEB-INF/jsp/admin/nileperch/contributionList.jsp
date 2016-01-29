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
    <h3 class="box-title">MANAGE CONTRIBUTIONS</h3>
    <div class="box-tools">

    </div>
  </div><!-- /.box-header -->
  <div class="box-body table-responsive no-padding">
    <div class="table-responsive">
      <div class="row">
        <div class="col-sm-3">
          <a href="/admin/nileperch/contribution" class="navbar-brand"> Add </a>
        </div>
      </div>
      <c:if test="${message}">
        <div class="alert alert-success alert-dismissable">
          Deleted ....
        </div>
      </c:if>
      <c:choose>
        <c:when test="${empty contribution}">
          <h5>No Vehicles available</h5>
        </c:when>
        <c:otherwise>
          <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
              <th>#</th>
              <th>Reg No</th>
              <th>Office Contribution</th>
              <th>Share Contribution</th>
              <th>Paid By</th>
            </tr>
            </thead>
            <c:forEach items="contribution" var="cont">
              <tbody>
              <td>${cont.id}</td>
              <td>${cont.regNo}</td>
              <td>${cont.officeCont}</td>
              <td>${cont.shareCont}</td>
              <td>${cont.paidBy}</td>
              <td></td>
              <td></td>
              <td>
                <a href="/admin/nileperch/contribution/${cont.id}">Show</a>
              </td>
              <td>
                <a href="/admin/nileperch/contribution/${cont.id}/edit">Edit</a>
              </td>
              <th>
                <a href="/admin/nileperch/contribution/${cont.id}/delete">Delete</a>
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

