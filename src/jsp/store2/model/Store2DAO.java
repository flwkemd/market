package jsp.store2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Store2DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store2DAO() {
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
		
		String SQL = "SELECT store2Id FROM STORE2 ORDER BY store2Id DESC";
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
	
	public boolean storeInsert(Store2Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE2");
			sql.append("(store2Id, store2Form, store2Title, store2Num, store2Time1, store2Time2,"
					+ " store2Holiday, store2Service1, store2Service2, store2Service3, store2File1, store2File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore2Id());
			pstmt.setString(2, board.getStore2Form());
			pstmt.setString(3, board.getStore2Title());
			pstmt.setString(4, board.getStore2Num());
			pstmt.setString(5, board.getStore2Time1());
			pstmt.setString(6, board.getStore2Time2());
			pstmt.setString(7, board.getStore2Holiday());
			pstmt.setString(8, board.getStore2Service1());
			pstmt.setString(9, board.getStore2Service2());
			pstmt.setString(10, board.getStore2Service3());
			pstmt.setString(11, board.getStore2File1());
			pstmt.setString(12, board.getStore2File2());

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

	public ArrayList<Store2Bean> getBoardList(int start)
	{
		ArrayList<Store2Bean> list = new ArrayList<Store2Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE2 ORDER BY store2Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store2Bean board = new Store2Bean();
				board.setStore2Id(rs.getInt("store2Id"));
				board.setStore2Form(rs.getString("store2Form"));
				board.setStore2Title(rs.getString("store2Title"));
				board.setStore2Num(rs.getString("store2Num"));
				board.setStore2Time1(rs.getString("store2Time1"));
				board.setStore2Time2(rs.getString("store2Time2"));
				board.setStore2Holiday(rs.getString("store2Holiday"));
				board.setStore2Service1(rs.getString("store2Service1"));
				board.setStore2Service2(rs.getString("store2Service2"));
				board.setStore2Service3(rs.getString("store2Service3"));
				board.setStore2File1(rs.getString("store2File1"));
				board.setStore2File2(rs.getString("store2File2"));
				
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
	
	
	public Store2Bean getDetail(int store2Id)
	{	
		Store2Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE2 where store2Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store2Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store2Bean();
				board.setStore2Id(store2Id);
				board.setStore2Form(rs.getString("store2Form"));
				board.setStore2Title(rs.getString("store2Title"));
				board.setStore2Num(rs.getString("store2Num"));
				board.setStore2Time1(rs.getString("store2Time1"));
				board.setStore2Time2(rs.getString("store2Time2"));
				board.setStore2Holiday(rs.getString("store2Holiday"));
				board.setStore2Service1(rs.getString("store2Service1"));
				board.setStore2Service2(rs.getString("store2Service2"));
				board.setStore2Service3(rs.getString("store2Service3"));
				board.setStore2File1(rs.getString("store2File1"));
				board.setStore2File2(rs.getString("store2File2"));
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
			
				sql.append("select count(*) from STORE2");
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
