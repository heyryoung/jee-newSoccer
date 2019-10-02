<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>	
<div>1</div>
<div>안녕하세요  ${user.playerName} 님! 반갑습니다. playerdo </div>
<div>3</div>
<div>4</div>
<div>
<c:if test="${searchResult == null}">
<jsp:include page="../player/2_positions.jsp"/>	
<jsp:include page="../player/4_find_by_teamid_position.jsp"/>	
<jsp:include page="../player/5_find_by_teamid_height_name.jsp"/>	
</c:if>

<c:if test="${searchResult != null && searchCode =='2_positions'}">
<jsp:include page="../player/2_positions.jsp"/>	
</c:if>
<c:if test="${searchResult != null && searchCode =='4_find_by_teamid_position'}">
<jsp:include page="../player/4_find_by_teamid_position.jsp"/>	
</c:if>
<c:if test="${searchResult != null && searchCode =='5_find_by_teamid_height_name'}">
<jsp:include page="../player/5_find_by_teamid_height_name.jsp"/>	
</c:if>

 </div>
<div>6</div>
<div>7</div>
<div>8</div>
<div>9</div>



<script>
app.init('${ctx}');
</script>
	<jsp:include page="../common/foot.jsp"/>	
</html>