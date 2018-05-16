<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>
<script src="${pageContext.request.contextPath}/static/jquery-1.7.2.js"></script> 
<script type="text/javascript">
function logout(){
	$.post('${pageContext.request.contextPath}/logout',function(){
		location.reload();
	});
}
</script>
</head>
<body>
<shiro:guest>
欢迎游客访问，<a href="${pageContext.request.contextPath}/login">登录</a>
</shiro:guest>
<shiro:user>
欢迎<shiro:principal property="username"/>登录，<a href="javascript:logout();">退出</a>
</shiro:user>
<br/>
<shiro:authenticated>
用户[<shiro:principal property="username"/>]已身份验证通过
</shiro:authenticated>
<br/>
<shiro:hasRole name="testRole">
用户[<shiro:principal property="username"/>]拥有testRole角色<br/>
</shiro:hasRole>
<br/>
<shiro:hasPermission name="test:permission_1">
用户[<shiro:principal property="username"/>]拥有权限test:permission_1<br/>
</shiro:hasPermission>
</body>
</html>