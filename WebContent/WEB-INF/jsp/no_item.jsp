<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
String errorMsg2 = (String) request.getAttribute("errorMsg2");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table>
		<%if (errorMsg2.length() != 0) {%>
		<tr>
			<td><p>入力エラー</p></td>
			<td><p><%= errorMsg2%></p></td>
			<td><a href="/safekeeping/ResultServlet">戻る</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>