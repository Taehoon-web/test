package post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;
import post.vo.PostVo;

public class PostDao {
	
	private  Connection         conn  = null;
	private  PreparedStatement  pstmt = null;
	
	public  List<PostVo>  getPostList( String indong ) {
		
		List<PostVo> postList = new ArrayList<PostVo>();
		
		ResultSet   rs = null;
		
		try {
			DBConn  db   =  new DBConn();
			conn         =  db.getConnection();
			String  sql  =  "SELECT      ZIPCODE, SIDO, GUGUN, DONG, ";
			sql   		+=  "NVL(BUNJI, ' ') BUNJI, SEQ";
			sql 		+=  " FROM       ZIPCODE";
			sql         +=  " WHERE      DONG   LIKE  ? ";
			sql		    +=  " ORDER  BY  SEQ ASC";
			pstmt        =  conn.prepareStatement(sql);
			pstmt.setString(1, "%" + indong.trim() + "%");
			
			rs  = pstmt.executeQuery();
			while(rs.next()) {
				String  zipcode  =  rs.getString("zipcode"); 
				String  sido     =  rs.getString("sido"); 
				String  gugun    =  rs.getString("gugun"); 
				String  dong     =  rs.getString("dong"); 
				String  bunji    =  rs.getString("bunji"); 
				int     seq      =  rs.getInt("seq"); 
				PostVo  postVo   =  new PostVo(
					zipcode, sido, gugun, dong, bunji, seq);
				
				postList.add( postVo );
			}					
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
			}			
		}
		return postList; 
	} 
}


















