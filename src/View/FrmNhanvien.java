package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.nhanvienbean;
import Bo.donvido;
import Bo.nhanvienbo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmNhanvien extends JFrame {

	private JPanel contentPane;
	private JTextField txtmanv;
	private JTextField txthoten;
	private JTextField txtngaysinh;
	private JTextField txthsl;
	private JTextField txtmadv;

	nhanvienbo nvbo=new nhanvienbo();
	ArrayList<nhanvienbean> ds;
	private JTable table;
	void napbang(ArrayList<nhanvienbean> ds) {
		DefaultTableModel mh=new DefaultTableModel();
		mh.addColumn("ma nhan vien");
		mh.addColumn("ho ten");
		mh.addColumn("ngay sinh");
		mh.addColumn("he so luong");
		mh.addColumn("ma don vi");
		for(nhanvienbean nv:ds) {
			Object[] t=new Object[5];
			t[0]=nv.getManv();
			t[1]=nv.getHoten();
			t[2]=nv.getNgaysinh();
			t[3]=nv.getHsl();
			t[4]=nv.getMadv();
			mh.addRow(t);
		}
		table.setModel(mh);
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanvien frame = new FrmNhanvien();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("loi loi loi loi "+e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmNhanvien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds=nvbo.getnv();
					napbang(ds);
				} catch (Exception e2) {
					System.out.println("loi ơ day"+e2.getMessage());
					e2.printStackTrace();
				} 
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 10, 192, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 64, 192, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày Sinh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 125, 204, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hệ Số Lương");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 190, 204, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã Đơn Vị");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 247, 192, 34);
		contentPane.add(lblNewLabel_4);
		
		txtmanv = new JTextField();
		txtmanv.setBounds(283, 10, 616, 34);
		contentPane.add(txtmanv);
		txtmanv.setColumns(10);
		
		txthoten = new JTextField();
		txthoten.setBounds(283, 64, 616, 34);
		contentPane.add(txthoten);
		txthoten.setColumns(10);
		
		txtngaysinh = new JTextField();
		txtngaysinh.setBounds(283, 125, 616, 34);
		contentPane.add(txtngaysinh);
		txtngaysinh.setColumns(10);
		
		txthsl = new JTextField();
		txthsl.setBounds(283, 190, 616, 34);
		contentPane.add(txthsl);
		txthsl.setColumns(10);
		
		txtmadv = new JTextField();
		txtmadv.setBounds(283, 247, 616, 34);
		contentPane.add(txtmadv);
		txtmadv.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
					Date ngaysinh=dd.parse(txtngaysinh.getText());
					ds= nvbo.Them(getTitle(), getWarningString(), ngaysinh, null, getName())
					if(ds==null) {
						JOptionPane.showMessageDialog(null, "trung ma");
					}
					napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(164, 344, 137, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UpDate");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(371, 344, 137, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(559, 344, 137, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(755, 344, 144, 39);
		contentPane.add(btnNewButton_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 421, 1011, 198);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
