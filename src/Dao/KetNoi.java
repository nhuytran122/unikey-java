package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public static Connection cn;
	public void ketnoi() throws Exception{
		//B1: Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		//B2: Ket Noi
		String url = "jdbc:sqlserver://LAPTOP-RVNJVG29\\SQLEXPRESSE:1433; databaseName=qlnv; user=sa; password=12345";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	public static void main(String[] args) {
		try {
			KetNoi kn=new KetNoi();
			kn.ketnoi();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
