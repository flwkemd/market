package jsp.store4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jsp.store3.model.Store3Bean;

public class Store4DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store4DAO() {
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
		
		String SQL = "SELECT store4Id FROM STORE4 ORDER BY store4Id DESC";
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
	
	public boolean storeInsert(Store4Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE4");
			sql.append("(store4Id, store4Form, store4Title, store4Num, store4Time1, store4Time2,"
					+ " store4Holiday, store4Service1, store4Service2, store4Service3, store4File1, store4File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore4Id());
			pstmt.setString(2, board.getStore4Form());
			pstmt.setString(3, board.getStore4Title());
			pstmt.setString(4, board.getStore4Num());
			pstmt.setString(5, board.getStore4Time1());
			pstmt.setString(6, board.getStore4Time2());
			pstmt.setString(7, board.getStore4Holiday());
			pstmt.setString(8, board.getStore4Service1());
			pstmt.setString(9, board.getStore4Service2());
			pstmt.setString(10, board.getStore4Service3());
			pstmt.setString(11, board.getStore4File1());
			pstmt.setString(12, board.getStore4File2());

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
	
	public ArrayList<Store4Bean> getBoardList(int start)
	{
		ArrayList<Store4Bean> list = new ArrayList<Store4Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE4 ORDER BY store4Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store4Bean board = new Store4Bean();
				board.setStore4Id(rs.getInt("store4Id"));
				board.setStore4Form(rs.getString("store4Form"));
				board.setStore4Title(rs.getString("store4Title"));
				board.setStore4Num(rs.getString("store4Num"));
				board.setStore4Time1(rs.getString("store4Time1"));
				board.setStore4Time2(rs.getString("store4Time2"));
				board.setStore4Holiday(rs.getString("store4Holiday"));
				board.setStore4Service1(rs.getString("store4Service1"));
				board.setStore4Service2(rs.getString("store4Service2"));
				board.setStore4Service3(rs.getString("store4Service3"));
				board.setStore4File1(rs.getString("store4File1"));
				board.setStore4File2(rs.getString("store4File2"));
				
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
	
	
	
	public Store4Bean getDetail(int store4Id)
	{	
		Store4Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE4 where store4Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store4Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store4Bean();
				board.setStore4Id(store4Id);
				board.setStore4Form(rs.getString("store4Form"));
				board.setStore4Title(rs.getString("store4Title"));
				board.setStore4Num(rs.getString("store4Num"));
				board.setStore4Time1(rs.getString("store4Time1"));
				board.setStore4Time2(rs.getString("store4Time2"));
				board.setStore4Holiday(rs.getString("store4Holiday"));
				board.setStore4Service1(rs.getString("store4Service1"));
				board.setStore4Service2(rs.getString("store4Service2"));
				board.setStore4Service3(rs.getString("store4Service3"));
				board.setStore4File1(rs.getString("store4File1"));
				board.setStore4File2(rs.getString("store4File2"));
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
			
				sql.append("select count(*) from STORE4");
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
