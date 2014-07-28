package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.Color;

public class configureOpenCalaisConnection extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configureOpenCalaisConnection dialog = new configureOpenCalaisConnection();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public configureOpenCalaisConnection() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel();
			label.setBounds(325, 105, 97, 14);
			contentPanel.add(label);
			label.setText("File Length (97000):");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(11, 176, 122, 14);
			contentPanel.add(label);
			label.setText("OpenCalais API Keycode:");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 92, 206, 14);
			contentPanel.add(label);
			label.setText("Location to Save OpenCalais JSON callback");
		}
		{
			textField = new JTextField();
			textField.setBounds(182, 57, 108, 20);
			contentPanel.add(textField);
		}
		{
			JLabel label = new JLabel();
			label.setBounds(140, 7, 240, 17);
			contentPanel.add(label);
			label.setText("Document Workflow Configuration");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(339, 61, 0, 2);
			contentPanel.add(separator);
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 148, 370, 17);
			contentPanel.add(label);
			label.setText("Configure Opitions for OpenCalais's Semantic Analysis");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(386, 117, 36, 20);
			contentPanel.add(textField_1);
			textField_1.setText("97000");
		}
		{
			JCheckBox checkBox = new JCheckBox();
			checkBox.setBounds(273, 200, 149, 23);
			contentPanel.add(checkBox);
			checkBox.setText("Include Releanvacy Score");
			checkBox.setSelected(true);
			checkBox.setForeground(new Color(255, 0, 51));
		}
		{
			JCheckBox checkBox = new JCheckBox();
			checkBox.setBounds(273, 172, 117, 23);
			contentPanel.add(checkBox);
			checkBox.setText("Include Social Tags");
			checkBox.setSelected(true);
			checkBox.setForeground(new Color(204, 0, 51));
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 32, 269, 14);
			contentPanel.add(label);
			label.setText("Location for Extracted Entities Data file --- (RDF or CSV)");
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(143, 173, 124, 20);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(128, 201, 25, 20);
			contentPanel.add(textField_3);
			textField_3.setText("CSV");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 204, 113, 14);
			contentPanel.add(label);
			label.setText("File Type (RDF or CSV):");
			label.setForeground(new Color(255, 0, 51));
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(174, 117, 141, 20);
			contentPanel.add(textField_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
