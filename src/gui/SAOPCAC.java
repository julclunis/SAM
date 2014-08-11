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
	private JTextPane resultsFromProcessingTextField;

	/**
	 * Create the panel.
	 */
	public SAOPCAC() {
		setLayout(null);
		
		fileOrDirectoryLocationTextfiled = new JTextField();
		fileOrDirectoryLocationTextfiled.setBounds(10, 125, 430, 20);
		fileOrDirectoryLocationTextfiled.setName("");
		add(fileOrDirectoryLocationTextfiled);
		
		JButton selectFileForAnalysisButton = new JButton();
		selectFileForAnalysisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		selectFileForAnalysisButton.setBounds(10, 172, 141, 23);
		selectFileForAnalysisButton.setText("Select File be analyzed");
		add(selectFileForAnalysisButton);
		
		JButton previewTextContentButton = new JButton();
		previewTextContentButton.setBounds(10, 200, 141, 23);
		previewTextContentButton.setText("Preview Text");
		add(previewTextContentButton);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 156, 141, 14);
		label.setText("By Single File");
		add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(13, 224, 134, 14);
		label_1.setText("By Batch Process");
		add(label_1);
		
		JButton listFilesAndDirectoryButton = new JButton();
		listFilesAndDirectoryButton.setBounds(10, 266, 141, 23);
		listFilesAndDirectoryButton.setText("List File and Directory");
		add(listFilesAndDirectoryButton);
		
		JLabel label_2 = new JLabel();
		label_2.setBounds(257, 112, 183, 14);
		label_2.setText("Select File or Directory to be Analyzed");
		add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(360, 6, 80, 44);
		label_3.setText("SAM");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		add(label_3);
		
		JButton selectDirectoryForBatchButton = new JButton();
		selectDirectoryForBatchButton.setBounds(10, 242, 141, 23);
		selectDirectoryForBatchButton.setText("Select  Directory");
		add(selectDirectoryForBatchButton);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(382, 50, 58, 15);
		label_4.setText("Utility Tool");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(label_4);
		
		resultsFromProcessingTextField = new JTextPane();
		resultsFromProcessingTextField.setBounds(10, 6, 340, 98);
		add(resultsFromProcessingTextField);

	}
	public JTextPane getResultsFromProcessingTextField() {
		return resultsFromProcessingTextField;
	}
	public JTextField getFileOrDirectoryLocationTextfiled() {
		return fileOrDirectoryLocationTextfiled;
	}
}
