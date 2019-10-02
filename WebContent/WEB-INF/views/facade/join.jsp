<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp"/>	
<div>1</div>
<div>
</div>
<div>3</div>
<div>4</div>
	<div id ="join_wrapper">
	<form id="join_form" >

	<div class="join_inner_form" >
	<div>ID </div><div><input type="text" name="playerId" class="join_input" id="playerId"></div>	
	<div>solar </div><div><input type="password" name="solar" class="join_input" id="solar"></div>	
	<div>이름 </div><div><input type="text" name="playerName" class="join_input"></div>	
	<div>팀아이디</div><div><input type="text" name="teamId"class="join_input"></div>	
	<div>ePlayerName </div><div><input type="text" name="ePlayerName" class="join_input"></div>	
	<div>nickname </div><div><input type="text" name="nickname" class="join_input"></div>	
	<div>joinYyyy </div><div><input type="text" name="joinYyyy" class="join_input"></div>	
	<div>position </div><div><input type="text" name="position" class="join_input"></div>	
	<div>backNo </div><div><input type="text" name="backNo" class="join_input"></div>	
	<div>nation </div><div><input type="text" name="nation" class="join_input"></div>	
	<div>birthDate </div><div><input type="text" name="birthDate" class="join_input"></div>	
	<div>height </div><div><input type="text" name="height" class="join_input"></div>	
	<div>weight </div><div><input type="text" name="weight" class="join_input"></div>	
		<input type="hidden" name="action" value="create"> 
		<input type="hidden" name="page" value="main">
	<div id="submit_form"><input type="button" value="회원가입"  id="join_submit">
	<input type="button" value="뒤로가기"  id="back_page">
	</div>
	</div>	
	</form> 
	</div>

<div>6</div>
<div>7</div>
<div>9</div>
<script>
	app.init('${ctx}');
</script>
<jsp:include page="../common/foot.jsp"/>	
</html>