package jsp.store5.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Store5DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store5DAO() {
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
		
		String SQL = "SELECT store5Id FROM STORE5 ORDER BY store5Id DESC";
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
	
	public boolean storeInsert(Store5Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE5");
			sql.append("(store5Id, store5Form, store5Title, store5Num, store5Time1, store5Time2,"
					+ " store5Holiday, store5Service1, store5Service2, store5Service3, store5File1, store5File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore5Id());
			pstmt.setString(2, board.getStore5Form());
			pstmt.setString(3, board.getStore5Title());
			pstmt.setString(4, board.getStore5Num());
			pstmt.setString(5, board.getStore5Time1());
			pstmt.setString(6, board.getStore5Time2());
			pstmt.setString(7, board.getStore5Holiday());
			pstmt.setString(8, board.getStore5Service1());
			pstmt.setString(9, board.getStore5Service2());
			pstmt.setString(10, board.getStore5Service3());
			pstmt.setString(11, board.getStore5File1());
			pstmt.setString(12, board.getStore5File2());

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

	public ArrayList<Store5Bean> getBoardList(int start)
	{
		ArrayList<Store5Bean> list = new ArrayList<Store5Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE5 ORDER BY store5Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store5Bean board = new Store5Bean();
				board.setStore5Id(rs.getInt("store5Id"));
				board.setStore5Form(rs.getString("store5Form"));
				board.setStore5Title(rs.getString("store5Title"));
				board.setStore5Num(rs.getString("store5Num"));
				board.setStore5Time1(rs.getString("store5Time1"));
				board.setStore5Time2(rs.getString("store5Time2"));
				board.setStore5Holiday(rs.getString("store5Holiday"));
				board.setStore5Service1(rs.getString("store5Service1"));
				board.setStore5Service2(rs.getString("store5Service2"));
				board.setStore5Service3(rs.getString("store5Service3"));
				board.setStore5File1(rs.getString("store5File1"));
				board.setStore5File2(rs.getString("store5File2"));
				
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
	
	
	public Store5Bean getDetail(int store5Id)
	{	
		Store5Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE5 where store5Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store5Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store5Bean();
				board.setStore5Id(store5Id);
				board.setStore5Form(rs.getString("store5Form"));
				board.setStore5Title(rs.getString("store5Title"));
				board.setStore5Num(rs.getString("store5Num"));
				board.setStore5Time1(rs.getString("store5Time1"));
				board.setStore5Time2(rs.getString("store5Time2"));
				board.setStore5Holiday(rs.getString("store5Holiday"));
				board.setStore5Service1(rs.getString("store5Service1"));
				board.setStore5Service2(rs.getString("store5Service2"));
				board.setStore5Service3(rs.getString("store5Service3"));
				board.setStore5File1(rs.getString("store5File1"));
				board.setStore5File2(rs.getString("store5File2"));
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
