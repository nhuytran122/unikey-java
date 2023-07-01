package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.donvibean;
import Bo.donvido;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.function.IntToDoubleFunction;
import java.util.stream.IntStream;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmdonvi extends JFrame {

	private JPanel contentPane;
	JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTextField txtmadv;
	private JTextField txttendv;

	donvido dvbo= new donvido();
	ArrayList<donvibean> ds;
	void napbang(ArrayList<donvibean> ds) {
		DefaultTableModel mh= new DefaultTableModel();
		mh.addColumn("Madv"); mh.addColumn("Tendv");
		for(donvibean dv:ds) {
			Object[] t= new Object[2];
			t[0]=dv.getMadv(); t[1]=dv.getTendv();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmdonvi frame = new frmdonvi();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println();
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmdonvi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					ds=dvbo.getdv();
					napbang(ds);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 115, 438, 132);
		contentPane.add(tabbedPane);
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});
		

		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				String madv=table.getValueAt(d, 0).toString();
				String tendv=table.getValueAt(d, 1).toString();
				txtmadv.setText(madv);
				txttendv.setText(tendv);
			}
		});
		scrollPane.setRowHeaderView(table);
		
		JLabel lblNewLabel = new JLabel("Ma dv");
		lblNewLabel.setBounds(25, 6, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ten dv");
		lblNewLabel_1.setBounds(25, 39, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtmadv = new JTextField();
		txtmadv.setBounds(126, 1, 278, 26);
		contentPane.add(txtmadv);
		txtmadv.setColumns(10);
		
		txttendv = new JTextField();
		txttendv.setBounds(126, 39, 278, 26);
		contentPane.add(txttendv);
		txttendv.setColumns(10);
		
		JButton txtadd = new JButton("Add");
		txtadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ds=dvbo.Them(txtmadv.getText(), txttendv.getText());
					if(ds==null)
						JOptionPane.showMessageDialog(null,"Trung ma");
					napbang(ds);
					
				}catch (Exception e1) {
					e1.printStackTrace();
			}}
		});
		txtadd.setBounds(6, 88, 97, 29);
		contentPane.add(txtadd);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String hh = JOptionPane.showInputDialog("nhap ten hang can xoa ");
//				for(donvibean h:ds) {
//					if(h.getMadv().equals(hh)) {
//						ds.remove(h);
//						break;
//					}
//				}
				try {
					int t= JOptionPane.showConfirmDialog(null, "Xoa hay khoong!!!");
					if(t==0) {
						dvbo.Xoa(txtmadv.getText());
						napbang(ds);
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		delete.setBounds(104, 88, 97, 29);
		contentPane.add(delete);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String madovi = txtmadv.getText();
				int n=ds.size();
				for(int i = 0 ; i < n ; i++) {
					donvibean h=ds.get(i);
					if(h.getMadv().equals(madovi)) {
						h.setMadv(txtmadv.getText());
						h.setTendv(txttendv.getText());
						ds.set(i, h);
						
					}
				}
				try {
					napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
		update.setBounds(213, 88, 97, 29);
		contentPane.add(update);
		
		JButton save = new JButton("Save");
		save.setBounds(320, 88, 97, 29);
		contentPane.add(save);
	}
}