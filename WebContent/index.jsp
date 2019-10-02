<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<img src="<%=request.getContextPath()%>/RESOURCES/img/loading.gif" alt="" >
<script>
location.assign("<%=request.getContextPath()%>/facade.do") 
</script>
