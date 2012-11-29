<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.mocity.db.PostDb"%>
<%@page import="org.mocity.bean.Post"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>墨城的博客</title>
<link rel="stylesheet" type="text/css" href="./images/style.css" />


</head>

<body>

<%@ include file="side.jsp" %>

<div id="main">


<% PostDb postDb=new PostDb();
	 	List listPost=postDb.gettop10Posts();
	 	for(int i=0;i<listPost.size();i++){
	 		Post p=(Post)listPost.get(i); %>
<ul id="post-list">
	<li class="post text">
		<div class="body">
			<h2 class="title"><a href="post.jsp?id=<%=p.getId() %>" target="_blank"><%=p.getTitle() %></a></h2>
				<div class="rich-content"><%=p.getContent() %></div>
		</div>
		<div class="meta">
			<span class="reblog"><a href="#">分类 :<%=p.getCid() %></a>&nbsp; <%=p.getDate() %></span>
			<span class="notes-count"><a href="#">0&nbsp;热度</a></span>
		</div>
	</li>	
</ul>
<% } %>

</div>
<!-- 代码高亮 -->
<link rel="stylesheet" type="text/css" href="./include/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css" />
<script type="text/javascript" src="./include/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<script>SyntaxHighlighter.all();</script>
<!-- 代码高亮结束 -->
</body>
</html>
