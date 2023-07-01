package Bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.nhanvienbean;
import Dao.nhanviendao;

public class nhanvienbo {
	nhanviendao nvdao=new nhanviendao();
	ArrayList<nhanvienbean>ds;
	public ArrayList<nhanvienbean> getnv() throws Exception{
		ds=nvdao.getnv();
		return ds;
	}
//	public ArrayList<nhanvienbean> them(String manv,String hoten,Date ngaysinh,Double hsl,String madv) throws Exception{
//		for(nhanvienbean nv:ds) {
//			if(nv.getManv().equals(madv))//kiem tra trung ma
//				return null;
//		}
//		ds.add(new nhanvienbean(manv, hoten, ngaysinh, hsl, madv));
//		return ds;
//	}
//	public ArrayList<nhanvienbean> xoa(String manv)throws Exception{
//		for(nhanvienbean nv:ds) {
//			if(nv.getManv().equals(manv)) {
//				ds.remove(nv);
//				break;
//					}
//		}
//		return ds;
//	}
	public int Them(String manv, String hoten, Date ngaysinh, Double hsl, String madv) {
		  //Kiem tra trung ma
		  for(nhanvienbean nv: ds)
			  if(nv.getManv().equals(manv))
				  return 0;
		  //Them vao bo nho: mang ds
		  ds.add(new nhanvienbean(manv, hoten, ngaysinh, hsl, madv));
		  //Them vao csdl
		  return  nvdao.Them(manv, hoten, ngaysinh, hsl, madv);
		  }
		  public int Xoa(String manv) {
		  int kq=0;
		  for(nhanvienbean nv: ds)
		  if(nv.getManv().equals(manv)) {
		  ds.remove(nv);//Xoa trong mang
		  kq=nvdao.Xoa(manv);//Xoa trong csdl
		  break;
		  }
		  return kq;
		  }
		  public int Sua(String manv, String hoten, Date ngaysinh, Double hsl, String madv) {
		  int n=ds.size();
		  int kq=0;
		  for(int i=0;i<n;i++) {
		  nhanvienbean nv=ds.get(i);
		  if(nv.getManv().equals(manv)) {
		  nv.setHoten(hoten);
		  nv.setNgaysinh(ngaysinh);
		  nv.setHsl(hsl);
		  nv.setMadv(madv);
		  ds.set(i, nv);//Sua trong mang
		  //Sua trong csdl
		  kq= nvdao.Sua(manv, hoten, ngaysinh, hsl, madv);
		  }
		  }
		  return kq;
		  }
		  public void NapFile() throws Exception{
		//Mo file
		FileReader f= new FileReader("nhanvien.txt");
		BufferedReader b= new BufferedReader(f);
		while(true) {
		String st=b.readLine();
		//nv1;Nguyen Thanh Nam;20/10/1999;3.5;dv1
		if(st==null||st=="") 
			break;
		String[] t=st.split("[;]");
		String manv=t[0];
		String hoten=t[1];
		SimpleDateFormat d= new SimpleDateFormat("dd/MM/yyyy");
		Date ngaysinh=d.parse(t[2]) ;
		Double hsl=Double.parseDouble(t[3]);
		String madv=t[4];
		Them(manv, hoten, ngaysinh, hsl, madv);
		}
		b.close();
		ds=nvdao.getnv();
		  }
		  public ArrayList<nhanvienbean> TimMa(String madv) throws Exception{

			  ArrayList<nhanvienbean> tam=new ArrayList<nhanvienbean>();

			  for(nhanvienbean nv: ds)

			  if(nv.getMadv().equals(madv)) {

			tam.add(nv);

			  }

			  return tam;

			  }

			  public ArrayList<nhanvienbean> Tim(String key) throws Exception{

			  ArrayList<nhanvienbean> tam=new ArrayList<nhanvienbean>();

			  for(nhanvienbean nv: ds)

			  if(nv.getManv().toLowerCase().contains(key.toLowerCase()) ||

			  nv.getHoten().toLowerCase().contains(key.toLowerCase())){

			tam.add(nv);

			  }

			  return tam;

			  }
}

