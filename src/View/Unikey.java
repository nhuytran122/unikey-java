package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Unikey extends JFrame {

	private JPanel contentPane;
	private JTextField txtDieuKhien;
	private JTextField txtBangMa;
	private JTextField txtKieuGo;
	private JTextField txtPhimChuyen;
	private JComboBox comboBox;
	JComboBox cmbUnicode = new JComboBox();
	public static String un="";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unikey frame = new Unikey();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Unikey() {
		this.setTitle("UNIKEY.4.2");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cmbUnicode.addItem("Unicode");
				cmbUnicode.addItem("Vietnamese");
				comboBox.addItem("Telex");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		txtDieuKhien = new JTextField();
		txtDieuKhien.setText("Điều khiển");
		txtDieuKhien.setBounds(23, 31, 96, 19);
		contentPane.add(txtDieuKhien);
		txtDieuKhien.setColumns(10);
		
		txtBangMa = new JTextField();
		txtBangMa.setText("Bảng mã");
		txtBangMa.setBounds(23, 70, 96, 19);
		contentPane.add(txtBangMa);
		txtBangMa.setColumns(10);
		
		txtKieuGo = new JTextField();
		txtKieuGo.setText("Kiểu gõ");
		txtKieuGo.setBounds(23, 99, 96, 19);
		contentPane.add(txtKieuGo);
		txtKieuGo.setColumns(10);
		txtPhimChuyen = new JTextField();
		txtPhimChuyen.setText("Phím Chuyển");
		txtPhimChuyen.setBounds(23, 139, 96, 19);
		contentPane.add(txtPhimChuyen);
		txtPhimChuyen.setColumns(10);
		cmbUnicode.setBounds(163, 69, 140, 21);
		contentPane.add(cmbUnicode);
		comboBox = new JComboBox();
		comboBox.setBounds(163, 98, 96, 21);
		contentPane.add(comboBox);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(269, 98, 32, 21);
		contentPane.add(btnNewButton);
		JButton bdong = new JButton("Đóng");
		bdong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dong d=new dong();
				d.dong();
				
			}
		});
		bdong.setBounds(322, 30, 85, 35);
		contentPane.add(bdong);
		
		JButton bketThuc = new JButton("Kết thúc");
		bketThuc.setBounds(322, 89, 85, 29);
		contentPane.add(bketThuc);
		
		JButton bmoRong = new JButton("Mở rộng");

		bmoRong.setBounds(322, 133, 85, 30);
		contentPane.add(bmoRong);
		
		JRadioButton rbcrt = new JRadioButton("CRT+SHIFT");
		rbcrt.setBounds(145, 138, 85, 21);
		contentPane.add(rbcrt);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ALT+Z");
		rdbtnNewRadioButton.setBounds(232, 138, 73, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton bhuongDan = new JButton("Hướng dẫn");
		bhuongDan.setBounds(20, 203, 85, 35);
		contentPane.add(bhuongDan);
		
		JButton bthongTin = new JButton("Thông tin");
		bthongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				un="about unikey 4.2 RC4 [BUILD 2014]";
				thongtin tt=new thongtin();
				tt.setVisible(true);
			}
		});
		bthongTin.setBounds(145, 203, 96, 35);
		contentPane.add(bthongTin);
		
		JButton bmacDinh = new JButton("Mặc định");
		bmacDinh.setBounds(269, 203, 85, 35);
		contentPane.add(bmacDinh);
		JList list = new JList();
		list.setBounds(22, 31, 290, 150);
		contentPane.add(list);
	}
}
