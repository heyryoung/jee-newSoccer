<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp" />
<div>1</div>
<div>
<img src="${img}/soccer_intro.jpg" alt="" id="soccer_intro">
<!-- <h2>축구협회관리시스템</h2> -->
</div>
<div>3</div>
<div>4</div>
	<form id="login_form"  >
	<div class="input_form">
	<div id="login_item1">ID <input type="text" name="playerId" class="input_text" id="playerId"></div>	
	<div id="login_item2"><input type="button" value="로그인"  id="login_btn"></div>
	<div id="login_item3">PW <input type="password" name="solar" class="input_text" id="solar"></div>	
	<input type="hidden" name="action" value="login"> 
		<input type="hidden" name="page" value="main">
	</div>	
	</form> 
<div>6</div>
<div>7</div>
<div>
	<h3 id="join_a"><a href="#" id="a_join">회원가입</a>	</h3>
</div>
<div>9</div>
<script>
	app.init('${ctx}');
</script>
<jsp:include page="../common/foot.jsp" />
