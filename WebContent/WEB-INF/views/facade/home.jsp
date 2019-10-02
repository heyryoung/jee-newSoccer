<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>	
<div>1</div>
<div>안녕하세요  ${user.playerName} 님! 반갑습니다. </div>
<div>3</div>
<div>4</div>

<div class="home_inner_form" >
<a href="#" id="a_position"> 포지션 종류 보기</a>
<!-- 팀 아이디로 해당 팀의 포지션별 선수 검색 기능.  -->
<h2> </h2>
<form action="<%=request.getContextPath()%>/player.do?"  id = "04">
<input type ="hidden" name = "action"  value = "search">
<input type ="hidden" name = "page"  value = "4_find_by_teamid_position">
<a href="#" id="4_find_by_teamid_position"> 팀아이디와 포지션으로 선수찾기 </a>
</form>
<h2></h2>
<form action="<%=request.getContextPath()%>/player.do?"  id = "05">
<input type ="hidden" name = "action"  value = "search">
<input type ="hidden" name = "page"  value = "5_find_by_teamid_height_name">
<a href="#" id="5_find_by_teamid_height_name"> 팀아이디, 키, 성으로 선수 정보 찾기</a>
</form>
</div>

<div>6</div>
<div>7</div>
<div>8</div>
<div>9</div>



<script>
app.init();
</script>
	<jsp:include page="../common/foot.jsp"/>	
</html>