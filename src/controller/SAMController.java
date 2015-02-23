package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;

import views.DialogForAnalyzeFreeText;
import views.DialogForConfiguringOpenCalais;
import views.DialogForPreviewingText;


public class SAMController {
	
	
	
	
	protected void startSemanticsAnalysis() {
		configureOpenCalaisEngine();
		if (saopcac.getFileOrDirectoryLocationTextfiled().getText() != null) {
			File tempfile = new File(saopcac.getFileOrDirectoryLocationTextfiled().getText());
			
			if (tempfile.isDirectory()) {
				logic.setDirectoryForBatchProcessing(tempfile);
			} else if (tempfile.isFile()) {
				logic.setFileMain(tempfile);
			}
			logic.initiateAndProcessOpenCalaisCall();

		} else {
			System.out.println("file text field is null");
		}
	}
	
	private void startSemanticsAnalysis(String freetextContent){
		configureOpenCalaisEngine();
		try {
			File temfile = File.createTempFile("filename", "txt");
			FileUtils.writeStringToFile(temfile, freetextContent);
			logic.setFileMain(temfile);
			logic.initiateAndProcessOpenCalaisCall();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void configureOpenCalaisEngine() {
		
		logic = new SamOpenCalaisEntityExtractionViewModel();
		logic.setSam(opencalaisconfiguration);
		logic.getSam().setLocationForCallBackToSave(
				opencalaisconfiguration.getLocationForCallBackToSave());
		logic.getSam().setLocationForExtractEntities(
				opencalaisconfiguration.getLocationForExtractEntities());
		logic.getSam().setOCApiKey(opencalaisconfiguration.getOCApiKey());
		
	}

	private void createEvents() {
		configureOpenCalaisBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (opencalaisconfiguration == null) {	
				DialogForConfiguringOpenCalais configurOC = new DialogForConfiguringOpenCalais();
				configurOC.setModal(true);
				opencalaisconfiguration = configurOC.showDialog();
				} else if (opencalaisconfiguration != null) {
					DialogForConfiguringOpenCalais configurOC = new DialogForConfiguringOpenCalais(opencalaisconfiguration);
					configurOC.setModal(true);
					opencalaisconfiguration = configurOC.showDialog();
				}
			}//end of action
		});
		
		startSemanticAnalysisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSemanticsAnalysis();
			}
		});
		
		btnStartFreeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DialogForAnalyzeFreeText aftd = new DialogForAnalyzeFreeText();
				aftd.setModal(true);
				//aftd.setVisible(true);
				//System.out.println("set if visible");
				String contentToAnalyze = aftd.showDialog();
				startSemanticsAnalysis(contentToAnalyze);

			}
		});
	}// EndofCreateEVents....

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
}
