<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br/>
<!-- 쿼리 -->
<!-- 팀 아이디로 해당 팀의 포지션별 선수 검색 기능.  -->
<h3>팀아이디, 키, 성으로 선수 정보 찾기</h3>
<c:if test="${searchResult == null}">
<form action="<%=request.getContextPath()%>/player.do?"  id = "05">
teamId <input type = "text" name = "teamId"  /><br/>
height <input type = "text" name = "height" /><br/>
lastname <input type = "text" name = "lastname" /><br/>
<input type ="hidden" name = "action"  value = "search">
<input type ="hidden" name = "page"  value = "main">
<input type ="hidden" name = "searchCode"  value = "5_find_by_teamid_height_name">
<a href="#" id="5_find_by_teamid_height_name"> 팀아이디, 키, 성으로 선수 정보 찾기</a>
<br/>
</form>
</c:if>
<c:forEach items="${searchResult}" var="dto">
   이름 : ${dto.playerName},  팀 team_ID(${dto.teamId}) ,  키 ${dto.height} 입니다.  <br>
</c:forEach> 


<c:if test="${searchResult != null}">
	<br/><br/>
	<input type="button" value="뒤로가기"  id="back_page_search">
</c:if>