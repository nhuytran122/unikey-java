package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.donvibean;
import Bean.nhanvienbean;

public class nhanviendao {
	public ArrayList<nhanvienbean> getnv() throws Exception{

		ArrayList<nhanvienbean> ds= new ArrayList<nhanvienbean>();

		//b1: Ket noi vao csdl

		KetNoi kn= new KetNoi();

		kn.ketnoi();

		//B2: Tao cau lenh sql

		String sql="select * from nhanvien";

		//B3: tao cau lenh

		PreparedStatement cmd=kn.cn.prepareStatement(sql);

		//b4: Thuc hien cau lenh

		ResultSet rs= cmd.executeQuery();

		//b5: Duyet qua rs

		while(rs.next()) {

		//String manv, String hoten, Date ngaysinh, Double hsl, String madv

		 

		String manv=rs.getString("manv");

		String hoten=rs.getString("hoten");

		Double hsl=rs.getDouble("hsl");

		Date ns=rs.getDate("ngaysinh");

		SimpleDateFormat d= new SimpleDateFormat("dd/MM/yyyy");

		String ngaysinh=d.format(ns);

		String madv=rs.getString("madv");

		ds.add(new nhanvienbean(manv, hoten, ns, hsl, madv));

		} 

		rs.close();

		return ds;

		}

		public int Them(String manv, String hoten, Date ngaysinh, Double hsl, String madv) {

		try {

		 

		//b1: Ket noi vao csdl

		KetNoi kn= new KetNoi();

		kn.ketnoi();

		//B2: Tao cau lenh sql

		String sql=

		"insert into nhanvien(manv,hoten,ngaysinh,hsl,madv) values(?,?,?,?,?)";

		//B3: tao cau lenh

		PreparedStatement cmd=kn.cn.prepareStatement(sql);

		cmd.setString(1, manv);

		cmd.setString(2, hoten);

		cmd.setDate(3, new java.sql.Date(ngaysinh.getTime()));

		cmd.setDouble(4, hsl);

		cmd.setString(5, madv);

		int kq= cmd.executeUpdate();

		kn.cn.close();

		return kq;

		} catch (Exception e) {

		e.printStackTrace();

		return 0;

		}

		}

		public int Xoa(String manv) {

		try {

		 

		//b1: Ket noi vao csdl

		KetNoi kn= new KetNoi();

		kn.ketnoi();

		//B2: Tao cau lenh sql

		String sql="delete from nhanvien where manv=?";

		//B3: tao cau lenh

		PreparedStatement cmd=kn.cn.prepareStatement(sql);

		cmd.setString(1, manv);

		//b4: Thuc hien cau lenh

		int kq= cmd.executeUpdate();

		kn.cn.close();

		return kq;

		} catch (Exception e) {

		e.printStackTrace();

		return 0;

		}

		}

		public int Sua(String manv, String hoten, Date ngaysinh, Double hsl, String madv) {

		try {

		 

		//b1: Ket noi vao csdl

		KetNoi kn= new KetNoi();

		kn.ketnoi();

		//B2: Tao cau lenh sql

		String sql="update nhanvien set hoten=?,ngaysinh=?,hsl=?, madv=? where manv=?";

		//B3: tao cau lenh

		PreparedStatement cmd=kn.cn.prepareStatement(sql);

		cmd.setString(5, manv);

		cmd.setString(1, hoten);

		cmd.setDate(2, new java.sql.Date(ngaysinh.getTime()));

		cmd.setDouble(3, hsl);

		cmd.setString(4, madv);

		//b4: Thuc hien cau lenh

		int kq= cmd.executeUpdate();

		kn.cn.close();

		return kq;

		} catch (Exception e) {

		e.printStackTrace();

		return 0;

		}

		}
//	public ArrayList<nhanvienbean> getnv() throws Exception{
//		//tao mot mang de luu tat ca cac don vi trong file donvi.txt
//		ArrayList<nhanvienbean> ds = new ArrayList<nhanvienbean>();
//		//mo file
//		FileReader f= new FileReader("nhanvien.txt");
//		BufferedReader b= new BufferedReader(f);
//		while(true) {
//			String st= b.readLine();
//			if(st==null || st=="") break;
//			String[] t= st.split("[;]");
//			String manv= t[0]; 
//			String hoten= t[1];
//			SimpleDateFormat dd= new SimpleDateFormat("dd/MM/yyyy");
//			Date ngaysinh = dd.parse(t[2]);
//			Double hsl = Double.parseDouble(t[3]);
//			String madv= t[4];
//			ds.add(new nhanvienbean(st, hoten, ngaysinh, hsl, madv));
//		}
//		b.close();
//		return ds;
//}
}