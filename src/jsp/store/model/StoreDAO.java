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
//			dataSource = (DataSource) context.lookup("jdbc/napochoo1");
			dataSource = (DataSource) context.lookup("jdbc/makeStore");
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSeq() {
		
		String SQL = "SELECT eId FROM STORE ORDER BY eId DESC";
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
			sql.append("INSERT INTO STORE");
			sql.append("(eId, eTitle, eContent, eAddress, eTime1, eTime2, eTime3, eTime4, eFile)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.geteId());
			pstmt.setString(2, board.geteTitle());
			pstmt.setString(3, board.geteContent());
			pstmt.setString(4, board.geteAddress());
			pstmt.setString(5, board.geteTime1());
			pstmt.setString(6, board.geteTime2());
			pstmt.setString(7, board.geteTime3());
			pstmt.setString(8, board.geteTime4());
			pstmt.setString(9, board.geteFile());

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
	

	public ArrayList<StoreBean> getBoardList()
	{
		ArrayList<StoreBean> list = new ArrayList<StoreBean>();
		
		try {
			conn = dataSource.getConnection();
			
			String SQL = "SELECT * FROM STORE";
			// 글목록 전체를 보여줄 때
				pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
			while(rs.next())
			{
				StoreBean board = new StoreBean();
				board.seteId(rs.getInt("eId"));
				board.seteTitle(rs.getString("eTitle"));
				board.seteContent(rs.getString("eContent"));
				board.seteAddress(rs.getString("eAddress"));
				board.seteTime1(rs.getString("eTime1"));
				board.seteTime2(rs.getString("eTime2"));
				board.seteTime3(rs.getString("eTime3"));
				board.seteTime4(rs.getString("eTime4"));
				board.seteFile(rs.getString("eFile"));
				
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
