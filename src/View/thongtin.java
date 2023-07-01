package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class thongtin extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongtin frame = new thongtin();
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
	public thongtin() {
		this.setTitle(Unikey.un);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Đóng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(134, 263, 139, 40);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnUnikeyBit = new JTextPane();
		txtpnUnikeyBit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnUnikeyBit.setText("Unikey (64) bit - Chương trình bàn phím tiếng Việt đa năng\r\nWebside : \thttps://www.facebook.com/\r\nBản quyền C - 2014 Phạm Kim Long \r\n");
		txtpnUnikeyBit.setBounds(10, 10, 426, 79);
		contentPane.add(txtpnUnikeyBit);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea.setText(" UniKey là chương trình bàn phím tiếng Việt miễn phí.\r\n UniKey chạy trên tất cả các hệ điều hành Windows.\r\n\r\n Các thành viên dự án UniKey:\r\n         Phạm Kim Long: Phát triển chính\r\n         Lâm Vĩnh Niên: Quản lý diễn đàn UniKey\r\n\r\n Trang Web của dự án:\r\n         http://sf.net/projects/unikey\r\n\r\n Diễn đàn trợ giúp:\r\n         http://unikey.org/forum\r\n\r\n Liên lạc:\r\n         Phạm Kim Long: unikey@gmail.com");
		textArea.setBounds(10, 107, 426, 133);
		contentPane.add(textArea);
	}
}
