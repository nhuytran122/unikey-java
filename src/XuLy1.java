import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.Scanner;
import java.util.regex.Pattern;

public class XuLy1 {
    public boolean KtNgay(String ngay) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyy");
            f.setLenient(false);
            f.parse(ngay);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean KtSdt(String sdt) {

        String mau = "[0][\\d]{9,10}";

        return Pattern.matches(mau, sdt);

    }

    public boolean KtEmail(String email) {

        String mau = "[\\w]+@[\\w]+.[\\w]+.[\\w]{0,}";

        return Pattern.matches(mau, email);

    }
}
