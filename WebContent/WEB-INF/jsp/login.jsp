<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="css/login.css">
<title>主婦のミカタ</title>
</head>
<body>
	<div class="slide1 slide">
		<div class="form-wrapper">
			<div style="text-align: center">
				<p>
					<img src="image/rogo.png" width="250" height="100">
				</p>
				<h1>ログイン</h1>
				<form action="/safekeeping/LoginServlet" method="post">
					<div class="form-item">
						<label for="email"></label> 
						<input type="email" name="account_register_id"
							required="required" placeholder="Email Address">
						<label for="password"></label> 
						<input type="password" name="account_pass"
							required="required" placeholder="Password">
					</div>
					<div class="button-panel">
						<input type="submit" class="button" value="ログイン">
					</div>
				</form>
				<div class="form-footer">
					<p>
						<a href="/safekeeping/RegisterAccount">・ユーザー登録</a>
					</p>
					<p>
						<a href="/safekeeping/WelcomeServlet">・Homeに戻る</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>