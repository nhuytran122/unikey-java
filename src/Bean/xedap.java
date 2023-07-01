package Bean;

import java.util.Date;

public class xedap extends xe2Banh
{
	private String sovexe;
	
	public xedap() {
		super();
	}
	public xedap(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon, Date thoigianvao,
			Date thoigianra) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon, thoigianvao, thoigianra);
		// TODO Auto-generated constructor stub
	}

	public xedap(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon);
		// TODO Auto-generated constructor stub
	}

	public xedap(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon,Date thoigianvao, Date thoigianra, String sovexe) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon,thoigianvao,thoigianra);
		this.sovexe = sovexe;
	}

	public String getSovexe() {
		return sovexe;
	}

	public void setSovexe(String sovexe) {
		this.sovexe = sovexe;
	}

	@Override
	public String toString() {
		super.toString();
		return "xedap [sovexe=" + sovexe + "]";
	}
	
}
