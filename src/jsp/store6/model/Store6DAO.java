package jsp.store6.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Store6DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store6DAO() {
		try{
			InitialContext initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:/comp/env");
//			dataSource = (DataSource) context.lookup("jdbc/napochoo1");
			dataSource = (DataSource) context.lookup("jdbc/makeStore");
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSeq() {
		
		String SQL = "SELECT store6Id FROM STORE6 ORDER BY store6Id DESC";
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
				try{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			} 
		return -1;
	}
	
	public boolean storeInsert(Store6Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE6");
			sql.append("(store6Id, store6Form, store6Title, store6Num, store6Time1, store6Time2,"
					+ " store6Holiday, store6Service1, store6Service2, store6Service3, store6File1, store6File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore6Id());
			pstmt.setString(2, board.getStore6Form());
			pstmt.setString(3, board.getStore6Title());
			pstmt.setString(4, board.getStore6Num());
			pstmt.setString(5, board.getStore6Time1());
			pstmt.setString(6, board.getStore6Time2());
			pstmt.setString(7, board.getStore6Holiday());
			pstmt.setString(8, board.getStore6Service1());
			pstmt.setString(9, board.getStore6Service2());
			pstmt.setString(10, board.getStore6Service3());
			pstmt.setString(11, board.getStore6File1());
			pstmt.setString(12, board.getStore6File2());

			int flag = pstmt.executeUpdate();
			if(flag > 0){
				result = true;
				conn.commit(); // 완료시 커밋
			}
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} 
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return result;	
	} // end boardInsert();

	public ArrayList<Store6Bean> getBoardList(int start)
	{
		ArrayList<Store6Bean> list = new ArrayList<Store6Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE6 ORDER BY store6Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store6Bean board = new Store6Bean();
				board.setStore6Id(rs.getInt("store6Id"));
				board.setStore6Form(rs.getString("store6Form"));
				board.setStore6Title(rs.getString("store6Title"));
				board.setStore6Num(rs.getString("store6Num"));
				board.setStore6Time1(rs.getString("store6Time1"));
				board.setStore6Time2(rs.getString("store6Time2"));
				board.setStore6Holiday(rs.getString("store6Holiday"));
				board.setStore6Service1(rs.getString("store6Service1"));
				board.setStore6Service2(rs.getString("store6Service2"));
				board.setStore6Service3(rs.getString("store6Service3"));
				board.setStore6File1(rs.getString("store6File1"));
				board.setStore6File2(rs.getString("store6File2"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		} 
		return list;
	} // end getBoardList
	
	
	public Store6Bean getDetail(int store6Id)
	{	
		Store6Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE6 where store6Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store6Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store6Bean();
				board.setStore6Id(store6Id);
				board.setStore6Form(rs.getString("store6Form"));
				board.setStore6Title(rs.getString("store6Title"));
				board.setStore6Num(rs.getString("store6Num"));
				board.setStore6Time1(rs.getString("store6Time1"));
				board.setStore6Time2(rs.getString("store6Time2"));
				board.setStore6Holiday(rs.getString("store6Holiday"));
				board.setStore6Service1(rs.getString("store6Service1"));
				board.setStore6Service2(rs.getString("store6Service2"));
				board.setStore6Service3(rs.getString("store6Service3"));
				board.setStore6File1(rs.getString("store6File1"));
				board.setStore6File2(rs.getString("store6File2"));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return board;
	} // end getDetail()
	
	public int getBoardListCount()
	{
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			StringBuffer sql = new StringBuffer();
			
				sql.append("select count(*) from STORE6");
				pstmt = conn.prepareStatement(sql.toString());

				rs = pstmt.executeQuery();
				if(rs.next())	
					result = rs.getInt(1);
				
		}catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			
			close();
			return result;
		} // end getBoardListCount	
	
	
	// DB 자원해제
	private void close()
	{
		try {
			if ( rs != null) {rs.close(); rs=null;}
			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
			if ( conn != null ){ conn.close(); conn=null;	}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	} // end close()
	

}
