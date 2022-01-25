<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Account"%>
<%
Account registerAccount = (Account) session.getAttribute("registerAccount");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="css/registerConfirm.css">
<title>ユーザー登録</title>
</head>
<body>
	<%
		if (errorMsg.length() != 0) {
	%>
	<p>入力エラー</p>
	<p><%=errorMsg%>
	</p>
		<a href="/safekeeping/RegisterAccount">戻る</a>
	<%
		}
	%>
	<%
		if (errorMsg == null || errorMsg.length() == 0) {
	%>
	<div class="slide1 slide">
		<div class="form-wrapper">
			<div style="text-align: center">
				<p>
					<img src="image/rogo.png" width="250" height="100">
				</p>
				<form>
					<p class="label-title">下記のユーザーを登録します</p>
					<table>
						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										氏名:
										<%=registerAccount.getAccount_name()%>
									</p>
								</div>
							</td>
						</tr>
						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										ユーザーID:
										<%=registerAccount.getAccount_register_id()%>
								</div>
							</td>
						</tr>

						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										パスワード:
										<%=registerAccount.getAccount_pass()%>
									</p>
								</div>
							</td>
						</tr>
					</table>

					<table>
						<tr>
							<td align="center">
								<a href="/safekeeping/RegisterAccount">
									<input type="button" value="戻る">
								</a>
							</td>
							<td align="center">
								<a href="/safekeeping/RegisterAccount?action=done">
									<input type="button" value="登録">
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
			
	<%
	}
	%>
</body>
</html>
