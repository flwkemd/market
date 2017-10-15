package jsp.store8.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Store8DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store8DAO() {
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
		
		String SQL = "SELECT store8Id FROM STORE8 ORDER BY store8Id DESC";
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
	
	public boolean storeInsert(Store8Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE8");
			sql.append("(store8Id, store8Form, store8Title, store8Num, store8Time1, store8Time2,"
					+ " store8Holiday, store8Service1, store8Service2, store8Service3, store8File1, store8File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore8Id());
			pstmt.setString(2, board.getStore8Form());
			pstmt.setString(3, board.getStore8Title());
			pstmt.setString(4, board.getStore8Num());
			pstmt.setString(5, board.getStore8Time1());
			pstmt.setString(6, board.getStore8Time2());
			pstmt.setString(7, board.getStore8Holiday());
			pstmt.setString(8, board.getStore8Service1());
			pstmt.setString(9, board.getStore8Service2());
			pstmt.setString(10, board.getStore8Service3());
			pstmt.setString(11, board.getStore8File1());
			pstmt.setString(12, board.getStore8File2());

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
	
	public ArrayList<Store8Bean> getBoardList(int start)
	{
		ArrayList<Store8Bean> list = new ArrayList<Store8Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE8 ORDER BY store8Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store8Bean board = new Store8Bean();
				board.setStore8Id(rs.getInt("store8Id"));
				board.setStore8Form(rs.getString("store8Form"));
				board.setStore8Title(rs.getString("store8Title"));
				board.setStore8Num(rs.getString("store8Num"));
				board.setStore8Time1(rs.getString("store8Time1"));
				board.setStore8Time2(rs.getString("store8Time2"));
				board.setStore8Holiday(rs.getString("store8Holiday"));
				board.setStore8Service1(rs.getString("store8Service1"));
				board.setStore8Service2(rs.getString("store8Service2"));
				board.setStore8Service3(rs.getString("store8Service3"));
				board.setStore8File1(rs.getString("store8File1"));
				board.setStore8File2(rs.getString("store8File2"));
				
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
	
	
	public Store8Bean getDetail(int store8Id)
	{	
		Store8Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE8 where store8Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store8Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store8Bean();
				board.setStore8Id(store8Id);
				board.setStore8Form(rs.getString("store8Form"));
				board.setStore8Title(rs.getString("store8Title"));
				board.setStore8Num(rs.getString("store8Num"));
				board.setStore8Time1(rs.getString("store8Time1"));
				board.setStore8Time2(rs.getString("store8Time2"));
				board.setStore8Holiday(rs.getString("store8Holiday"));
				board.setStore8Service1(rs.getString("store8Service1"));
				board.setStore8Service2(rs.getString("store8Service2"));
				board.setStore8Service3(rs.getString("store8Service3"));
				board.setStore8File1(rs.getString("store8File1"));
				board.setStore8File2(rs.getString("store8File2"));
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
			
				sql.append("select count(*) from STORE8");
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
