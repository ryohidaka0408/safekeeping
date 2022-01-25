
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="css/registerForm.css">
<title>ユーザー登録</title>
</head>
<body>
		<div class="form-wrapper">
			<div style="text-align: center">
				<p>
					<img src="image/rogo.png" width="250" height="100">
				</p>
				<form action="/safekeeping/RegisterAccount" method="post">
					<p class="label-title">ユーザー登録</p>
					<table>
						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										Name
									</p>
									<input type="text" class="form-input" name="account_name"
										pattern="^.+[ ].+$" maxlength="40" placeholder="例）大阪 太郎"
										required>
								</div>
							</td>
						</tr>

						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										Email
									</p>
									<input type="email" class="form-input" name="account_register_id"
										maxlength="100" placeholder="例）example@sukkiri.com" required>
								</div>
							</td>
						</tr>

						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										Pass
									</p>
									<input type="password" class="form-input" name="account_pass" id="account_pass"
										pattern="^[0-9a-zA-Z]{4,10}$" placeholder="半角英数4～10文字で入力" required>
								</div>
							</td>
						</tr>

						<tr>
							<td align="left">
								<div class="form-sample">
									<p class="form-label">
										再入力
									</p>
									<input type="password" class="form-input" name="pass2"
										oninput="CheckPassword(this)" placeholder="半角英数4～10文字で入力" required>
								</div>
							</td>
						</tr>
						<tr>	
							<td align="center">
								<input type="submit" class="btn-square-pop" value="確認">
							</td>
							<td align="center">
								<a href="/safekeeping/WelcomeServlet" class="btn-square-pop">
									ホームに戻る
								</a>
							</td>
						</tr>
					</table>
				</form>
							
				</div>
			</div>
	<script type="text/javascript" src="js/registerForm.js"></script>
</body>
</html>




