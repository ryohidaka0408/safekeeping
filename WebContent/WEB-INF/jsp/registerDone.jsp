<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" href="css/registerComplete.css">
</head>
<body>
	<div class="slide1 slide">
		<div class="form-wrapper">
			<div style="text-align: center">
  				<p><img src="image/rogo.png" width="250" height="100"></p>
  				<h1>登録完了しました</h1>
  				<form action="/safekeeping/LoginServlet" method="post">
    				<div class="button-panel">
      						<input type="submit" class="btn-square-pop" value="ログイン">
    				</div>
  				</form>
  				<div class="form-footer">
    				<a href="/safekeeping/WelcomeServlet">・Homeに戻る</a>
  				</div>
			</div>
		</div>
	</div>
</body>
</html>