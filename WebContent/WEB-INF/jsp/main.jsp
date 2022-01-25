<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>主婦のミカタ</title>
<link rel="stylesheet" href="css/main.css">

</head>

<body>
	<p>
		ようこそ
		<c:out value="${account_register_id}" />
		さん
	</p>
		
<div class="slide1 slide">
	<div class="form-wrapper">
		<div style="text-align: center">
			<p><img src="image/rogo.png" width="250" height="100"></p>
			<div class="button-panel_a">
      			<h1>
					<a href="/safekeeping/ResultServlet?item_type=冷蔵庫" class="button">
        				<input class="button" value="冷蔵庫"></input>
        			</a>
      			</h1>
    		</div>
  
    		<div class="button-panel_b">
      			<h1>
        			<a href="/safekeeping/ResultServlet?item_type=冷凍庫" class="button">
        				<input class="button" value="冷凍庫"></input>
        			</a>
      			</h1>
    		</div>
    		<div class="button-panel_c">
      			<h1>
        			<a href="/safekeeping/ResultServlet?item_type=野菜室" class="button">
        				<input class="button" value="野菜室"></input>
      				</a>
      			</h1>
    		</div>  
    	
    		<div class="button-panel1">
      			<a href="/safekeeping/ItemServlet">
      				<input class="button" value="項目編集"></input>
      			</a>
    		</div>
			<br>
 			<div class="button-panel2">
 				<a href="/safekeeping/LogoutServlet">
 					<input class="button" value="ログアウト"></input>
 				</a>
    		</div>
		</div>
	</div>
</div>

<%-- 下記ソースは新デザインだが、反映されず --%>
<%-- 
	<div class="main">
		<p>
			<img src="rogo.png" class="img">
		</p>

		<nav id="menu" class="menu">
			<div class="morph-shape"
				data-morph-open="M158.5,0H0v53.1c0,0,19.6-4.6,66-0.2s60.5-3.8,92.5-0.1V0z"
				data-morph-trans="M158.5,0H0v53.1c0,0,35.4,15.4,82,13.8s76.5-14.1,76.5-14.1V0z">
				<svg width="100%" height="100%" viewBox="0 0 158.5 61.2"
					preserveAspectRatio="none">
          <path fill="none"
						d="M158.5,0H0v55.6c20.9-12.8,38.5,19.5,73.5-1.9s73.2-7.2,85,0V0z" />
        </svg>
			</div>
			<button class="menu__label">
				<i class="fa fa-fw fa-bars"></i><span>Open Menu</span>
			</button>
			<ul class="menu__inner">
				<li><a href="/safekeeping/ResultServlet?item_type=冷蔵庫"><i
						class="fa fa-fw fa-bookmark-o"></i><span>冷蔵庫</span></a></li>
				<li><a href="/safekeeping/ResultServlet?item_type=冷凍庫"><i
						class="fa fa-fw fa-hdd-o"></i><span>冷凍庫</span></a></li>
				<li><a href="/safekeeping/ResultServlet?item_type=野菜室"><i
						class="fa fa-fw fa-image"></i><span>野菜室</span></a></li>
				<li><a href="/safekeeping/ItemServlet"><i
						class="fa fa-fw fa-heart-o"></i><span>新規追加</span></a></li>
				<li><a href="/safekeeping/LogoutServlet"><i
						class="fa fa-fw fa-envelope-o"></i><span>ログアウト</span></a></li>
			</ul>
		</nav>
	</div>
--%>
</body>

</html>