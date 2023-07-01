package Dao;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import Bean.xe4banh;
import Bean.xedap;
import Bean.xemay;
public class xeDao {
		public void luuFile() throws Exception{
		ArrayList<Object> ds=new ArrayList<Object>();
		FileReader f=new FileReader("input1.txt");
		BufferedReader br=new BufferedReader(f);
		FileOutputStream fo=new FileOutputStream("input2.txt");
		OutputStreamWriter ow=new OutputStreamWriter(fo);
		PrintWriter w=new PrintWriter(ow);
		SimpleDateFormat fm=new SimpleDateFormat("hh:mm dd/MM/yyyy");
		while(true) {
			String t=br.readLine();
			if(t==""||t==null)
				break;
			System.out.println(t);
			String[] tt=t.split("[;]");
			Date ngayvao=fm.parse(tt[3]);// chuyen String thanh date
			int check=Integer.parseInt(tt[0]);//chuyen String sang int
			if(check==4) {
				ArrayList<xe4banh> bonbanh=new ArrayList<xe4banh>();
				xe4banh oto=new xe4banh();
				oto.setBienso(tt[1]);
				oto.setThoigianvao(ngayvao);
				oto.setTinhtrangvao(tt[4]);
				ds.add(oto);
				System.out.println("thoi gian ra bai xe 4 banh co bien so: "+oto.getBienso() +"  [hh:mm dd/MM/yyyy]");
				Scanner sc=new Scanner(System.in);
				String ngayra=sc.nextLine();
				Date ra=fm.parse(ngayra);
				oto.setThoigianra(ra);
				System.out.println("nhap tinh trang ra:");
				String lucra=sc.nextLine();
				if(oto.getTinhtrangvao().equals(lucra)) {
					oto.setTinhtrangra("Binh thuong");
				}
				else {
					oto.setTinhtrangra(lucra);
				}
				bonbanh.add(oto);
				String ngayraa=fm.format(ra);
				w.println("4;"+oto.getBienso()+";Not Available;"+ngayraa+";"+oto.getTinhtrangra());
				System.out.println("da duyet xe oto");
			}
			if(check==2) {
				xemay xmay=new xemay();
				xmay.setBienso(tt[1]);
				xmay.setThoigianvao(ngayvao);
				ds.add(xmay);
				System.out.println("thoi gian ra bai xe may co bien so: "+xmay.getBienso() +"  [hh:mm dd/MM/yyyy]");
				Scanner sc=new Scanner(System.in);
				String ngayra=sc.nextLine();
				Date ra=fm.parse(ngayra);
				xmay.setThoigianra(ra);
				w.println("2;"+xmay.getBienso()+";"+"Not Available;"+fm.format(xmay.getThoigianra())+";Not Available");
				System.out.println("da duyet xe xe may");
				
			}
			if(check==0) {
				xedap xdap=new xedap();
				xdap.setSovexe(tt[2]);
				xdap.setThoigianvao(ngayvao);
				ds.add(xdap);
				System.out.println("thoi gian ra bai xe dap co so ve xe : "+xdap.getSovexe() +"  [hh:mm dd/MM/yyyy]");
				Scanner sc=new Scanner(System.in);
				String ngayra=sc.nextLine();
				Date ra=fm.parse(ngayra);
				xdap.setThoigianra(ra);
				w.println("0;"+"Not Available;"+xdap.getSovexe()+";"+fm.format(xdap.getThoigianra())+";Not Available");
				System.out.println("da duyet xe dap");
			}
		}
		br.close();
		w.close();
		System.out.println("da tao xong");
	}
}
