package Bean;

public class tinB extends hotensinhvien{
	private float DiemExcel;
	private float diemPp;
	private float diemWeb;
	public tinB() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public tinB(String masv, String hoten, float diemTb) {
//		super(masv, hoten, diemTb);
//		// TODO Auto-generated constructor stub
//	}
	public tinB(String masv, String hoten, float diemTb,float diemExcel, float diemPp, float diemWeb) {
		super(masv, hoten, diemTb);
		this.DiemExcel = diemExcel;
		this.diemPp = diemPp;
		this.diemWeb = diemWeb;
	}
	public float getDiemExcel() {
		return DiemExcel;
	}
	public void setDiemExcel(float diemExcel) {
		DiemExcel = diemExcel;
	}
	public float getDiemPp() {
		return diemPp;
	}

	public void setDiemPp(float diemPp) {
		this.diemPp = diemPp;
	}
	public float getDiemWeb() {
		return diemWeb;
	}
	public void setDiemWeb(float diemWeb) {
		this.diemWeb = diemWeb;
	}
	public float diemtb() {
		return (DiemExcel+diemPp+diemWeb)/3;
	}
	@Override
	public String toString() {
		System.out.println(super.toString());
		return "tinB [DiemExcel=" + DiemExcel + ", diemPp=" + diemPp + ", diemWeb=" + diemWeb + "]";
	}
	

}
