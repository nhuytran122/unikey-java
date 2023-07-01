package LTGiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BanHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtgia;
	private JTextField txtsl;
	private JTextField txttt;
	JComboBox cmbhang = new JComboBox();
	ArrayList<Hang> ds = new ArrayList<Hang>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHang frame = new BanHang();
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
	public BanHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Hang h1=new Hang();
					FileReader f= new FileReader("banhang.txt");

					BufferedReader b = new BufferedReader(f);

					while (true) {

					String st = b.readLine();

					if (st==null||st=="") {

					break;

					}

					String[] t=st.split("[;]");
					h1.setTenhang(t[0]);
					h1.setGia(Long.parseLong(t[1]));
					cmbhang.addItem(t[0]);
					ds.add(h1);
					}

					b.close();

					} catch (Exception e2) {

					e2.printStackTrace();

					}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chon hang");
		lblNewLabel.setBounds(24, 24, 65, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblGia = new JLabel("Gia");
		lblGia.setBounds(24, 64, 65, 23);
		contentPane.add(lblGia);
		
		JLabel lblSoLuong = new JLabel("So luong");
		lblSoLuong.setBounds(24, 111, 65, 23);
		contentPane.add(lblSoLuong);
		
		JLabel lblThanhTien = new JLabel("Thanh tien");
		lblThanhTien.setBounds(24, 158, 65, 23);
		contentPane.add(lblThanhTien);
		
		txtgia = new JTextField();
		txtgia.setBounds(99, 65, 152, 22);
		contentPane.add(txtgia);
		txtgia.setColumns(10);
		
		txtsl = new JTextField();
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {

					double soluong= Double.parseDouble(txtsl.getText());

					double gia= Double.parseDouble(txtgia.getText());

					Double tt=gia*soluong;

					txttt.setText(tt.toString());

					}
			}
		});
		txtsl.setColumns(10);
		txtsl.setBounds(99, 112, 152, 22);
		contentPane.add(txtsl);
		
		txttt = new JTextField();
		txttt.setColumns(10);
		txttt.setBounds(99, 159, 152, 22);
		contentPane.add(txttt);
		cmbhang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Lay ten hang vua chon
				String tenhang=cmbhang.getSelectedItem().toString();
				//duyet mang ds chua cac hang
				for (Hang h : ds) {
				if (h.getTenhang().equals(tenhang)) {
				txtgia.setText(String.valueOf(h.getGia()));

				}

			}
		}
		});
		
		cmbhang.setBounds(99, 24, 152, 22);
		contentPane.add(cmbhang);
	}
}
