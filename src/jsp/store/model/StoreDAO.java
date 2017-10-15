package jsp.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StoreDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public StoreDAO() {
		try{
			InitialContext initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) context.lookup("jdbc/napochoo1");
//			dataSource = (DataSource) context.lookup("jdbc/makeStore");
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSeq() {
		
		String SQL = "SELECT store1Id FROM STORE1 ORDER BY store1Id DESC";
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
	
	public boolean storeInsert(StoreBean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE1");
			sql.append("(store1Id, store1Form, store1Title, store1Num, store1Time1, store1Time2,"
					+ " store1Holiday, store1Service1, store1Service2, store1Service3, store1File1, store1File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore1Id());
			pstmt.setString(2, board.getStore1Form());
			pstmt.setString(3, board.getStore1Title());
			pstmt.setString(4, board.getStore1Num());
			pstmt.setString(5, board.getStore1Time1());
			pstmt.setString(6, board.getStore1Time2());
			pstmt.setString(7, board.getStore1Holiday());
			pstmt.setString(8, board.getStore1Service1());
			pstmt.setString(9, board.getStore1Service2());
			pstmt.setString(10, board.getStore1Service3());
			pstmt.setString(11, board.getStore1File1());
			pstmt.setString(12, board.getStore1File2());

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
	
	/*String SQL = "SELECT * FROM STORE1 WHERE store1Id >= ? ORDER BY store1Id DESC LIMIT 10";*/
	/*pstmt.setInt(1, start);*/

	public ArrayList<StoreBean> getBoardList(int start)
	{
		ArrayList<StoreBean> list = new ArrayList<StoreBean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE1 ORDER BY store1Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				StoreBean board = new StoreBean();
				board.setStore1Id(rs.getInt("store1Id"));
				board.setStore1Form(rs.getString("store1Form"));
				board.setStore1Title(rs.getString("store1Title"));
				board.setStore1Num(rs.getString("store1Num"));
				board.setStore1Time1(rs.getString("store1Time1"));
				board.setStore1Time2(rs.getString("store1Time2"));
				board.setStore1Holiday(rs.getString("store1Holiday"));
				board.setStore1Service1(rs.getString("store1Service1"));
				board.setStore1Service2(rs.getString("store1Service2"));
				board.setStore1Service3(rs.getString("store1Service3"));
				board.setStore1File1(rs.getString("store1File1"));
				board.setStore1File2(rs.getString("store1File2"));
				
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
	
	
	public StoreBean getDetail(int store1Id)
	{	
		StoreBean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE1 where store1Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store1Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new StoreBean();
				board.setStore1Id(store1Id);
				board.setStore1Form(rs.getString("store1Form"));
				board.setStore1Title(rs.getString("store1Title"));
				board.setStore1Num(rs.getString("store1Num"));
				board.setStore1Time1(rs.getString("store1Time1"));
				board.setStore1Time2(rs.getString("store1Time2"));
				board.setStore1Holiday(rs.getString("store1Holiday"));
				board.setStore1Service1(rs.getString("store1Service1"));
				board.setStore1Service2(rs.getString("store1Service2"));
				board.setStore1Service3(rs.getString("store1Service3"));
				board.setStore1File1(rs.getString("store1File1"));
				board.setStore1File2(rs.getString("store1File2"));
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
			
				sql.append("select count(*) from STORE1");
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
