package org.mocity.db;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import org.mocity.bean.Post;


public class PostDb extends DbHelp{
	/**
	 * 获取所有文章
	 */
	public List getAllPosts(){
		List list=new ArrayList();
		try{
			super.getConnection();
			String sql="select * from lh_post order by id desc";
			pStmt=conn.prepareStatement(sql);
			rs=pStmt.executeQuery();
			while(rs.next()){
				Post p=new Post();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));
				p.setConpre(rs.getString("conpre"));
				p.setDate(rs.getDate("date"));
				p.setCid(rs.getInt("cid"));
				p.setUid(rs.getInt("uid"));
				
				list.add(p);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}
	
	/**
	 * 取10条
	 */
	public List gettop10Posts(){
		List list=new ArrayList();
		try{
			super.getConnection();
			String sql="select * from lh_post order by id desc limit 0,10";
			pStmt=conn.prepareStatement(sql);
			rs=pStmt.executeQuery();
			while(rs.next()){
				Post p=new Post();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));
				p.setConpre(rs.getString("conpre"));
				p.setDate(rs.getDate("date"));
				p.setCid(rs.getInt("cid"));
				p.setUid(rs.getInt("uid"));
				
				list.add(p);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}
	
	
	/**
	 * 添加文章
	 */
	public int postAdd(Post p){
		int iResult=0;
		try{
			super.getConnection();
			String sql="insert into lh_post(title,content,conpre,date,cid,uid) values(?,?,?,?,?,?)";
			pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, p.getTitle());
			pStmt.setString(2, p.getContent());
			pStmt.setString(3, p.getConpre());
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pStmt.setString(4, df.format(p.getDate()));
			pStmt.setInt(5, p.getCid());
			pStmt.setInt(6, p.getUid());
			
			iResult=pStmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			super.closeAll();
		}
		return iResult;
	}
	
	/**
	 * 通过ID查询文章内容，返回文章对象
	 */
	public Post getPostById(int id){
		Post p=null;
		try{
			super.getConnection();
			String sql="select * from lh_post where id=?";
			pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			
			rs=pStmt.executeQuery();
			
			while(rs.next()){
				p=new Post();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));
				p.setConpre(rs.getString("conpre"));
				p.setDate(rs.getDate("date"));
				p.setCid(rs.getInt("cid"));
				p.setUid(rs.getInt("uid"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			super.closeAll();
		}
		return p;
		}
	
	/**
	 * 删除指定id文章
	 */
	public int postDel(int id){
		int iResult=0;
		try{
			super.getConnection();

			String sql="delete from lh_post where id=?";

			pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			iResult=pStmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			super.closeAll();
		}
		return iResult;
	}
	
	/**
	 * 更新指定文章内容
	 */
	public int postEdit(Post p){
		int iResult=0;
		try{
			super.getConnection();
			String sql="update lh_post set title=?,content=? where id=?";
			pStmt=conn.prepareStatement(sql);
			
			pStmt.setString(1, p.getTitle());
			pStmt.setString(2, p.getContent());
			pStmt.setInt(3, p.getId());
			
			iResult=pStmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			super.closeAll();
		}
		return iResult;
	}
}
