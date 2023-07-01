package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Bean.canbobean;

public class canboDao {
	public ArrayList<canbobean> getcb() throws Exception{
		ArrayList<canbobean> ds=new ArrayList<canbobean>();
		FileReader f=new FileReader("cb.txt");
		BufferedReader bf= new BufferedReader(f);
		while(true) {
			String st=bf.readLine();
			if(st==""||st==null)
				break;
			String[] tt=st.split("[,]");
			canbobean cb=new canbobean(tt[0], tt[1], Double.parseDouble(tt[2]));
			ds.add(cb);
		}
		return ds;
		
	}
}
