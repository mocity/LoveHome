package org.mocity.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mocity.bean.Post;
import org.mocity.db.PostDb;

public class PostServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PostServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ac=request.getParameter("ac");
		
		//添加文章
		if(ac.equals("add")){
			String title=request.getParameter("title");
			String content=request.getParameter("content");	
			String conpre=null;
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			int cid = Integer.parseInt(request.getParameter("cid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			System.out.println(content);
			
			Pattern pattern = Pattern.compile("(<p><br></p>)*@mocity@");
			  Matcher m = pattern.matcher(content);

				if (m.find()) {
					conpre = m.group(0);
					// 过滤回复超过2句时产生的换行符。
					 System.out.println(conpre);
				}
			 
			
			Post p=new Post();
			p.setTitle(title);
			p.setContent(content);
			p.setConpre(conpre);
			p.setCid(cid);
			p.setUid(uid);
			p.setDate(date);
			PostDb postDb=new PostDb();
			postDb.postAdd(p);
			response.sendRedirect("index.jsp");	
		}
		
		//删除文章
		if(ac.equals("del")){
			int pid = Integer.parseInt(request.getParameter("pid"));
			PostDb postDb=new PostDb();
			postDb.postDel(pid);
			response.sendRedirect("admin.jsp");	
		}
		
		//更新文章
		if(ac.equals("edit")){
			int pid=Integer.parseInt(request.getParameter("pid"));
			System.out.println(pid);
			String title=request.getParameter("title");
			String content=request.getParameter("content");	
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			Post p=new Post();
			p.setId(pid);
			p.setTitle(title);
			p.setContent(content);
			p.setCid(cid);
			PostDb postDb=new PostDb();
			postDb.postEdit(p);
			response.sendRedirect("index.jsp");	
			return;
		}

		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
