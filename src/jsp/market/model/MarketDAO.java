package jsp.market.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MarketDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource dataSource;
	
	public MarketDAO() {
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
		
		String SQL = "SELECT mId FROM MARKET ORDER BY mId DESC";
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
		
		int start = 1;
		
		try {
			conn = dataSource.getConnection();
			String SQL = "SELECT * FROM MARKET WHERE mId >= ? ORDER BY mId DESC LIMIT 3";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start);
			
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
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return list;
	} // end getBoardList
	
	// 글의 개수를 가져오는 메서드
		public int getBoardListCount()
		{
			int result = 0;
			
			try {
				conn = dataSource.getConnection();
				StringBuffer sql = new StringBuffer();
				
					sql.append("select count(*) from MARKET");
					pstmt = conn.prepareStatement(sql.toString());
					
					// StringBuffer를 비운다.
					sql.delete(0, sql.toString().length());
					
				rs = pstmt.executeQuery();
				if(rs.next())	result = rs.getInt(1);
				
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			
			close();
			return result;
		} // end getBoardListCount
	
	
	
	
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
