<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.mocity.db.PostDb"%>
<%@page import="org.mocity.bean.Post"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>index</title>
	<style type="text/css">
	body,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,legend,button,input,textarea,th,td{margin:0;padding:0}
	</style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div>
     <form id="postadd" name="postadd" method="post" action="p?ac=add">
  <label>文章类型 
  <select name="cid">
    <option value="1">文章</option>
  </select>
  </label>
  <label>标题

  <input type="text" id="title" name="title" value="" />
  

  
  </label>
  <label>内容
  <input type="text" id="content" name="content" value='222222222222'/>
  </label>
时间：<input type="text" name="date" value='2012-10-12' /> 作者id<input type="text" name="uid" value='1' />
<input name="提交" type="submit" value="提交" />
</form>
<a href="postadd.jsp" target="_blank">新页面发布</a>
     </div>
     
     
     <div>
     
     	<ul>
     	<% PostDb postDb=new PostDb();
	 	List listPost=postDb.getAllPosts();
	 	for(int i=0;i<listPost.size();i++){
	 		Post p=(Post)listPost.get(i); %>
	 		
     		<li>
     		<form id="postEdit" name="postedit<%=p.getId() %>" method="post" action="p?pid=<%=p.getId() %>&ac=edit">
     		<%=p.getId() %>
     		<input type="text" name="title" value="<%=p.getTitle() %>" />
     		<input type="text" name="content" value="<%=p.getContent() %>" />
     		<input type="text" name="date" value="<%=p.getDate() %>" />
     		<input type="text" name="cid" value="<%=p.getCid() %>" />
     		<%=p.getUid() %>
     		<input name="提交" type="submit" value="更改" /><a href="post.jsp?id=<%=p.getId() %> " target="_blank">查看</a><a href="p?ac=del&pid=<%=p.getId() %>">删除</a>
     		</form>
     		</li>
     		
     	<% } %>
     	</ul>
    
     </div>
     
     
       <script>
//声明一个随机数变量，默认为1
var GetRandomn = 1;
//获取随机范围内数值的函数
function GetRandom(n){
    GetRandomn=Math.floor(Math.random()*n+1);
    }
//开始调用，获得一个1-100的随机数
GetRandom("300");
//输出查看

document.getElementById('title').value = "测试文章"+GetRandomn;
document.getElementById('content').value = "测试内容"+GetRandomn+"方法随机生成10个数并将这10个数存入一个一维数组\然后用冒泡'\n排序法对数组中的10个数进行升序排序";
</script>
     
</body>
</html>
