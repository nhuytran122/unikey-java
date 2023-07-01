package Bean;

public class hotensinhvien {
	private String masv;
	private String hoten;
	private float diemTb;
	
	
	public hotensinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hotensinhvien(String masv, String hoten,float diemTb) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.diemTb=diemTb;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
	public float getDiemTb() {
		return diemTb;
	}
	public void setDiemTb(float diemTb) {
		this.diemTb = diemTb;
	}
	@Override
	public String toString() {
		return "hotensinhvien [masv=" + masv + ", hoten=" + hoten + ", diemTb=" + diemTb + "]";
	}
	

}
