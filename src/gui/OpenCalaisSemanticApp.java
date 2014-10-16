package gui;

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
		createEvents();
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

	private void createEvents() {
		selectFileForAnalysisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectInvidualTextFileForProcessing();
			}
		});

		listFilesAndDirectoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (fileOrDirectoryLocationTextfiled.getText() != null) {
						File tempfile = new File(
								fileOrDirectoryLocationTextfiled.getText());

						if (tempfile.isDirectory()) {

							strbif = new StringBuilder();
							iterateandPrintDirectoryandFiles(tempfile
									.listFiles());

							DialogForPreviewingText ptd = new DialogForPreviewingText();

							File tempfilefordirectory = File.createTempFile(
									"test", "txt");
							tempfilefordirectory.deleteOnExit();
							FileUtils.writeStringToFile(tempfilefordirectory,
									strbif.toString());

							ptd.showCustomContentInDialog(tempfilefordirectory);

							strbif = null;

						}

					}
				} catch (Exception e1) {

				}
			}
		});

		selectDirectoryForBatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectDirectoryToBeProcessed();
			}
		});

		previewTextContentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (fileOrDirectoryLocationTextfiled.getText() != null) {
						File tempfile = new File(
								fileOrDirectoryLocationTextfiled.getText());

						if (tempfile.isFile()) {
							DialogForPreviewingText ptd = new DialogForPreviewingText();
							ptd.showCustomContentInDialog(tempfile);
						}

					}
				} catch (Exception e1) {

				}
			}
		});
	}

	// potentially convert this void into a string builder function
	protected void iterateandPrintDirectoryandFiles(File[] files) {
		for (File perfile : files) {
			if (perfile.isDirectory()) {
				strbif = strbif.append(perfile.getAbsolutePath());
				strbif = strbif.append("\n");
				iterateandPrintDirectoryandFiles(perfile.listFiles());
			} else {
				strbif = strbif.append("-----");
				strbif = strbif.append(perfile.getAbsolutePath());
				strbif = strbif.append("\n");
			}
		}

	}

	protected void selectInvidualTextFileForProcessing() {
		JFileChooser jFileChooser1 = new JFileChooser();
		jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = jFileChooser1.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			try {
				fileOrDirectoryLocationTextfiled.setText(jFileChooser1
						.getSelectedFile().getAbsolutePath());
			} catch (Exception ex) {
				System.out.println("problem accessing file");
			}
		} else {
			System.out.println("File access cancelled by user.");
		}
		
		//DialogForSelectingFileDirectory dsfd = new DialogForSelectingFileDirectory();
	

	}

	protected void selectDirectoryToBeProcessed() {
		JFileChooser jFileChooser1 = new JFileChooser();
		jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jFileChooser1.setDialogTitle("Select Directory, please!");
		jFileChooser1.setAcceptAllFileFilterUsed(false);

		if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			// File directoryPath = jFileChooser1.getSelectedFile();
			// OCAO.setDirectoryForBatchProcessing(directoryPath);
			// jSelectFileToReadTextTextField.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
			fileOrDirectoryLocationTextfiled.setText(jFileChooser1
					.getSelectedFile().getAbsolutePath());
		} else {
			System.out.println("No Selection ");
		}

	}

	public JTextPane getResultsFromProcessingTextField() {
		return resultsFromProcessingTextField;
	}

	public JTextField getFileOrDirectoryLocationTextfiled() {
		return fileOrDirectoryLocationTextfiled;
	}
}
