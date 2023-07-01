package LTGiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmHam extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Hang> ds=new ArrayList<Hang>();
	private JTextField txtTenHang;
	private JTextField txtGia;

	void NapBang(ArrayList<Hang> ds)throws FileNotFoundException {
		DefaultTableModel mh=new DefaultTableModel();
		mh.addColumn("ten hang ");
		mh.addColumn("gia");
		for(Hang h:ds) {
			Object[] t = new Object[2];
			t[0]=h.getTenhang();t[1]=h.getGia();
			mh.addRow(t);
			//mh.addrow(tt);
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
					FrmHam frame = new FrmHam();
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
	public FrmHam() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//code vo day
				try {
				FileReader f=new FileReader("hanghoa.txt");
				BufferedReader b=new BufferedReader(f);
				Hang h1=new Hang();
		        while (true) {
		            String st = b.readLine();
		            System.out.println(st);
		            if (st == "" || st == null)
		                break;
		            String[] tt=st.split("[;]");
		            h1.setTenhang(tt[0]);
		            h1.setGia(Long.parseLong(tt[1]));
		            ds.add(h1);
		        }
		        b.close();
				NapBang(ds);
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 131, 426, 132);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//lam ow day
				int d=table.getSelectedRow();
				String th=table.getValueAt(d, 0).toString();
				String gia=table.getValueAt(d, 1).toString();
				txtTenHang.setText(th);
				txtGia.setText(gia);
				}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setColumnHeaderView(scrollPane_1);
		
		JLabel th = new JLabel("Ten Hang");
		th.setFont(new Font("Tahoma", Font.PLAIN, 14));
		th.setBounds(10, 10, 87, 28);
		contentPane.add(th);
		
		JLabel lblNewLabel = new JLabel("Gia");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 48, 87, 28);
		contentPane.add(lblNewLabel);
		
		txtTenHang = new JTextField();
		txtTenHang.setBounds(137, 10, 267, 28);
		contentPane.add(txtTenHang);
		txtTenHang.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setBounds(137, 48, 267, 28);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hang h = new Hang();
				h.setTenhang(txtTenHang.getText());
				h.setGia(Long.parseLong(txtGia.getText()));
				
				ds.add(h);
				try {
				NapBang(ds);
			}catch (Exception e1) {
				// TODO: handle exception
				System.out.println(e1.getMessage());
			}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(43, 86, 54, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hang h1=new Hang();
				String hh = JOptionPane.showInputDialog("nhap ten hang can xoa ");
				for(Hang h:ds) {
					if(h.getTenhang().equals(hh)) {
						ds.remove(h);
						break;
					}
				}
				try {
					NapBang(ds);
				} catch (Exception e4) {
					// TODO: handle exception
					System.out.println(e4.getMessage());
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(114, 86, 65, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f = new FileWriter("hanghoa.txt");
					PrintWriter ghi=new PrintWriter(f);
					for(Hang h:ds) {
						ghi.println(h);
					}
					ghi.close();
					JOptionPane.showConfirmDialog(null,"da luu");
				} catch (Exception e5) {
					// TODO: handle exception
					System.out.println(e5.getMessage());
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(264, 86, 65, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Find");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(339, 86, 65, 35);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th=txtTenHang.getText();
				int n=ds.size();
//				for(Hang h:ds) {
//					if(h.getTenhang().equals(th)) {
//						h1.setTenhang(h.getTenhang());
//						h1.setGia(Long.parseLong(txtGia.getText()));
//						ds.add(h1);
//					}
					
				for(int i = 0 ; i < n ; i++) {
// lam lai					String tenhang=cmbhang.getSelectedItem().toString();
					Hang h=ds.get(i);
					if(h.getTenhang().equals(th)) {
						h.setTenhang(txtTenHang.getText());
						h.setGia(Long.parseLong(txtGia.getText()));
						ds.set(i,h);
					}
				
			}
				try {
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4.setBounds(189, 86, 65, 35);
		contentPane.add(btnNewButton_4);
	}
}
