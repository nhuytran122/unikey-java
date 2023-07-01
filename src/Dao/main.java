package Dao;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Bean.hotensinhvien;
import Bean.tinA;
import Bean.tinB;
import Bean.hotensinhvien;
import Bean.tinA;
import Bean.tinB;
public class main{
	public static void main() {
		try {
			ArrayList<hotensinhvien> ds=new ArrayList<hotensinhvien>();
			FileReader f= new FileReader("ds.txt");
			BufferedReader br=new BufferedReader(f);
			FileOutputStream f1=new FileOutputStream("f1.txt");
			FileOutputStream f2=new FileOutputStream("f2.txt");
			OutputStreamWriter op1=new OutputStreamWriter(f1);
			OutputStreamWriter op2=new OutputStreamWriter(f2);
			PrintWriter w1=new PrintWriter(op1);
			PrintWriter w2=new PrintWriter(op2);
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
					System.out.println(diemtb+"    "+diemwin+"   "+DiemWord);
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
			System.out.println("danh sach sinh vien");
			for(hotensinhvien ht:ds) {
				ht.toString();
				}
			System.out.println("nhap ho ten sinh vien muon hien thi");
			Scanner sc=new Scanner(System.in);
			String ten=sc.nextLine();
			for(hotensinhvien ht:ds) {
				if(ht.getHoten().toLowerCase().trim().contains(ten.toLowerCase().trim()) ) {
					ht.toString();
				}
			}
			for(hotensinhvien ht:ds) {
				if(ht instanceof tinA) {
					w1.println(ht.getMasv()+";"+ht.getHoten()+";"+ht.getDiemTb());
				}
				if( ht instanceof tinB) {
					w2.println(ht.getMasv()+";"+ht.getHoten()+";"+ht.getDiemTb());
				}
			}
			w1.close();
			w2.close();
			br.close();
			}catch (Exception e) {
				// TODO: handle exception
			}}}

	

