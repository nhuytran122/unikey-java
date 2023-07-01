package Bean;

public class Xebean {
	private String soCmnd;
	private String hoten;
	private boolean gioitinh;
	private String masocanho;
	private String mauSon;
	public Xebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xebean(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon) {
		super();
		this.soCmnd = soCmnd;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.masocanho = masocanho;
		this.mauSon = mauSon;
	}
	public long tinhtien() {
		return 0;
	}
	public String getSoCmnd() {
		return soCmnd;
	}
	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getMasocanho() {
		return masocanho;
	}
	public void setMasocanho(String masocanho) {
		this.masocanho = masocanho;
	}
	public String getMauSon() {
		return mauSon;
	}
	public void setMauSon(String mauSon) {
		this.mauSon = mauSon;
	}
	@Override
	public String toString() {
		return "Xebean [soCmnd=" + soCmnd + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", masocanho=" + masocanho
				+ ", mauSon=" + mauSon + "]";
	}
	
}