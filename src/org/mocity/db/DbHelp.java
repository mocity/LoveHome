package org.mocity.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public  class DbHelp {

	public static Connection conn=null;         //初始化数据库连接对象
	public static Statement stmt=null;          //初始化陈述对象
	public static PreparedStatement pStmt=null; //
	public static ResultSet rs=null;            //初始化结果集
	
	public static final String CLS="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/lovehome?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
	public static final String USER="root";
	public static final String PWD="123456";
	
	/**
	 * 建立连接
	 */
	public static Connection getConnection(){
		try{
			Class.forName(CLS);
			conn=DriverManager.getConnection(URL,USER,PWD);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 */
	public static void closeAll(){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(pStmt!=null){
				pStmt.close();
				pStmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
