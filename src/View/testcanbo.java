package View;

import java.util.ArrayList;

import Bean.canbobean;
import Bo.canboBo;

public class testcanbo {
	public static void main(String[] args) {
		ArrayList<canbobean>ds;
		canboBo cbbo=new canboBo();
		try {
			ds=cbbo.getcb();	
			for(canbobean cb:ds) {
				cb.toString();
			}
		} catch (Exception e) {
			System.out.println("loi"+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
