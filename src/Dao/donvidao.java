package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.donvibean;
public class donvidao {
public ArrayList<donvibean> getdv() throws Exception{
try {
ArrayList<donvibean> ds= new ArrayList<donvibean>();
//b1: Ket noi vao csdl
	KetNoi kn= new KetNoi();
	kn.ketnoi();
//B2: Tao cau lenh sql
	String sql="select * from donvi";
//B3: tao cau lenh
	PreparedStatement cmd=kn.cn.prepareStatement(sql);
//b4: Thuc hien cau lenh
	ResultSet rs= cmd.executeQuery();
//b5: Duyet qua rs
	while(rs.next()) {
		String madv=rs.getString("madv");
		String tendv=rs.getString("tendv");
		ds.add(new donvibean(madv, tendv));
}
	rs.close();
	kn.cn.close();
	return ds;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}

	}
	public int Them(String madv, String tendv) {
		try {
//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
//B2: Tao cau lenh sql
			String sql="insert into donvi(madv,tendv) values(?,?)";
//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, madv);
			cmd.setString(2, tendv);
//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoa(String madv) {
		try {
//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
//B2: Tao cau lenh sql
			String sql="delete from donvi where madv=?";
//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, madv);
//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int Sua(String madv, String tendvmoi) {
		try {
//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
//B2: Tao cau lenh sql
			String sql="update donvi set tendv=? where madv=?";
//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, tendvmoi);
			cmd.setString(2, madv);
//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
}
}
	public void NapFile() throws Exception{
		//Mo fil
		FileReader f= new FileReader("donvi.txt");
		BufferedReader b= new BufferedReader(f);
		while(true) {
		String st=b.readLine();
		if(st==null||st=="") break;
		String[] t=st.split("[;]");
		Them(t[0], t[1]);//Them vao csdl
		}
		b.close();
		}
}

//public class donvidao {
//	public ArrayList<donvibean> getdv() throws Exception{
////		//tao mot mang de luu tat ca cac don vi trong file donvi.txt
//		ArrayList<donvibean> ds = new ArrayList<donvibean>();
////		//mo file
////		FileReader f= new FileReader("donvi.txt");
////		BufferedReader b= new BufferedReader(f);
////		while(true) {
////			String st= b.readLine();
////			if(st==null || st=="") break;
////			String[] t= st.split("[;]");
////			String madv= t[0]; String tendv= t[1];
////			donvibean dv= new donvibean(madv,tendv);
////			ds.add(dv);
////		}
////		b.close();
//		return ds;
////	}
//}}