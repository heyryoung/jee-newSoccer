<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br/>
<!-- 쿼리 -->
<!-- 팀 아이디로 해당 팀의 포지션별 선수 검색 기능.  -->
<h3>팀아이디와 포지션으로 선수찾기</h3>
<c:if test="${searchResult == null}">
<form action="<%=request.getContextPath()%>/player.do?"  id = "04">
teamId <input type = "text" name = "teamId"  /><br/>
position <input type = "text" name = "position" /><br/>
<input type ="hidden" name = "action"  value = "search">
<input type ="hidden" name = "page"  value = "main">
<input type ="hidden" name = "searchCode"  value = "4_find_by_teamid_position">
<a href="#" id="4_find_by_teamid_position"> 팀아이디와 포지션으로 선수찾기 </a>
</form>
</c:if>
<c:forEach items="${searchResult}" var="dto">
${dto.playerName}입니다.  <br>
</c:forEach>

<c:if test="${searchResult != null}">		
	<br/><br/> 
	<input type="button" value="뒤로가기"  id="back_page_search">
</c:if>
