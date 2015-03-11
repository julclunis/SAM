package views;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class OpenCalaisSemanticApp extends JPanel {

	private JTextField fileOrDirectoryLocationTextfiled;
	private JTextPane resultsFromProcessingTextField;
	private StringBuilder strbif = null;
	private JButton selectFileForAnalysisButton;
	private JButton previewTextContentButton;
	private JButton selectDirectoryForBatchButton;
	private JButton listFilesAndDirectoryButton;

	public OpenCalaisSemanticApp() {
		initGuiComponents();
		//createEvents();
	}

	private void initGuiComponents() {
		setLayout(null);

		JPanel headerResultsPanel = new JPanel();
		headerResultsPanel.setBounds(10, 11, 430, 140);
		add(headerResultsPanel);
		headerResultsPanel.setLayout(null);

		resultsFromProcessingTextField = new JTextPane();
		resultsFromProcessingTextField.setBounds(10, 17, 309, 107);
		headerResultsPanel.add(resultsFromProcessingTextField);

		JLabel label_3 = new JLabel();
		label_3.setBounds(340, 11, 80, 44);
		headerResultsPanel.add(label_3);
		label_3.setText("SAM");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 36));

		JLabel label_4 = new JLabel();
		label_4.setBounds(362, 61, 58, 15);
		headerResultsPanel.add(label_4);
		label_4.setText("Utility Tool");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel fileOrBatchProcessingPanel = new JPanel();
		fileOrBatchProcessingPanel.setBounds(10, 233, 430, 56);
		add(fileOrBatchProcessingPanel);
		fileOrBatchProcessingPanel.setLayout(null);

		fileOrDirectoryLocationTextfiled = new JTextField();
		fileOrDirectoryLocationTextfiled.setBounds(10, 24, 410, 20);
		fileOrBatchProcessingPanel.add(fileOrDirectoryLocationTextfiled);
		fileOrDirectoryLocationTextfiled.setName("");

		JLabel label_2 = new JLabel();
		label_2.setBounds(237, 8, 183, 14);
		fileOrBatchProcessingPanel.add(label_2);
		label_2.setText("Select File or Directory to be Analyzed");

		JPanel fileProcessingPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) fileProcessingPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		fileProcessingPanel.setBounds(10, 148, 151, 87);
		add(fileProcessingPanel);

		JLabel label = new JLabel();
		fileProcessingPanel.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setText("By Single File");
		
				previewTextContentButton = new JButton();
				fileProcessingPanel.add(previewTextContentButton);
				previewTextContentButton.setText("Preview Text");

		selectFileForAnalysisButton = new JButton();
		fileProcessingPanel.add(selectFileForAnalysisButton);
		selectFileForAnalysisButton.setText("Select File be analyzed");

		JPanel batchProcessingPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) batchProcessingPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		batchProcessingPanel.setBounds(289, 148, 151, 87);
		add(batchProcessingPanel);

		JLabel label_1 = new JLabel();
		batchProcessingPanel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setText("By Batch Process");

		listFilesAndDirectoryButton = new JButton();
		batchProcessingPanel.add(listFilesAndDirectoryButton);
		listFilesAndDirectoryButton.setText("List File and Directory");

		selectDirectoryForBatchButton = new JButton();
		batchProcessingPanel.add(selectDirectoryForBatchButton);
		selectDirectoryForBatchButton.setText("Select  Directory");
	}

	

	public JTextPane getResultsFromProcessingTextField() {
		return resultsFromProcessingTextField;
	}

	public JTextField getFileOrDirectoryLocationTextfiled() {
		return fileOrDirectoryLocationTextfiled;
	}
}
