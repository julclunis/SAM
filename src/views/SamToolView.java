package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.event.ActionListener;

public class SamToolView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textFieldForStartingDirectoryOrFile;


	/**
	 * Create the panel.
	 */
	public SamToolView() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Configure OpenCalais Connection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 11, 263, 111);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 18, 132, 20);
		panel.add(textField);
		
		JLabel lblOpencalaisApiKey = new JLabel();
		lblOpencalaisApiKey.setBounds(10, 21, 106, 14);
		panel.add(lblOpencalaisApiKey);
		lblOpencalaisApiKey.setText("OpenCalais API Key:");
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 49, 45, 20);
		panel.add(textField_1);
		textField_1.setText("97000");
		
		JLabel lblFileLength = new JLabel();
		lblFileLength.setForeground(Color.RED);
		lblFileLength.setBounds(7, 52, 109, 14);
		panel.add(lblFileLength);
		lblFileLength.setText(".txt File Length Size: ");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Include Social Tags:");
		chckbxNewCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(10, 76, 122, 20);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_2 = new JLabel("97,000 Character Max");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(161, 52, 102, 14);
		panel.add(lblNewLabel_2);
		
	
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Input Option for Text:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 121, 426, 116);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblOption = new JLabel("Option 1 ");
		lblOption.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOption.setBounds(10, 21, 70, 14);
		panel_1.add(lblOption);
		
		JLabel lblNewLabel = new JLabel("Option 2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(193, 21, 74, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblOption_1 = new JLabel("Option 3");
		lblOption_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOption_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOption_1.setBounds(346, 21, 70, 14);
		panel_1.add(lblOption_1);
		
		JButton btnCopyAndPaste = new JButton("Copy and Paste");
		btnCopyAndPaste.setBounds(10, 36, 109, 23);
		panel_1.add(btnCopyAndPaste);
		
		JButton btnSingleFile = new JButton("Single .txt File");
		btnSingleFile.setBounds(160, 36, 101, 23);
		panel_1.add(btnSingleFile);
		
		JButton btnBatchDirectory = new JButton("Batch Directory");
		btnBatchDirectory.setBounds(296, 36, 120, 23);
		panel_1.add(btnBatchDirectory);
		
		JLabel label_2 = new JLabel();
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_2.setBounds(146, 73, 143, 14);
		panel_1.add(label_2);
		label_2.setText("Select File or Directory to be Analyzed");
		
		textFieldForStartingDirectoryOrFile = new JTextField();
		textFieldForStartingDirectoryOrFile.setBounds(20, 87, 396, 23);
		panel_1.add(textFieldForStartingDirectoryOrFile);
		textFieldForStartingDirectoryOrFile.setColumns(10);
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Output Directory and Start Metadata Extraction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(6, 248, 426, 136);
		add(panel_2);
		panel_2.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(133, 69, 279, 20);
		panel_2.add(textField_3);
		
		JLabel lblOpencalaissJsonCallback = new JLabel();
		lblOpencalaissJsonCallback.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOpencalaissJsonCallback.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOpencalaissJsonCallback.setBounds(133, 57, 279, 14);
		panel_2.add(lblOpencalaissJsonCallback);
		lblOpencalaissJsonCallback.setText("OpenCalais JSON Callback Payload (.json)");
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 34, 279, 20);
		panel_2.add(textField_4);
		
		JLabel lblExtractedEntitiesData = new JLabel();
		lblExtractedEntitiesData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExtractedEntitiesData.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExtractedEntitiesData.setBounds(133, 21, 279, 14);
		panel_2.add(lblExtractedEntitiesData);
		lblExtractedEntitiesData.setText("Named-Entity Recognition Data Output (.csv)");
		
		JButton btnStartOpencalaissNer = new JButton("Start");
		btnStartOpencalaissNer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStartOpencalaissNer.setBounds(160, 102, 101, 23);
		panel_2.add(btnStartOpencalaissNer);
		
		JButton btnSelectDirectory = new JButton("Select Directory");
		btnSelectDirectory.setBounds(10, 33, 113, 23);
		panel_2.add(btnSelectDirectory);
		
		JButton button = new JButton("Select Directory");
		button.setBounds(10, 68, 113, 23);
		panel_2.add(button);
		
		JPanel SamHeaderAndTitle = new JPanel();
		SamHeaderAndTitle.setBounds(279, 11, 153, 111);
		add(SamHeaderAndTitle);
		SamHeaderAndTitle.setLayout(null);
		
		JLabel lblSam = new JLabel("SAM");
		lblSam.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSam.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSam.setBounds(77, 0, 66, 35);
		SamHeaderAndTitle.add(lblSam);
		
		JTextPane txtpnAnOpencalaisText = new JTextPane();
		txtpnAnOpencalaisText.setEditable(false);
		txtpnAnOpencalaisText.setOpaque(false);
		txtpnAnOpencalaisText.setBounds(0, 49, 143, 62);
		SamHeaderAndTitle.add(txtpnAnOpencalaisText);
		txtpnAnOpencalaisText.setText("A Text Document Engine App for Archivists to Connect with OpenCalais Text Analytics Web API");
		
		JLabel lblNewLabel_1 = new JLabel("(Semantic Analysis Method)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(10, 27, 133, 14);
		SamHeaderAndTitle.add(lblNewLabel_1);

	}
	public String getNERDataOutputDirectoryLocation() {
		return textField_4.getText();
	}
	public String getOpenCalaisJsonCallBackDirectorySavedLocation() {
		return textField_3.getText();
	}
	public String getOpenCalaisApiKey() {
		return textField.getText();
	}
	
	void addStartSemanticAnalysisListern(ActionListener listenForStartButton){
	
	}
	
	void addSelectCopyAndPasteBtn(ActionListener listenforCopyandPastButton){
		
	}
	
	void addSelectSingleFileBtn(ActionListener listenForSingleFileButton){
		
	}
	void addSelectBatchDirectoryBtn(ActionListener listforBatchDirectoryButton){
		
	}
	
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	public JTextField getTextFieldForStartingDirectoryOrFile() {
		return textFieldForStartingDirectoryOrFile;
	}
}
