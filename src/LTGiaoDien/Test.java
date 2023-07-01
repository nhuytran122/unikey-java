package LTGiaoDien;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Hang> ds = new ArrayList<Hang>();
		Hang h1=new Hang();
		h1.setTenhang("dau");
		h1.setGia(2000);
		ds.add(h1);
		System.out.println(h1.toString());
		Hang h2=new Hang("xang",200000);
		System.out.println(h2.toString());
		ds.add(h2);
		System.out.println("in hang tu mang ");
		for(Hang h:ds)
			System.out.println(h.toString());
	}
}

