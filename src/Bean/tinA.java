package Bean;

public class tinA extends hotensinhvien {
	private float diemWin;
	private float diemWord;
	
	
	public tinA() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public tinA(String masv, String hoten, float diemTb) {
//		super(masv, hoten, diemTb);
//		// TODO Auto-generated constructor stub
//	}
	public tinA(String masv, String hoten, float diemTb,float diemWin, float diemWord) {
		super(masv, hoten, diemTb);
		this.diemWin = diemWin;
		this.diemWord = diemWord;
	}
	public float getDiemWin() {
		return diemWin;
	}
	public void setDiemWin(float diemWin) {
		this.diemWin = diemWin;
	}
	public float getDiemWord() {
		return diemWord;
	}
	public void setDiemWord(float diemWord) {
		this.diemWord = diemWord;
	}
	public float diemtb() {
		return (diemWin+diemWord)/2;
	}
	@Override
	public String toString() {
		System.out.println(super.toString());
		return "tinA [diemWin=" + diemWin + ", diemWord=" + diemWord + "]";
	}
	
}
