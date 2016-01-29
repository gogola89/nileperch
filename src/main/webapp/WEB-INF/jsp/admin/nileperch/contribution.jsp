<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 1/22/16
  Time: 3:53 PM
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
    <h3 class="box-title">VIEW CONTRIBUTION DETAILS</h3>
    <div class="box-tools">
    </div>
  </div><!-- /.box-header -->
  <div class="box-body no-padding">
    <div class="row">
      <div class="col-lg-6">
        <div class="panel panel-default">
          <div class="panel-heading">
            Contribution Details
          </div>
          <div class="panel-body">

            <dl class="dl-horizontal">
              <dt>Reg No</dt>
              <dd>${contribution.regNo}</dd>
              <br />
              <dt>Office Contribution</dt>
              <dd>${contribution.officeCont}</dd>
              <br />
              <dt>Share Contribution</dt>
              <dd>${contribution.shareCont}</dd>
              <br />
              <dt>Paid by</dt>
              <dd>${contribution.paidBy}</dd>
            </dl>
          </div>
          <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
      </div>
    </div>
  </div>
</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>
