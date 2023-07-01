package Bo;

import java.util.ArrayList;

import Dao.donvidao;
import Bean.donvibean;


public class donvido {
	donvidao dvdao = new donvidao();
	ArrayList<donvibean> ds;
	public ArrayList<donvibean> getdv() throws Exception{
		ds = dvdao.getdv();
		return ds;		
	}
	public ArrayList<donvibean> Them(String madv, String tendv) throws Exception{
		//kiem tra trung ma
		for (donvibean dv:ds)
			if(dv.getMadv().equals(madv))
				return null;
		ds.add(new donvibean(madv, tendv));
		//them vao co so du lieu
		dvdao.Them(madv, tendv);
		return ds;
	}
	
	public ArrayList<donvibean> Xoa(String madv) throws Exception{
		for(donvibean dv: ds)
			if(dv.getMadv().equals(madv)) {
				ds.remove(dv); //xoa trong mang
				dvdao.Xoa(madv);//xoa trong co so du lieu
				break;
			}
		return ds;
	}
	
	public ArrayList<donvibean> Sua(String madv, String tendvmoi) throws Exception{

		  int n=ds.size();
		  for(int i=0;i<n;i++)
			  if(ds.get(i).getMadv().equals(madv)) {
				  donvibean dv=ds.get(i);
				  dv.setTendv(tendvmoi);
				  ds.set(i, dv);//Sua trong bo nho
				  dvdao.Sua(madv,tendvmoi);//Sua trong csdl

				  break;
		  }

		  return ds;
//la, nap file lai
		  }
	public void NapFile() throws Exception{
		dvdao.NapFile();
		ds=getdv();
	}
}