<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Main.jsp</title>
<c:if test="${false}">
	<link rel="stylesheet" href="../../css/bootstrap.css">
	<link rel="stylesheet" href="../../css/animate.css">
</c:if>
</head>
<body>
<c:set var="result" value="${pageMaker.result}"/>
	<div class="panel-heading">
		PROTFOLIO
	</div>
	<div class="panel-body pull-right">
		<table style="overflow: auto;" border="2" align="center">

			<tr align="center">
				<td width="150" align="center"><a href="/main/main">MAIN</a></td>
				<td width="150" align="center"><a href="/board/list"	class='boardLink'>WEB BOARD</a></td>
				<td width="150" align="center"><a href="/dept/list"	class='deptLink'>DEPT</a></td>
				<td width="150" align="center"><a href="/emp/list"   class='boardLink'>EMP</a></td>
				<td width="150" align="center"><a href="/city/list"	class='boardLink'>CITY</a></td>
				<td width="150" align="center"><a href="/country/list" class='boardLink'>COUNTRY</a></td>
			</tr>
		</table>
	</div>
</body>
</html>