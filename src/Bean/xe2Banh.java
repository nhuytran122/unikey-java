package Bean;

import java.util.Date;

public class xe2Banh extends Xebean {
	private Date thoigianvao;
	private Date thoigianra;
	public xe2Banh() {
		super();
	}
	public xe2Banh(String soCmnd,String hoten,boolean gioitinh,String masocanbo,String mauSon) {
		super(soCmnd, hoten, gioitinh,masocanbo, mauSon);
		// TODO Auto-generated constructor stub
	}
	
	public xe2Banh(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon,Date thoigianvao, Date thoigianra) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon);
		this.thoigianvao = thoigianvao;
		this.thoigianra = thoigianra;
	}
	public Date getThoigianvao() {
		return thoigianvao;
	}
	public void setThoigianvao(Date thoigianvao) {
		this.thoigianvao = thoigianvao;
	}
	public Date getThoigianra() {
		return thoigianra;
	}
	public void setThoigianra(Date thoigianra) {
		this.thoigianra = thoigianra;
	}
	@Override
	public String toString() {
		super.toString();
		return "xe2Banh [thoigianvao=" + thoigianvao + ", thoigianra=" + thoigianra + "]";
	}
	
}
