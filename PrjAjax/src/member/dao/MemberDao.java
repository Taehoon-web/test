package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;
import member.vo.MemberVo;

public class MemberDao {

	private  Connection         conn;
	private  PreparedStatement  pstmt;
	
	public MemberVo getMember(String memid) {
		
		ResultSet  rs       = null;
		MemberVo   memberVo = null;
		
		try {
			DBConn  db  =  new DBConn();
			conn        =  db.getConnection();
			String sql  =  "SELECT  MEMID, MEMPASS, MEMNAME, EMAIL, RDATE ";
			sql        +=  " FROM   AJAXMEMBER ";
			sql        +=  " WHERE  MEMID = ? ";
			
			pstmt       =  conn.prepareStatement(sql);
			pstmt.setString(1, memid);
			
			rs =  pstmt.executeQuery();
			if( rs.next() ) {
				String  mid       = rs.getString("memid");
				String  mempass   = rs.getString("mempass");
				String  memname   = rs.getString("memname");
				String  email     = rs.getString("email");
				String  rdate     = rs.getString("rdate");
				memberVo = new MemberVo(mid, mempass, memname, email, rdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null )  rs.close();
				if(pstmt != null )  pstmt.close();
				if(conn  != null )  conn.close();
			} catch (SQLException e) {
			}
		}
				
		return   memberVo;
	}

	public List<MemberVo> getMemberList() {
		
		ResultSet      rs         = null;
		List<MemberVo> memberList = new ArrayList<MemberVo>();
				
		try {
			DBConn    db   =  new DBConn();
			conn           =  db.getConnection();
			String    sql  =  "SELECT MEMID, MEMPASS, MEMNAME, EMAIL, RDATE ";
			sql           +=  " FROM  AJAXMEMBER ";
			pstmt          =  conn.prepareStatement(sql);
			
			rs       =  pstmt.executeQuery();
			while( rs.next() ) {
				String    memid      =  rs.getString( "memid" );
				String    mempass    =  rs.getString( "mempass" );
				String    memname    =  rs.getString( "memname" );
				String    email      =  rs.getString( "email" );
				String    rdate      =  rs.getString( "rdate" );
				MemberVo  memberVo   =  new MemberVo(
						memid, mempass, memname, email, rdate);
				
				memberList.add( memberVo  );		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null )  rs.close();
				if(pstmt != null )  pstmt.close();
				if(conn  != null )  conn.close();
			} catch (SQLException e) {
			}
		}

		return   memberList;
	}

}


















