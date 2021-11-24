package member.vo;

public class MemberVo {
	// Field
	private String memid;
	private String mempass;
	private String memname;
	private String email;
	private String rdate;
	
	// Constructor
	public MemberVo() {}
	public MemberVo(String memid, String mempass, String memname, String email, String rdate) {
		this.memid = memid;
		this.mempass = mempass;
		this.memname = memname;
		this.email = email;
		this.rdate = rdate;
	}
	
	// Getter / Setter
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMempass() {
		return mempass;
	}
	public void setMempass(String mempass) {
		this.mempass = mempass;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	//  method
	public String toXML() {
		String  fmt  = "<member>";
	    fmt         += "  <memid>%s</memid>"; 
	    fmt         += "  <mempass>%s</mempass>";
	    fmt         += "  <memname>%s</memname>"; 
	    fmt         += "  <email>%s</email>";
	    fmt         += "  <rdate>%s</rdate>";
		fmt         += "</member>";
		
		String  xml = String.format(fmt,
				memid, mempass, memname, email, rdate);
		return  xml;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberVo [memid=" + memid + ", mempass=" + mempass + ", memname=" + memname + ", email=" + email
				+ ", rdate=" + rdate + "]";
	}
	
}









