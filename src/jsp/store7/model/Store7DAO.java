package jsp.store7.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Store7DAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public Store7DAO() {
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
		
		String SQL = "SELECT store7Id FROM STORE7 ORDER BY store7Id DESC";
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
	
	public boolean storeInsert(Store7Bean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO STORE7");
			sql.append("(store7Id, store7Form, store7Title, store7Num, store7Time1, store7Time2,"
					+ " store7Holiday, store7Service1, store7Service2, store7Service3, store7File1, store7File2)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getStore7Id());
			pstmt.setString(2, board.getStore7Form());
			pstmt.setString(3, board.getStore7Title());
			pstmt.setString(4, board.getStore7Num());
			pstmt.setString(5, board.getStore7Time1());
			pstmt.setString(6, board.getStore7Time2());
			pstmt.setString(7, board.getStore7Holiday());
			pstmt.setString(8, board.getStore7Service1());
			pstmt.setString(9, board.getStore7Service2());
			pstmt.setString(10, board.getStore7Service3());
			pstmt.setString(11, board.getStore7File1());
			pstmt.setString(12, board.getStore7File2());

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

	public ArrayList<Store7Bean> getBoardList(int start)
	{
		ArrayList<Store7Bean> list = new ArrayList<Store7Bean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE7 ORDER BY store7Id DESC LIMIT ?, ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, 10);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Store7Bean board = new Store7Bean();
				board.setStore7Id(rs.getInt("store7Id"));
				board.setStore7Form(rs.getString("store7Form"));
				board.setStore7Title(rs.getString("store7Title"));
				board.setStore7Num(rs.getString("store7Num"));
				board.setStore7Time1(rs.getString("store7Time1"));
				board.setStore7Time2(rs.getString("store7Time2"));
				board.setStore7Holiday(rs.getString("store7Holiday"));
				board.setStore7Service1(rs.getString("store7Service1"));
				board.setStore7Service2(rs.getString("store7Service2"));
				board.setStore7Service3(rs.getString("store7Service3"));
				board.setStore7File1(rs.getString("store7File1"));
				board.setStore7File2(rs.getString("store7File2"));
				
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
	
	
	public Store7Bean getDetail(int store7Id)
	{	
		Store7Bean board = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from STORE7 where store7Id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, store7Id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new Store7Bean();
				board.setStore7Id(store7Id);
				board.setStore7Form(rs.getString("store7Form"));
				board.setStore7Title(rs.getString("store7Title"));
				board.setStore7Num(rs.getString("store7Num"));
				board.setStore7Time1(rs.getString("store7Time1"));
				board.setStore7Time2(rs.getString("store7Time2"));
				board.setStore7Holiday(rs.getString("store7Holiday"));
				board.setStore7Service1(rs.getString("store7Service1"));
				board.setStore7Service2(rs.getString("store7Service2"));
				board.setStore7Service3(rs.getString("store7Service3"));
				board.setStore7File1(rs.getString("store7File1"));
				board.setStore7File2(rs.getString("store7File2"));
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
			
				sql.append("select count(*) from STORE7");
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
