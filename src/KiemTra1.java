
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

public class KiemTra1 {
    public ArrayList<String> DsCanbo = new ArrayList<String>();

    public void thietlapmang() {
        try {
            FileInputStream f = new FileInputStream("cb.txt");
            InputStreamReader ir = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(ir);
            while (true) {
                String st = b.readLine();
                if (st == "" || st == null)
                    break;
                DsCanbo.add(st);        
            }
            b.close();
        } catch (Exception e) {
            System.out.println("loi o ham thiet lap" + e.getMessage());
        }
    }

    public boolean ktmacb(String macb) {
        String bt = "[\\D][\\w]{1,}";
        return Pattern.matches(bt, macb);
    }

    public boolean ktrNgay(String ngay) {
        XuLy1 x = new XuLy1();
        try {
            if (x.KtNgay(ngay))
                return true;
            else
                return false;
        } catch (Exception e) {
            System.out.println("loi ow han kiem tra ngay" + e.getMessage());
            return false;
        }
    }

    public boolean KtEmail(String em) {
        XuLy1 x = new XuLy1();
        try {
            if (x.KtEmail(em)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("loi o ham kiem tra email:" + e.getMessage());
            return false;
        }
    }

    public boolean KtSdt(String sdt) {
        XuLy1 x = new XuLy1();
        try {
            if (x.KtSdt(sdt)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("loi o ham kiem tra so dien thoai:   " + e.getMessage());
            return false;
        }

    }

    public boolean ktraTen(String macb) {
        String t = "[\\D][\\w]{1,}";
        return Pattern.matches(t, macb);
    }
    public boolean ktramk(String a,String b) {
    	if(a==b)
    		return true;
    	else 
    		return false;
    }
    public boolean Ktradiem(String diem) {
        try {
            float a = Float.parseFloat(diem);
            if (Math.ceil(a) != Math.floor(a) || Math.ceil(a) == Math.floor(a))
                return true;
            else
                return false;

        } catch (Exception e) {
            return false;
        }
    }
}
