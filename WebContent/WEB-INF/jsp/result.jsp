<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Record,model.Type,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%
	List<Record> itemList = (List<Record>) session.getAttribute("itemList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/result.css">
<title></title>
</head>
<body>
	
	<header class="header-7">
		<div class="box box-nav">
			<ul class="inner-nav">
				<li><a href="/safekeeping/ResultServlet?item_type=冷蔵庫" class="menu">冷蔵庫</a></li>
				<li><a href="/safekeeping/ResultServlet?item_type=冷凍庫" class="menu">冷凍庫</a></li>
				<li><a href="/safekeeping/ResultServlet?item_type=野菜室" class="menu">野菜室</a></li>
				<li><a href="/safekeeping/LogoutServlet" class="menu">ログアウト</a>
			</ul>
		</div>
	</header>
	<%-- <div id="topScroll" class="topIcon" onclick="goTop()">Top</div> --%>
		<div class="form-wrapper">
			<div class="wrapper">
				<div align="center">
					<p>
						<img src="image/rogo.png" width="250" height="100">
					</p>
					<p class="label-title"><c:out value="${type.item_type}"/></p>
					<table width="100%" class="table_box">
						<tr>
							<th>名前</th>
							<th>数</th>
							<th>賞味期限</th>
							<th>更新</th>
						</tr>
					</table>
				</div>
					
					<%for (Record record : itemList) {%>
					<form action="/safekeeping/UpdateServlet" method="post">
						<!-- <div class="line"> -->
							<span class="name">
								<input type="hidden" value="<%=record.getItem_id()%>" name="item_id">
								<%=record.getItem_name()%>
							</span> 
							<span>
								<input type="text" name="comment" value="<%=record.getComment()%>" class="comment">
							</span>
							<span>
								<input type="date" name="best_by" value="<%=record.getBest_by()%>" id="after-today" class="best_by">
							</span>
							<span>
								<input type="submit" value="更新" class="submit">
							</span>
						<!-- </div> -->
					</form>
					<%
					}
					%>
					
					<%-- 
					<%for (Record record : itemList) {%>
						<form action="/safekeeping/UpdateServlet" method="post">
							<input type="hidden" value="<%= record.getItem_id() %>" name="item_id">
							<div class="">	
								<span class=""><%= record.getItem_name()%></span>
								
								<span class=""><input type="text" name="comment" value="<%= record.getComment()%>"></span>
								
								<span class=""><input type="date" name="best_by" value="<%= record.getBest_by()%>"></span>
								
								<span class=""><input type="submit" value="更新" class="btn-square-pop"></span>
							</div>
						</form>
					<%} %>
					
					 class="name"
					 --%>
				
			</div>
		</div>

	<footer>
		<a href="/safekeeping/WelcomeServlet" class="button">Homeに戻る</a> 
		<p class="font">©主婦のミカタ</p>
	</footer>
	
	<%--<script src="jquery-3.6.0.min.js"></script>--%>
	<%--<script src="result.js"></script>--%>
</body>
</html>



<%--
				<form action="UpdateServlet" method="post">
				<table width="100%" class="table_box">
					<tr>
						<th>名前</th>
						<th>数</th>
						<th>賞味期限</th>
					</tr>
					<%
						int	line_no = 0;
						for (Record record : itemList ) {
							line_no++;
							String work = "item_id" + line_no;
					%>
					<tr>
							<td width="40%" class="font2">
								<%= record.getItem_name() %>
							</td>
							<td width="35%" class="font2">
								<%work= "comment"+line_no; %>
								<input type="text" name="<%=work %>"  value="<%= record.getComment() %>">
							</td>
							<td width="20%" class="font2">
								<%work= "best_by"+line_no; %>
								<input type="date" name="<%=work %>"  value="<%= record.getBest_by() %>">
							</td>
					</tr>
					<%} %>
				</table>
				<%
					line_no = 0;
					for (Record record : itemList ) {
						line_no++;
						String work = "item_id" + line_no;
				%>
						<input type="hidden" value="<%= record.getItem_id() %>" name="<%=work %>">
				<%} %>
				
				<input type="hidden" value="<%= line_no %>" name="count">
				<p><input type="submit" value="更新"></p>
				</form>
			</div>
			--%>