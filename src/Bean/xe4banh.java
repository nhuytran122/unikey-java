package Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class xe4banh extends Xebean{
	private String bienso;
	private String hangSx;
	private Date thoigianvao;
	private Date thoigianra;
	private String tinhtrangvao;
	private String tinhtrangra;
	public xe4banh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xe4banh(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon) {
		super(soCmnd, hoten, gioitinh, masocanho, mauSon);
		// TODO Auto-generated constructor stub
	}
	public xe4banh(String soCmnd, String hoten, boolean gioitinh, String masocanho, String mauSon,String bienso, String hangSx, Date thoigianvao, Date thoigianra, String tinhtrangvao,
			String tinhtrangra) {
		super(soCmnd,hoten,gioitinh,masocanho,mauSon);
		this.bienso = bienso;
		this.hangSx = hangSx;
		this.thoigianvao = thoigianvao;
		this.thoigianra = thoigianra;
		this.tinhtrangvao = tinhtrangvao;
		this.tinhtrangra = tinhtrangra;
	}
	public long tinhtien() {
		SimpleDateFormat fm=new SimpleDateFormat("hh:mm dd/MM/yyyy");
		long timeVao=this.thoigianvao.getTime();
		long timeRa=this.thoigianra.getTime();
		long hieu=timeRa-timeVao;
		long dem=hieu/1800;
		if(hieu%1800!=0) {
			dem=dem+1;
		}
		long thanhtien=dem*5000;
		return thanhtien;
	}
	public String getBienso() {
		return bienso;
	}
	public void setBienso(String bienso) {
		this.bienso = bienso;
	}
	public String getHangSx() {
		return hangSx;
	}
	public void setHangSx(String hangSx) {
		this.hangSx = hangSx;
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
	public String getTinhtrangvao() {
		return tinhtrangvao;
	}
	public void setTinhtrangvao(String tinhtrangvao) {
		this.tinhtrangvao = tinhtrangvao;
	}
	public String getTinhtrangra() {
		return tinhtrangra;
	}
	public void setTinhtrangra(String tinhtrangra) {
		this.tinhtrangra = tinhtrangra;
	}
	@Override
	public String toString() {
		super.toString();
		return "xe4banh [bienso=" + bienso + ", hangSx=" + hangSx + ", thoigianvao=" + thoigianvao + ", thoigianra="
				+ thoigianra + ", tinhtrangvao=" + tinhtrangvao + ", tinhtrangra=" + tinhtrangra + "]";
	}
	
	

}
