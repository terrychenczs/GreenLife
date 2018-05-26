<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <title>
        Metronic后台管理系统
    </title>
    <meta name="description" content="Latest updates and statistic charts">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script>
        function logout() {
            $.post('${pageContext.request.contextPath}/logout', function () {
                location.reload();
            });
        }
    </script>
    <!--begin::Base Styles -->
    <!--begin::Page Vendors -->
    <link href="${pageContext.request.contextPath}/assets/vendors/custom/fullcalendar/fullcalendar.bundle.css"
          rel="stylesheet" type="text/css"/>
    <!--end::Page Vendors -->
    <link href="${pageContext.request.contextPath}/assets/vendors/base/vendors.bundle.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath}/assets/demo/default/base/style.bundle.css" rel="stylesheet"
          type="text/css"/>
    <!--end::Base Styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/demo/default/media/img/logo/favicon.ico"/>
</head>
<!-- end::Head -->
<!-- begin::Body -->
<body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
<!-- begin:: Page -->
<div class="m-grid m-grid--hor m-grid--root m-page">
    <%--Header--%>
    <%@ include file="header.jsp" %>
    <!-- begin::Body -->
    <div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">

        <%--AsideMenu--%>
        <%@include file="AsideMenu.jsp" %>

        <%--dataAjax--%>
        <%--<jsp:include page="dataAjax.jsp" flush="true"/>--%>
    </div>

    <%--Footer--%>
    <%@ include file="Footer.jsp" %>
</div>
<!-- end:: Page -->
<!-- begin::Scroll Top -->
<div class="m-scroll-top m-scroll-top--skin-top" data-toggle="m-scroll-top" data-scroll-offset="500"
     data-scroll-speed="300">
    <i class="la la-arrow-up"></i>
</div>
<!-- end::Scroll Top -->

<!--begin::Base Scripts -->
<script src="${pageContext.request.contextPath}/assets/vendors/base/vendors.bundle.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/demo/default/base/scripts.bundle.js"
        type="text/javascript"></script>
<!--end::Base Scripts -->
<!--begin::Page Vendors -->
<script src="${pageContext.request.contextPath}/assets/vendors/custom/fullcalendar/fullcalendar.bundle.js"
        type="text/javascript"></script>
<!--end::Page Vendors -->
<!--begin::Page Snippets -->
<script src="${pageContext.request.contextPath}/assets/app/js/dashboard.js" type="text/javascript"></script>
<!--end::Page Snippets -->
</body>
<!-- end::Body -->
</html>

