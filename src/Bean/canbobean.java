package Bean;

public class canbobean {
	private String macb;
	private String hoten;
	private Double hsl;
	public canbobean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public canbobean(String macb, String hoten, Double hsl) {
		super();
		this.macb = macb;
		this.hoten = hoten;
		this.hsl = hsl;
	}
	public String getMacb() {
		return macb;
	}
	public void setMacb(String macb) {
		this.macb = macb;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public double getHsl() {
		return hsl;
	}
	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}
	@Override
	public String toString() {
		return "canbobean [macb=" + macb + ", hoten=" + hoten + ", hsl=" + hsl + "]";
	}
	
	public double tinhluong() {
		return this.hsl*1300;
	}
}
