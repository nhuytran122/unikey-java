package Dao;

public class xeDaomain {
	public static void main(String[] args) {
		try {
			xeDao xe=new xeDao();
			xe.luuFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
