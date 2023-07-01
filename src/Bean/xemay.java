package Bean;

import java.util.Date;

public class xemay extends xe2Banh{
	private String bienso;
	private String hangsx;
	public xemay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xemay(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon);
		// TODO Auto-generated constructor stub
	}
	public xemay(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon,Date thoigianvao, Date thoigianra, String bienso,
			String hangsx) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon,thoigianvao,thoigianra);
		this.bienso = bienso;
		this.hangsx = hangsx;
	}
	public String getBienso() {
		return bienso;
	}
	public void setBienso(String bienso) {
		this.bienso = bienso;
	}
	public String getHangsx() {
		return hangsx;
	}
	public void setHangsx(String hangsx) {
		this.hangsx = hangsx;
	}
	@Override
	public String toString() {
		super.toString();
		return "xemay [bienso=" + bienso + ", hangsx=" + hangsx + "]";
	}
	
	
	
	
}
