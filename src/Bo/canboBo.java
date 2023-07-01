package Bo;

import java.util.ArrayList;

import Bean.canbobean;
import Dao.canboDao;

public class canboBo {
	ArrayList<canbobean> ds;
	public ArrayList<canbobean> getcb() throws Exception{
		canboDao cbDao=new canboDao();
		ds=cbDao.getcb();
		return ds;
	}
	public boolean TimCanbo(String key) {
		for(canbobean cb:ds) {
			if(cb.getHoten().equals(key)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<canbobean> xoa(String ma){
		for(canbobean cb:ds) {
			if(cb.getMacb().equals(ma)) {
				ds.remove(cb);
			}
		}
		return ds;
	}
	public double tongLuong() {
		double tong=0;
		for(canbobean cb:ds) {
			tong+=cb.tinhluong();
		}
		return tong;
	}
	public ArrayList<canbobean> them(String ma,String hoten,Double hsl) throws Exception{
		for(canbobean cb:ds) {
			if(cb.getMacb().equals(ma))
				return null;
		}
//		canbobean cbbean=new canbobean(ma, hoten, hsl);
		ds.add(new canbobean(ma, hoten, hsl));
		return ds;
	}
}
