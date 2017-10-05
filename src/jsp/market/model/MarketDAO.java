package jsp.market.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MarketDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DataSource dataSource;
	
	public MarketDAO() {
		try{
			InitialContext initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) context.lookup("jdbc/napochoo1");
/*			dataSource = (DataSource) context.lookup("jdbc/makeStore");*/
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSeq() {
		String SQL = "SELECT mId FROM MARKET ORDER BY mId DESC";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
				return 1;
		}	catch (Exception e) {
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
	
	public boolean marketInsert(MarketBean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO MARKET");
			sql.append("(mId, mTitle, mContent, mFile)");
			sql.append(" VALUES(?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getmId());
			
			pstmt.setString(2, board.getmTitle());
			pstmt.setString(3, board.getmContent());
			pstmt.setString(4, board.getmFile());

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
	
	public ArrayList<MarketBean> getBoardList()
	{
		ArrayList<MarketBean> list = new ArrayList<MarketBean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM MARKET";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
/*				pstmt.setInt(1, 1);
*/			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				MarketBean board = new MarketBean();
				board.setmId(rs.getInt("mId"));
				board.setmTitle(rs.getString("mTitle"));
				board.setmContent(rs.getString("mContent"));
				board.setmFile(rs.getString("mFile"));
				
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
	
/*	public boolean nextPage(int pageNumber) {
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM MARKET WHERE mId < ?";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, getSeq() - (pageNumber -1) * 10);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
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
		return false;
	}*/
	

	// DB 자원해제
	private void close()
	{
		try {
			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
			if ( conn != null ){ conn.close(); conn=null;	}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	} // end close()
	

}
