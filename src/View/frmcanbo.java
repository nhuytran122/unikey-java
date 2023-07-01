package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.canbobean;
import Bo.canboBo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class frmcanbo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtHoten;
	private JTextField txtHsl;
	JComboBox cmbMaCb = new JComboBox();

	canboBo cbBo=new canboBo();
	ArrayList<canbobean>ds;
	void napbang(ArrayList<canbobean> ds) {
		DefaultTableModel mh=new DefaultTableModel();
		mh.addColumn("Ma Can Bo");mh.addColumn("Ho Ten");mh.addColumn("Tien Luong");mh.addColumn("he so luong");
		for(canbobean cb:ds) {
			Object[] t= new Object[4];
			System.out.println(cb.getMacb());
			System.out.println(cb.getHoten());
			t[0]=cb.getMacb();t[1]=cb.getHoten();t[2]=cb.tinhluong();
			t[3]=cb.getHsl();
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
					frmcanbo frame = new frmcanbo();
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
	public frmcanbo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				canboBo cbBo=new canboBo();
				try {
					ds=cbBo.getcb();
					napbang(ds);
				} catch (Exception e2) {
					System.out.println("loi o day"+e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 299, 860, 249);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Ma Can Bo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 24, 145, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ho Ten");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 94, 145, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("He So Luong");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 175, 145, 32);
		contentPane.add(lblNewLabel_2);
		
		txtHoten = new JTextField();
		txtHoten.setBounds(245, 94, 341, 33);
		contentPane.add(txtHoten);
		txtHoten.setColumns(10);
		
		txtHsl = new JTextField();
		txtHsl.setBounds(245, 175, 341, 33);
		contentPane.add(txtHsl);
		txtHsl.setColumns(10);
		
		JComboBox cmbMaCb = new JComboBox();
		cmbMaCb.setBounds(245, 20, 341, 37);
		contentPane.add(cmbMaCb);
	}
}
