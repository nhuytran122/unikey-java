import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class KtMain1 {
    public static void main(String[] agr) {
        ArrayList<String> ds = new ArrayList<String>();
        try {
            FileOutputStream file = new FileOutputStream("kt.txt");
            OutputStreamWriter o = new OutputStreamWriter(file);
            PrintWriter w = new PrintWriter(o);
            FileInputStream f = new FileInputStream("cb.txt");
            InputStreamReader ir = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(ir);
            int dem = 1;
            while (true) {
                String st = b.readLine();
                if (st == "" || st == null)
                    break;
                ds.add(st);
            }
            for (String tt : ds) {
                KiemTra1 kt = new KiemTra1();
                String[] ar = tt.split("[;]");
                w.print("dong " + dem + " :");
                System.out.println(dem);
                dem++;
                if (kt.ktmacb(ar[0])) {
                } else {
                    System.out.println("loi ma can bo");
                    w.print("loi ma can bo;");
                }
                if (kt.ktrNgay(ar[2])) {
                } else {
                    System.out.println("loi kiem tra ngay;");
                    w.print("loi kiem tra ngay;");
                }
                if (kt.KtEmail(ar[3])) {
                } else {
                    System.out.println("loi kiem tra email;");
                    w.print("loi kiem tra email;");
                }
                if (kt.KtSdt(ar[4])) {

                } else {
                    System.out.println("loi kiem tra so dth");
                    w.print("loi kiem tra so dien thoai;");
                }
                if (kt.ktraTen(ar[5])) {

                } else {
                    System.out.println("loi kiem tra ten");
                    w.print("loi kiem tra ten ;");
                }
                if (kt.Ktradiem(ar[7])) {

                } else {
                    System.out.println("loi kiem tra diem");
                    w.print("loi kiem tra diem");
                }
                w.print("\n");

            }
            b.close();
            w.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
