package jsp.store3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Store3DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store3DAO() {
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
		
		String SQL = "SELECT store3Id FROM STORE3 ORDER BY store3Id DESC";
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
	
	public boolean storeInsert(Store3Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE3");
			sql.append("(store3Id, store3Form, store3Title, store3Num, store3Time1, store3Time2,"
					+ " store3Holiday, store3Service1, store3Service2, store3Service3, store3File1, store3File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore3Id());
			pstmt.setString(2, board.getStore3Form());
			pstmt.setString(3, board.getStore3Title());
			pstmt.setString(4, board.getStore3Num());
			pstmt.setString(5, board.getStore3Time1());
			pstmt.setString(6, board.getStore3Time2());
			pstmt.setString(7, board.getStore3Holiday());
			pstmt.setString(8, board.getStore3Service1());
			pstmt.setString(9, board.getStore3Service2());
			pstmt.setString(10, board.getStore3Service3());
			pstmt.setString(11, board.getStore3File1());
			pstmt.setString(12, board.getStore3File2());

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
	
	public ArrayList<Store3Bean> getBoardList(int start)
	{
		ArrayList<Store3Bean> list = new ArrayList<Store3Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE3 ORDER BY store3Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store3Bean board = new Store3Bean();
				board.setStore3Id(rs.getInt("store3Id"));
				board.setStore3Form(rs.getString("store3Form"));
				board.setStore3Title(rs.getString("store3Title"));
				board.setStore3Num(rs.getString("store3Num"));
				board.setStore3Time1(rs.getString("store3Time1"));
				board.setStore3Time2(rs.getString("store3Time2"));
				board.setStore3Holiday(rs.getString("store3Holiday"));
				board.setStore3Service1(rs.getString("store3Service1"));
				board.setStore3Service2(rs.getString("store3Service2"));
				board.setStore3Service3(rs.getString("store3Service3"));
				board.setStore3File1(rs.getString("store3File1"));
				board.setStore3File2(rs.getString("store3File2"));
				
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
	
	
	public Store3Bean getDetail(int store3Id)
	{	
		Store3Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE3 where store3Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store3Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store3Bean();
				board.setStore3Id(store3Id);
				board.setStore3Form(rs.getString("store3Form"));
				board.setStore3Title(rs.getString("store3Title"));
				board.setStore3Num(rs.getString("store3Num"));
				board.setStore3Time1(rs.getString("store3Time1"));
				board.setStore3Time2(rs.getString("store3Time2"));
				board.setStore3Holiday(rs.getString("store3Holiday"));
				board.setStore3Service1(rs.getString("store3Service1"));
				board.setStore3Service2(rs.getString("store3Service2"));
				board.setStore3Service3(rs.getString("store3Service3"));
				board.setStore3File1(rs.getString("store3File1"));
				board.setStore3File2(rs.getString("store3File2"));
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
			
				sql.append("select count(*) from STORE3");
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
