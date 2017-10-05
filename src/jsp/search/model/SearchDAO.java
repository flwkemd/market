package jsp.search.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
//			dataSource = (DataSource) context.lookup("jdbc/napochoo1");
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
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally{
				try{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			} 
		}
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
			pstmt.setString(5, board.getsTime1());
			pstmt.setString(6, board.getsTime2());
			pstmt.setString(7, board.getsTime3());
			pstmt.setString(8, board.getsTime4());
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
	
	public ArrayList<SearchBean> searchBoard(String word){
		ArrayList<SearchBean> dtos = new ArrayList<SearchBean>();
		try{
			conn = dataSource.getConnection();
			 
				String SQL = "select * from (select * from SEARCH where sId < ? order by sId desc)CNT where sContent like ? LIMIT 1000";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, 100);
				pstmt.setString(2, "%"+word+"%");

				rs = pstmt.executeQuery();
			
			while(rs.next()){
				int sId = rs.getInt("sId");
				String sTitle = rs.getString("sTitle");
				String sContent = rs.getString("sContent");
				String sAddress = rs.getString("sAddress");
				String sTime1 = rs.getString("sTime1");
				String sTime2 = rs.getString("sTime2");
				String sTime3 = rs.getString("sTime3");
				String sTime4 = rs.getString("sTime4");
				String sFile = rs.getString("sFile");
				
				SearchBean dto = new SearchBean(sId, sTitle, sContent, sAddress, sTime1, sTime2, sTime3, sTime4, sFile);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
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
