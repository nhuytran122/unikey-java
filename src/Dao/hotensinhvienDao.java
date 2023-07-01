package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Bean.hotensinhvien;
import Bean.tinA;
import Bean.tinB;
public class hotensinhvienDao{
	public ArrayList<hotensinhvien> gethocsinh() throws Exception{
	ArrayList<hotensinhvien> ds=new ArrayList<hotensinhvien>();
	FileReader f= new FileReader("ds.txt");
	BufferedReader br=new BufferedReader(f);
	while(true) {	
		String t=br.readLine();
		if(t==null || t=="")
			break;
		String[]tt=t.split("[;]");
		int x=tt.length;
		if(x==4) {
			tinA tin=new tinA();
			tin.setMasv(tt[0]);
			tin.setHoten(tt[1]);
			tin.setDiemWin(Float.parseFloat(tt[2]));
			tin.setDiemWord(Float.parseFloat(tt[3]));
			tin.setDiemTb(tin.diemtb());
			float diemwin=Float.parseFloat(tt[2]);
			float DiemWord=Float.parseFloat(tt[3]);
			float diemtb=tin.diemtb();
			ds.add(new tinA(tt[0], tt[1], diemtb, diemwin, DiemWord));
		}
		if(x==5) {
			tinB tinb=new tinB();
			tinb.setMasv(tt[0]);
			tinb.setHoten(tt[1]);
			tinb.setDiemExcel(Float.parseFloat(tt[2]));
			tinb.setDiemPp(Float.parseFloat(tt[3]));
			tinb.setDiemWeb(Float.parseFloat(tt[4]));
			tinb.setDiemTb(tinb.diemtb());
			float DiemExcel=(Float.parseFloat(tt[2]));
			float DiemPp=(Float.parseFloat(tt[3]));
			float DiemWeb=(Float.parseFloat(tt[4]));
			float diemtb=tinb.diemtb();
			ds.add(new tinB(tt[0], tt[1], diemtb, DiemExcel, DiemPp, DiemWeb));
		}
	}
	br.close();
	return ds;
	}
	}
	

