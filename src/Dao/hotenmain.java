package Dao;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Bean.hotensinhvien;
import Bean.tinA;
import Bean.tinB;

public class hotenmain {
	public static void main(String[] args){
		try {
			FileOutputStream f1=new FileOutputStream("f1.txt");
			FileOutputStream f2=new FileOutputStream("f2.txt");
			OutputStreamWriter op1=new OutputStreamWriter(f1);
			OutputStreamWriter op2=new OutputStreamWriter(f2);
			PrintWriter w1=new PrintWriter(op1);
			PrintWriter w2=new PrintWriter(op2);
			ArrayList<hotensinhvien> ds;
			hotensinhvienDao sv=new hotensinhvienDao();
			ds=sv.gethocsinh(); //mot danh sach gom tin A tin B
			System.out.println("danh sach sinh vien hoc tin A");
			for(hotensinhvien ht:ds) {
				if(ht instanceof tinA) {
					System.out.println(ht);
				}
				}
			System.out.println("danh sach hoc vien tin B");
			for(hotensinhvien ht:ds) {
				if(ht instanceof tinB) {
					System.out.println(ht);
;				}
			}
			System.out.println("nhap ho ten sinh vien muon hien thi");
			Scanner sc=new Scanner(System.in);
			String ten=sc.nextLine();
			int dem=0;
			for(hotensinhvien ht:ds) {
				if(ht.getHoten().toLowerCase().trim().contains(ten.toLowerCase().trim()) ) {
					System.out.println(ht);
					dem=1;
				}
			}
			if(dem==0)
				System.out.println("khong tim thay!");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
