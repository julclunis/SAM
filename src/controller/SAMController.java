package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import models.*;

import org.apache.commons.io.FileUtils;

import views.DialogForAnalyzeFreeText;
import views.DialogForConfiguringOpenCalais;
import views.DialogForPreviewingText;
import views.SamToolView;

public class SAMController {

	private SamToolView theView;
	private OpenCalaisConfigurationModel confModel;
	private OpenCalaisNERServiceCallModel webServiceCallModel;

	public SAMController(SamToolView theview,
			OpenCalaisConfigurationModel theconfig,
			OpenCalaisNERServiceCallModel theservicemodel) {
		this.theView = theview;
		this.confModel = theconfig;
		this.webServiceCallModel = theservicemodel;

	}

	class ConfigureOpenCalaisConfig implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (confModel.getOCApiKey() == null) {
				DialogForConfiguringOpenCalais configurOC = new DialogForConfiguringOpenCalais();
				configurOC.setModal(true);
				confModel = configurOC.showDialog();
			} else if (confModel.getOCApiKey() != null) {
				DialogForConfiguringOpenCalais configurOC = new DialogForConfiguringOpenCalais(
						confModel);
				configurOC.setModal(true);
				confModel = configurOC.showDialog();
			}
		}

	}

	class StartSemanticAnalysisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class StartSemanticAnalysisOnFreeTextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			DialogForAnalyzeFreeText aftd = new DialogForAnalyzeFreeText();
			aftd.setModal(true);
			// aftd.setVisible(true);
			// System.out.println("set if visible");
			String contentToAnalyze = aftd.showDialog();
			OpenCalaisNERServiceCallModel
					.startSemanticsFreeTextAnalysis(contentToAnalyze);

		}

	}

	class SelectFileForAnalysisActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// selectInvidualTextFileForProcessing();

			JFileChooser jFileChooser1 = new JFileChooser();
			jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = jFileChooser1.showOpenDialog(theView);

			if (returnVal == JFileChooser.APPROVE_OPTION) {

				try {
					theView.getTextFieldForStartingDirectoryOrFile().setText(
							jFileChooser1.getSelectedFile().getAbsolutePath());
				} catch (Exception ex) {
					System.out.println("problem accessing file");
				}
			} else {
				System.out.println("File access cancelled by user.");
			}

			// DialogForSelectingFileDirectory dsfd = new
			// DialogForSelectingFileDirectory();

		}

	}

	class ListFilesAndDirectoryActionListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				if (fileOrDirectoryLocationTextfiled.getText() != null) {
					File tempfile = new File(
							fileOrDirectoryLocationTextfiled.getText());

					if (tempfile.isDirectory()) {

						strbif = new StringBuilder();
						iterateandPrintDirectoryandFiles(tempfile.listFiles());

						DialogForPreviewingText ptd = new DialogForPreviewingText();

						File tempfilefordirectory = File.createTempFile("test",
								"txt");
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

	}

	class SelectDirectoryForBatchActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// selectDirectoryToBeProcessed();

			JFileChooser jFileChooser1 = new JFileChooser();
			jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jFileChooser1.setDialogTitle("Select Directory, please!");
			jFileChooser1.setAcceptAllFileFilterUsed(false);

			if (jFileChooser1.showOpenDialog(theView) == JFileChooser.APPROVE_OPTION) {
				// File directoryPath = jFileChooser1.getSelectedFile();
				// OCAO.setDirectoryForBatchProcessing(directoryPath);
				// jSelectFileToReadTextTextField.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
				theView.getTextFieldForStartingDirectoryOrFile().setText(
						jFileChooser1.getSelectedFile().getAbsolutePath());
			} else {
				System.out.println("No Selection ");
			}

		}

	}

	class PreviewTextContentActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				if (theView.getTextFieldForStartingDirectoryOrFile().getText() != null) {
					File tempfile = new File(theView
							.getTextFieldForStartingDirectoryOrFile().getText());

					if (tempfile.isFile()) {
						DialogForPreviewingText ptd = new DialogForPreviewingText();
						ptd.showCustomContentInDialog(tempfile);
					}

				}
			} catch (Exception e1) {

			}
		}

	}

}// potentially convert this void into a string builder function
class IterateAndPrintDirectoryAndFilesActionListener implements ActionListener {

	StringBuilder strbif = new StringBuilder();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
}



// protected void iterateandPrintDirectoryandFiles(File[] files) {
// for (File perfile : files) {
// if (perfile.isDirectory()) {
// strbif = strbif.append(perfile.getAbsolutePath());
// strbif = strbif.append("\n");
// iterateandPrintDirectoryandFiles(perfile.listFiles());
// } else {
// strbif = strbif.append("-----");
// strbif = strbif.append(perfile.getAbsolutePath());
// strbif = strbif.append("\n");
// }
// }
//
// }

// protected void selectInvidualTextFileForProcessing() {
// JFileChooser jFileChooser1 = new JFileChooser();
// jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
// int returnVal = jFileChooser1.showOpenDialog(this);
//
// if (returnVal == JFileChooser.APPROVE_OPTION) {
//
// try {
// fileOrDirectoryLocationTextfiled.setText(jFileChooser1
// .getSelectedFile().getAbsolutePath());
// } catch (Exception ex) {
// System.out.println("problem accessing file");
// }
// } else {
// System.out.println("File access cancelled by user.");
// }
//
// //DialogForSelectingFileDirectory dsfd = new
// DialogForSelectingFileDirectory();
//

// }
// private void createEvents() {
// configureOpenCalaisBtn.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent arg0) {
// if (opencalaisconfiguration == null) {
// DialogForConfiguringOpenCalais configurOC = new
// DialogForConfiguringOpenCalais();
// configurOC.setModal(true);
// opencalaisconfiguration = configurOC.showDialog();
// } else if (opencalaisconfiguration != null) {
// DialogForConfiguringOpenCalais configurOC = new
// DialogForConfiguringOpenCalais(opencalaisconfiguration);
// configurOC.setModal(true);
// opencalaisconfiguration = configurOC.showDialog();
// }
//
// }//end of action
// });

// startSemanticAnalysisButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// startSemanticsAnalysis();
// }
// });

// btnStartFreeText.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
//
// DialogForAnalyzeFreeText aftd = new DialogForAnalyzeFreeText();
// aftd.setModal(true);
// //aftd.setVisible(true);
// //System.out.println("set if visible");
// String contentToAnalyze = aftd.showDialog();
// startSemanticsAnalysis(contentToAnalyze);
//
// }
// });

// selectFileForAnalysisButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
//
// selectInvidualTextFileForProcessing();
// }
// });

// listFilesAndDirectoryButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// try {
//
// if (fileOrDirectoryLocationTextfiled.getText() != null) {
// File tempfile = new File(
// fileOrDirectoryLocationTextfiled.getText());
//
// if (tempfile.isDirectory()) {
//
// strbif = new StringBuilder();
// iterateandPrintDirectoryandFiles(tempfile
// .listFiles());
//
// DialogForPreviewingText ptd = new DialogForPreviewingText();
//
// File tempfilefordirectory = File.createTempFile(
// "test", "txt");
// tempfilefordirectory.deleteOnExit();
// FileUtils.writeStringToFile(tempfilefordirectory,
// strbif.toString());
//
// ptd.showCustomContentInDialog(tempfilefordirectory);
//
// strbif = null;
//
// }
//
// }
// } catch (Exception e1) {
//
// }
// }
// });
//
//
// selectDirectoryForBatchButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
//
// selectDirectoryToBeProcessed();
// }
// });

// previewTextContentButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// try {
//
// if (fileOrDirectoryLocationTextfiled.getText() != null) {
// File tempfile = new File(
// fileOrDirectoryLocationTextfiled.getText());
//
// if (tempfile.isFile()) {
// DialogForPreviewingText ptd = new DialogForPreviewingText();
// ptd.showCustomContentInDialog(tempfile);
// }
//
// }
// } catch (Exception e1) {
//
// }
// }
// });
// }// EndofCreateEVents....
// protected void selectDirectoryToBeProcessed() {
// JFileChooser jFileChooser1 = new JFileChooser();
// jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
// jFileChooser1.setDialogTitle("Select Directory, please!");
// jFileChooser1.setAcceptAllFileFilterUsed(false);
//
// if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
// // File directoryPath = jFileChooser1.getSelectedFile();
// // OCAO.setDirectoryForBatchProcessing(directoryPath);
// //
// jSelectFileToReadTextTextField.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
// fileOrDirectoryLocationTextfiled.setText(jFileChooser1
// .getSelectedFile().getAbsolutePath());
// } else {
// System.out.println("No Selection ");
// }
//
// }
// private void createEvents() {
// configureOpenCalaisBtn.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent arg0) {
// if (opencalaisconfiguration == null) {
// DialogForConfiguringOpenCalais configurOC = new
// DialogForConfiguringOpenCalais();
// configurOC.setModal(true);
// opencalaisconfiguration = configurOC.showDialog();
// } else if (opencalaisconfiguration != null) {
// DialogForConfiguringOpenCalais configurOC = new
// DialogForConfiguringOpenCalais(opencalaisconfiguration);
// configurOC.setModal(true);
// opencalaisconfiguration = configurOC.showDialog();
// }
//
// }//end of action
// });

// startSemanticAnalysisButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// startSemanticsAnalysis();
// }
// });

// btnStartFreeText.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
//
// DialogForAnalyzeFreeText aftd = new DialogForAnalyzeFreeText();
// aftd.setModal(true);
// //aftd.setVisible(true);
// //System.out.println("set if visible");
// String contentToAnalyze = aftd.showDialog();
// startSemanticsAnalysis(contentToAnalyze);
//
// }
// });

// selectFileForAnalysisButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
//
// selectInvidualTextFileForProcessing();
// }
// });

// listFilesAndDirectoryButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// try {
//
// if (fileOrDirectoryLocationTextfiled.getText() != null) {
// File tempfile = new File(
// fileOrDirectoryLocationTextfiled.getText());
//
// if (tempfile.isDirectory()) {
//
// strbif = new StringBuilder();
// iterateandPrintDirectoryandFiles(tempfile
// .listFiles());
//
// DialogForPreviewingText ptd = new DialogForPreviewingText();
//
// File tempfilefordirectory = File.createTempFile(
// "test", "txt");
// tempfilefordirectory.deleteOnExit();
// FileUtils.writeStringToFile(tempfilefordirectory,
// strbif.toString());
//
// ptd.showCustomContentInDialog(tempfilefordirectory);
//
// strbif = null;
//
// }
//
// }
// } catch (Exception e1) {
//
// }
// }
// });
//
//
// selectDirectoryForBatchButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
//
// selectDirectoryToBeProcessed();
// }
// });

// previewTextContentButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// try {
//
// if (fileOrDirectoryLocationTextfiled.getText() != null) {
// File tempfile = new File(
// fileOrDirectoryLocationTextfiled.getText());
//
// if (tempfile.isFile()) {
// DialogForPreviewingText ptd = new DialogForPreviewingText();
// ptd.showCustomContentInDialog(tempfile);
// }
//
// }
// } catch (Exception e1) {
//
// }
// }
// });
// }// EndofCreateEVents....
