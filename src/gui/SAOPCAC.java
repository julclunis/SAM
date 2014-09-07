package gui;

import javax.swing.JFileChooser;
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
import java.io.File;

import javax.swing.Box;

import org.apache.commons.io.FileUtils;

@SuppressWarnings("serial")
public class SAOPCAC extends JPanel {
	private JTextField fileOrDirectoryLocationTextfiled;
	private JTextPane resultsFromProcessingTextField;
	private StringBuilder strbif = null;

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

				selectInvidualTextFileForProcessing();
			}
		});
		selectFileForAnalysisButton.setBounds(10, 172, 166, 23);
		selectFileForAnalysisButton.setText("Select File be analyzed");
		add(selectFileForAnalysisButton);

		JButton previewTextContentButton = new JButton();
		previewTextContentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previewTextFromFile();
			}
		});
		previewTextContentButton.setBounds(10, 200, 166, 23);
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
		listFilesAndDirectoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listDirectoriesAndFiles();
			}
		});
		listFilesAndDirectoryButton.setBounds(10, 266, 166, 23);
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
		selectDirectoryForBatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectDirectoryToBeProcessed();
			}
		});
		selectDirectoryForBatchButton.setBounds(10, 242, 166, 23);
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

	protected void listDirectoriesAndFiles() {
		try {

			if (fileOrDirectoryLocationTextfiled.getText() != null) {
				File tempfile = new File(
						fileOrDirectoryLocationTextfiled.getText());

				if (tempfile.isDirectory()) {

					strbif = new StringBuilder();
					iterateandPrintDirectoryandFiles(tempfile.listFiles());

					PreviewTextDialog ptd = new PreviewTextDialog();

					File tempfilefordirectory = File.createTempFile("test",
							"txt");
					tempfilefordirectory.deleteOnExit();
					FileUtils.writeStringToFile(tempfilefordirectory,
							strbif.toString());

					ptd.showCustomContentInDialog(tempfilefordirectory);

					strbif = null;

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void previewTextFromFile() {
		try {

			if (fileOrDirectoryLocationTextfiled.getText() != null) {
				File tempfile = new File(
						fileOrDirectoryLocationTextfiled.getText());

				if (tempfile.isFile()) {
					PreviewTextDialog ptd = new PreviewTextDialog();
					ptd.showCustomContentInDialog(tempfile);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void selectInvidualTextFileForProcessing() {
		JFileChooser jFileChooser1 = new JFileChooser();
		jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = jFileChooser1.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// File file = jFileChooser1.getSelectedFile();
			try {

				// OCAO.setFileMain(file);
				// jSelectFileToReadTextTextField.setText(file.getAbsolutePath());
				fileOrDirectoryLocationTextfiled.setText(jFileChooser1
						.getSelectedFile().getAbsolutePath());
			} catch (Exception ex) {
				System.out.println("problem accessing file");
			}
		} else {
			System.out.println("File access cancelled by user.");
		}

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
