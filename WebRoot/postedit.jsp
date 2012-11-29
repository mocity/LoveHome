<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.mocity.db.PostDb"%>
<%@page import="org.mocity.bean.Post"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 
	int id=Integer.parseInt(request.getParameter("id"));
	PostDb postDb=new PostDb();
	Post p=new Post();
	p=postDb.getPostById(id);
	 %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新文档</title>
<link rel="stylesheet" type="text/css" href="./images/style.css" />
<link rel="stylesheet" type="text/css" href="./images/post.css" />
<script type="text/javascript" charset="utf-8" src="./include/ueditor/editor_config.js"></script>
<script type="text/javascript" charset="utf-8" src="./include/ueditor/editor_all_min.js"></script>
<link rel="stylesheet" type="text/css" href="./include/ueditor/themes/default/ueditor.css"/>
</head>

<body>
<%@ include file="side.jsp" %>

	<div id="main">
		<div id="addcon">
			<div id="addleft">
			<form id="postadd" name="postadd" method="post" action="p?ac=edit">		
				<div id="addleftc">
					<div id="alh2"><font>问渠那得清如许，为有源头活水来</font><span>一个链接</span></div>
					<div id="ptitle">
						<h3 class="content-title">  
						标题<span class="small-tips" style="display:none;">（可不填）</span>
						<label>类型 <select name="cid">
						    <option value="1">文章</option>
						    <option value="2">图片</option>
						    <option value="3">代码</option>
						    <option value="4">网址</option>
						  </select></label>
  					</h3>
						<span class="qpub-text-box" href="#">
						<input id="title" name="title" value="<%=p.getTitle() %>" class="qpub-text placeholder" type="text" />
						</span>
					</div>
					<div id="pcont">
						<div style="margin-bottom:15px; font-size:14px;">内容</div>
						<script type="text/plain" id="myEditor" name="content" style="width:655px">
						<%=p.getContent() %>
						</script>
					    <script type="text/javascript">
					        var editor = new baidu.editor.ui.Editor();
					        editor.render( 'myEditor' );
					    </script>
					</div>
					<div id="pbtn">
					<input type="text" hidden="hidden" name="pid" value='<%=p.getId() %>' />
					<input type="text" hidden="hidden" name="uid" value='<%=p.getCid() %>' />
					<input id="postadds" name="提交" type="submit" value="提交" />
					</div>
				</div>
			</form>	
				
			</div>
			<div id="addright">
				
			</div>
		</div>
	</div>

</body>
</html>
