package lala.com.a.model;

import java.io.Serializable;

public class OrderedDto implements Serializable {

	private int seq;
	private String oid;
	private String oname;
	private String ophone;
	private String oaddress;
	private String odate;
	private int otprice;
	private String omid;
	
	public OrderedDto() {}

	public OrderedDto(int seq, String oid, String oname, String ophone, String oaddress, String odate, int otprice,
			String omid) {
		super();
		this.seq = seq;
		this.oid = oid;
		this.oname = oname;
		this.ophone = ophone;
		this.oaddress = oaddress;
		this.odate = odate;
		this.otprice = otprice;
		this.omid = omid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public String getOaddress() {
		return oaddress;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public int getOtprice() {
		return otprice;
	}

	public void setOtprice(int otprice) {
		this.otprice = otprice;
	}

	public String getOmid() {
		return omid;
	}

	public void setOmid(String omid) {
		this.omid = omid;
	}

	@Override
	public String toString() {
		return "OrderedDto [seq=" + seq + ", oid=" + oid + ", oname=" + oname + ", ophone=" + ophone + ", oaddress="
				+ oaddress + ", odate=" + odate + ", otprice=" + otprice + ", omid=" + omid + "]";
	}
}
