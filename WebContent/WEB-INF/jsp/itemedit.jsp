<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ItemEdit,java.util.List"%>

<%
	List<ItemEdit> itemEditList = (List<ItemEdit>) session.getAttribute("itemEditList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/Item_editing.css">
<title>項目編集</title>
</head>
<body>
	<%-- <div id="topScroll" class="topIcon" onclick="goTop()">Top</div> --%>
	<div class="slide1 slide">
		<div class="form-wrapper">
			<div align="center">
				<table width="100%">
					<tr>
						<td align="right">
							<p>
								<img src="image/rogo.png" width="250" height="100">
							</p>
						</td>
					</tr>
				</table>
				<p class="label-title">項目編集</p>
			</div>
			<table width="80%" align="center">
				
				<%for (ItemEdit itemEdit :  itemEditList) {%>
				
				<tr class="fontsize">
					<td width="50%">
						<ul>
							<li><%= itemEdit.getItem_name() %></li>
						</ul>
					</td>
					<td width="50%">
						<ul>
							<li><%= itemEdit.getItem_type() %></li>
						</ul>
					</td>
					<td align="center" width="30%">
						<input type="button" class="btn-square-pop" value="削除">
					</td>
				</tr>
				<%} %>
			</table>
			<div align="center">
				<p class="label-title" id="editing">新規</p>
			</div>
			<form action="/safekeeping/ItemServlet" method="post" >
				<table border="1" width="100%" align="center">
					<tr>
						<th>項目名</th>
						<th>格納場所</th>
					</tr>
					<tr>
						<td width="40%" align="center">
							<input type="text" name="item_name" class="form-input" placeholder="追加する項目を入力" >
						</td>
						<td width="40%" align="center">
							<div class="radioArea" id="makeImg">
								<input type="radio" name="item_type" value="冷蔵庫" id="r1" checked>
								<label for="r1">冷蔵庫</label> 
								<input type="radio" name="item_type" value="冷凍庫" id="r2">
								<label for="r2">冷凍庫</label> 
								<input type="radio" name="item_type" value="野菜室" id="r3">
								<label for="r3">野菜室</label>
							</div>
						</td>
						<table border="1" width="100%" align="center">
							<tr>
								<th>数(コメント)</th>
								<th>賞味期限</th>
							</tr>
							<tr>
								<td width="40%" align="center">	
									<input type="text" class="form-input" name="comment"
										placeholder="データがありません">
								</td>
								<td width="40%" align="center">
									<input type="date" name="best_by" value="" id="after-today"
										class="today">
								</td>
							</tr>
						</table>
						<div align="right">
								<input type="submit" class="btn-square-pop2" value="追加">
						</div>
					</tr>
				</table>
			</form>
			<br>
			<div class="form-footer">
				<br>
				<table align="center" width="80%" style="font-size: 15pt;">
					<tr>
						<td align="center">
							<a href="/safekeeping/WelcomeServlet">・Homeに戻る</a>
						</td>
						<td align="center">
							<form action="/safekeeping/LoginServlet" method="post">
								<input type="submit" value="・メイン画面に戻る">
							</form>
						</td>
					</tr>
				</table>
				<br>
			</div>
		</div>
	</div>

</body>
</html>