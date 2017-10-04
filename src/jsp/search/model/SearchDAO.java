package jsp.search.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SearchDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public SearchDAO() {
		try{
			InitialContext initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:/comp/env");
/*			dataSource = (DataSource) context.lookup("jdbc/napochoo1");*/
			dataSource = (DataSource) context.lookup("jdbc/makeStore");
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSeq() {
		
		String SQL = "SELECT sId FROM SEARCH ORDER BY sId DESC";
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
		}
		close();
		return -1;
	}
	
	public boolean searchInsert(SearchBean board)
	{
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			
			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO SEARCH");
			sql.append("(sId, sTitle, sContent, sAddress, sTime1, sTime2, sTime3, sTime4, sFile)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getsId());
			pstmt.setString(2, board.getsTitle());
			pstmt.setString(3, board.getsContent());
			pstmt.setString(4, board.getsAddress());
			pstmt.setInt(5, board.getsTime1());
			pstmt.setInt(6, board.getsTime2());
			pstmt.setInt(7, board.getsTime3());
			pstmt.setInt(8, board.getsTime4());
			pstmt.setString(9, board.getsFile());

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
	
	public ArrayList<SearchBean> getBoardList(int pageNumber)
	{
		ArrayList<SearchBean> list = new ArrayList<SearchBean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM SEARCH WHERE sId < ? ORDER BY sId DESC LIMIT 9";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, getSeq() - (pageNumber -1) * 10);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				SearchBean board = new SearchBean();
				board.setsId(rs.getInt("sId"));
				board.setsTitle(rs.getString("sTitle"));
				board.setsContent(rs.getString("sContent"));
				board.setsAddress(rs.getString("sAddress"));
				board.setsTime1(rs.getInt("sTime1"));
				board.setsTime2(rs.getInt("sTime2"));
				board.setsTime3(rs.getInt("sTime3"));
				board.setsTime4(rs.getInt("sTime4"));
				board.setsFile(rs.getString("sFile"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return list;
	} // end getBoardList
	
	public boolean nextPage(int pageNumber) {
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM SEARCH WHERE sId < ? ORDER BY sId DESC LIMIT 9";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, getSeq() - (pageNumber -1) * 10);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return false;
	}
	
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
