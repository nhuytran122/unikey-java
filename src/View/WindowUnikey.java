package View;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class WindowUnikey extends Unikey{
	JComboBox cmbUnicode = new JComboBox();
	private JComboBox comboBox;
	public void add() {
		cmbUnicode.addItem("Unicode");
		cmbUnicode.addItem("Vietnamese");
		comboBox.addItem("Telex");
	}
}
