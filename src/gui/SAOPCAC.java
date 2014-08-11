package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class SAOPCAC extends JPanel {
	private JTextField fileOrDirectoryLocationTextfiled;

	/**
	 * Create the panel.
	 */
	public SAOPCAC() {
		setLayout(null);
		
		fileOrDirectoryLocationTextfiled = new JTextField();
		fileOrDirectoryLocationTextfiled.setBounds(10, 125, 430, 20);
		fileOrDirectoryLocationTextfiled.setName("");
		add(fileOrDirectoryLocationTextfiled);
		
		JButton button_1 = new JButton();
		button_1.setBounds(10, 172, 141, 23);
		button_1.setText("Select File be analyzed");
		add(button_1);
		
		JButton button_2 = new JButton();
		button_2.setBounds(10, 200, 141, 23);
		button_2.setText("Preview Text");
		add(button_2);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 156, 141, 14);
		label.setText("By Single File");
		add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(442, 16, 2, 0);
		separator.setOrientation(SwingConstants.VERTICAL);
		add(separator);
		
		JLabel label_1 = new JLabel();
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(13, 224, 134, 14);
		label_1.setText("By Batch Process");
		add(label_1);
		
		JButton button_4 = new JButton();
		button_4.setBounds(10, 266, 141, 23);
		button_4.setText("List File and Directory");
		add(button_4);
		
		JCheckBox checkBox = new JCheckBox();
		checkBox.setBounds(157, 266, 135, 23);
		checkBox.setText("Include Sub-directories");
		checkBox.setSelected(true);
		checkBox.setForeground(new Color(255, 0, 51));
		add(checkBox);
		
		JLabel label_2 = new JLabel();
		label_2.setBounds(257, 112, 183, 14);
		label_2.setText("Select File or Directory to be Analyzed");
		add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(360, 6, 80, 44);
		label_3.setText("SAM");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		add(label_3);
		
		JButton button_3 = new JButton();
		button_3.setBounds(10, 242, 141, 23);
		button_3.setText("Select  Directory");
		add(button_3);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(382, 50, 58, 15);
		label_4.setText("Utility Tool");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(label_4);
		
		JTextPane resultsFromProcessingTextField = new JTextPane();
		resultsFromProcessingTextField.setBounds(10, 6, 340, 98);
		add(resultsFromProcessingTextField);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(257, 242, 105, -15);
		add(horizontalStrut);

	}
}
