
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.imageio.stream.FileCacheImageOutputStream;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class baitap extends JFrame {

	private JPanel contentPane;
	private JTextField txtMcb;
	private JTextField txtHoTen;
	private JTextField txtNgaysinh;
	private JTextField txtmail;
	private JTextField txtSDT;
	private JTextField txtHsl;
	private JTextField txtTenDn;
	private JTextField txtMk;
	private JTextField txtMk2;
	private JTextField txtThongTin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baitap frame = new baitap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public baitap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txt = new JLabel("Nhap ma can bo");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt.setBounds(33, 10, 129, 27);
		contentPane.add(txt);
		
		txtMcb = new JTextField();
		txtMcb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==27) {//esc
					txtMcb.setText("");
				}
			}
		});
		txtMcb.setBounds(213, 10, 209, 27);
		contentPane.add(txtMcb);
		txtMcb.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(213, 47, 209, 27);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel ht = new JLabel("Nhap ho ten");
		ht.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ht.setBounds(33, 47, 129, 27);
		contentPane.add(ht);
		
		JLabel em = new JLabel("Nhap email");
		em.setFont(new Font("Tahoma", Font.PLAIN, 14));
		em.setBounds(33, 128, 136, 27);
		contentPane.add(em);
		
		JLabel sdt = new JLabel("Nhap so dien thoai");
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sdt.setBounds(33, 165, 123, 27);
		contentPane.add(sdt);
		
		JLabel hsl = new JLabel("Nhap HSL");
		hsl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hsl.setBounds(33, 209, 129, 27);
		contentPane.add(hsl);
		
		txtNgaysinh = new JTextField();
		txtNgaysinh.setBounds(213, 84, 209, 27);
		contentPane.add(txtNgaysinh);
		txtNgaysinh.setColumns(10);
		
		txtmail = new JTextField();
		txtmail.setBounds(213, 128, 209, 27);
		contentPane.add(txtmail);
		txtmail.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(213, 169, 209, 27);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel dn = new JLabel("Nhap ten dang nhap");
		dn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dn.setBounds(33, 255, 136, 27);
		contentPane.add(dn);
		
		JLabel mk = new JLabel("Nhap mat khau");
		mk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mk.setBounds(33, 306, 123, 27);
		contentPane.add(mk);
		
		JLabel mk2 = new JLabel("Nhap lai mat khau");
		mk2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mk2.setBounds(33, 353, 136, 27);
		contentPane.add(mk2);
		
		JLabel ns = new JLabel("Nhap ngay sinh");
		ns.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ns.setBounds(33, 84, 129, 27);
		contentPane.add(ns);
		
		txtHsl = new JTextField();
		txtHsl.setBounds(213, 209, 209, 27);
		contentPane.add(txtHsl);
		txtHsl.setColumns(10);
		
		txtTenDn = new JTextField();
		txtTenDn.setBounds(213, 257, 209, 27);
		contentPane.add(txtTenDn);
		txtTenDn.setColumns(10);
		
		txtMk = new JTextField();
		txtMk.setBounds(213, 306, 209, 27);
		contentPane.add(txtMk);
		txtMk.setColumns(10);
		
		txtMk2 = new JTextField();
		txtMk2.setBounds(215, 353, 207, 27);
		contentPane.add(txtMk2);
		txtMk2.setColumns(10);
		
		JButton txtLuu = new JButton("Luu");
		txtLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KiemTra1 kt=new KiemTra1();
					FileOutputStream f=new FileOutputStream("cb.txt");
					OutputStreamWriter o = new OutputStreamWriter(f);
					PrintWriter w=new PrintWriter(o);
					String re = "";
					String err = "";
					Boolean ok = true;
					
					
					if(kt.ktmacb(txtMcb.getText())==false) {
						ok = false;
						err += "\n Mã cán bộ";
					}
					if(kt.ktraTen(txtHoTen.getText())==false) {
						ok = false;
						err += "\n Họ tên";
					}
					if(kt.ktrNgay(txtNgaysinh.getText())== false) {
						ok = false;
						err += "\n Ngày sinh";
					}
					if(kt.KtEmail(txtmail.getText()) == false) {
						ok = false;
						err += "\n Email";
					}
					if(kt.KtSdt(txtSDT.getText())==false) {
						ok = false;
						err += "\n Số điện thoại";
					}
					if(kt.Ktradiem(txtHsl.getText())==false){
						ok = false;
						err += "\n Hệ số lương";
					}
					if(kt.ktraTen(txtTenDn.getText())==false) {
						ok = false;
						err += "\n Tên Đăng Nhập";
					}
					String mtKhau1 = new String(txtMk.getText());
					String mtKhau2 = new String(txtMk2.getText());
					if(kt.ktramk(mtKhau1, mtKhau2)==false) {
						ok = false;
						err += "\n Mật Khẩu";
					}
					if(ok == true) {
						re = 	txtMcb.getText()     + ";" + 
								txtHoTen.getText()       + ";" + 
								txtNgaysinh.getText()    + ";" + 
								txtmail.getText()       + ";" + 
								txtSDT.getText()         + ";" + 
								txtHsl.getText()         + ";" + 
								txtTenDn.getText() + ";" + 
								mtKhau1;
						w.println(re);
					} else {
						txtThongTin.setText("Các thông tin sau bị lỗi: " + err);
					}
					w.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			}
		);
		txtLuu.addMouseListener(new MouseAdapter() {
			
		});
		txtLuu.setBackground(new Color(0, 0, 255));
		txtLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLuu.setBounds(525, 339, 111, 41);
		contentPane.add(txtLuu);
		
		txtThongTin = new JTextField();
		txtThongTin.setBounds(154, 435, 481, 27);
		contentPane.add(txtThongTin);
		txtThongTin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cac thong tin loi");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 435, 111, 31);
		contentPane.add(lblNewLabel);
	}
}
