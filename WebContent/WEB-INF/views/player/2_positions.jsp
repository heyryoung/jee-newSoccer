<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/>
<h3>포지션 종류 보기</h3>
<c:if test="${searchResult == null}">
<a href="#" id="a_position"> 포지션 종류 보기</a>
</c:if>
<br/>
<!-- 결과 -->
<c:if test="${searchResult != null}">
포지션은 ${searchResult} 입니다

<br/><br/>
<input type="button" value="뒤로가기"  id="back_page_search">
</c:if>
