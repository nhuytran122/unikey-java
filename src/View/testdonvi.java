package View;

import java.util.ArrayList;

import Bean.donvibean;
import Bo.donvido;

public class testdonvi{
	public static void main(String[] args) {
		ArrayList<donvibean>ds;
		donvido dvbo=new donvido();
		try {
			ds=dvbo.getdv();	
			for(donvibean cb:ds) {
				cb.toString();
			}
		} catch (Exception e) {
			System.out.println("loi"+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
}
