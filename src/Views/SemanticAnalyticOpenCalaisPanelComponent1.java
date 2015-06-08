/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewModels.SamOpenCalaisEntityExtractionViewModel;
import Models.SemanticAnalysisProjectConfigurationMetadata;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class SemanticAnalyticOpenCalaisPanelComponent1 extends
		javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SamOpenCalaisEntityExtractionViewModel OCAO = null;
	private StringBuilder strbif = null;

	public SemanticAnalyticOpenCalaisPanelComponent1() {
		initComponents();

		OCAO = new SamOpenCalaisEntityExtractionViewModel();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jFileChooser1 = new javax.swing.JFileChooser();
		jResultsPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jLabel3 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jCheckBox2 = new javax.swing.JCheckBox();
		jLabel12 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jStartOpenCalaisServiceCallButton = new javax.swing.JButton();
		jCheckBox3 = new javax.swing.JCheckBox();
		jSeparator2 = new javax.swing.JSeparator();
		jPanel2 = new javax.swing.JPanel();
		jExtractTextToTextFieldButton = new javax.swing.JButton();
		jStartSelectTextFileDialogForTextButton = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel9 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jSelectFileToReadTextTextField = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		jLabel1 = new javax.swing.JLabel();
		jButton5 = new javax.swing.JButton();

		jResultsPanel4.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));

		jScrollPane1.setViewportView(jTextPane1);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel3.setText("Results / log - output");

		jButton3.setForeground(new java.awt.Color(255, 0, 51));
		jButton3.setText("save");

		jButton4.setForeground(new java.awt.Color(255, 0, 51));
		jButton4.setText("clear");

		javax.swing.GroupLayout jResultsPanel4Layout = new javax.swing.GroupLayout(
				jResultsPanel4);
		jResultsPanel4.setLayout(jResultsPanel4Layout);
		jResultsPanel4Layout
				.setHorizontalGroup(jResultsPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jResultsPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jResultsPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jResultsPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addGap(48,
																				48,
																				48)
																		.addComponent(
																				jButton3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton4)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addComponent(
																jScrollPane1))
										.addContainerGap()));
		jResultsPanel4Layout
				.setVerticalGroup(jResultsPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jResultsPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jResultsPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(jButton3)
														.addComponent(jButton4))
										.addGap(7, 7, 7)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												149, Short.MAX_VALUE)
										.addContainerGap()));

		jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(
				0, 0, 0), 1, true));

		jLabel10.setText("Location to Save OpenCalais JSON callback");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel2.setText("Configure Opitions for OpenCalais's Semantic Analysis");

		jLabel4.setText("Location for Extracted Entities Data file --- (RDF or CSV)");

		jLabel5.setText("OpenCalais API Keycode:");

		jLabel7.setText("File Length (97000):");

		jTextField5.setText("97000");

		jCheckBox2.setForeground(new java.awt.Color(204, 0, 51));
		jCheckBox2.setSelected(true);
		jCheckBox2.setText("Include Social Tags");

		jLabel12.setForeground(new java.awt.Color(255, 0, 51));
		jLabel12.setText("File Type (RDF or CSV):");

		jTextField2.setText("CSV");

		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel11.setText("Document Workflow Configuration");

		jStartOpenCalaisServiceCallButton.setText("Analyze txt File");
		jStartOpenCalaisServiceCallButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						startOpenCalaisServiceCallButtonActionPerformed(evt);
					}
				});

		jCheckBox3.setForeground(new java.awt.Color(255, 0, 51));
		jCheckBox3.setSelected(true);
		jCheckBox3.setText("Include Releanvacy Score");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel7)
														.addComponent(jLabel5))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jTextField4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								448,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel11))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jSeparator2)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jLabel2))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jTextField5,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												56,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(111,
																												111,
																												111)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jCheckBox3)
																														.addComponent(
																																jCheckBox2))
																										.addGap(379,
																												379,
																												379)
																										.addComponent(
																												jStartOpenCalaisServiceCallButton))
																						.addComponent(
																								jLabel4)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												448,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												56,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel12))
																						.addComponent(
																								jTextField3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								159,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(0,
																				20,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel11)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel10)
																		.addGap(6,
																				6,
																				6)
																		.addComponent(
																				jTextField4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel4)
										.addGap(6, 6, 6)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel12))
										.addGap(9, 9, 9)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel2)
														.addComponent(
																jSeparator2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																10,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel5)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jCheckBox2)
														.addComponent(jLabel7)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jCheckBox3)
														.addComponent(
																jStartOpenCalaisServiceCallButton))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(
				0, 0, 0), 1, true));

		jExtractTextToTextFieldButton.setText("Preview Text");
		jExtractTextToTextFieldButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						readFileTextAndPrintToTextPanel(evt);
					}
				});

		jStartSelectTextFileDialogForTextButton
				.setText("Select File be analyzed");
		jStartSelectTextFileDialogForTextButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						selectTextFileDialogForTextButtonActionPerformed(evt);
					}
				});

		jLabel8.setText("Select File or Directory to be Analyzed");

		jCheckBox1.setForeground(new java.awt.Color(255, 0, 51));
		jCheckBox1.setSelected(true);
		jCheckBox1.setText("Include Sub-directories");

		jButton1.setText("Select  Directory");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectDirecotryTobeProcessed(evt);
			}
		});

		jButton2.setText("List File and Directory");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				printListingOfDirectoryButton2ActionPerformed(evt);
			}
		});

		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		jLabel9.setText("By Single File");

		jLabel13.setText("By Batch Process");

		jSelectFileToReadTextTextField.setName(""); // NOI18N

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel14.setText("SAM");

		jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel15.setText("Utility Tool");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jSelectFileToReadTextTextField)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel2Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jStartSelectTextFileDialogForTextButton)
																														.addComponent(
																																jExtractTextToTextFieldButton,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel9,
																																javax.swing.GroupLayout.Alignment.TRAILING))
																										.addGap(38,
																												38,
																												38)
																										.addComponent(
																												jSeparator1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												23,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(18,
																												18,
																												18)
																										.addGroup(
																												jPanel2Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel13)
																														.addComponent(
																																jButton1,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jButton2,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jCheckBox1)))
																						.addComponent(
																								jLabel8))
																		.addGap(0,
																				21,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel14)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addGap(10,
																												10,
																												10)
																										.addComponent(
																												jLabel15)))))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel14,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												36,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel15)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jSeparator1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																110,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel8)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jSelectFileToReadTextTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel9)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jStartSelectTextFileDialogForTextButton)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jExtractTextToTextFieldButton))
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel13)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jButton1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jButton2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jCheckBox1)))))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(
				0, 0, 0), 1, true));
		jPanel5.setPreferredSize(new java.awt.Dimension(800, 690));

		jLabel6.setText("Enter Text to Analyze");

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel1.setText("Unstructured Data to be Analyzied by OpenCalais");

		jButton5.setText("clear");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearContentFromTextPanel(evt);
			}
		});
		
		tempFileNameField = new JTextField();
		tempFileNameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("File Name:");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5Layout.setHorizontalGroup(
			jPanel5Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel5Layout.createSequentialGroup()
							.addComponent(jButton5)
							.addGap(374)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tempFileNameField, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel5Layout.createSequentialGroup()
							.addComponent(jLabel6)
							.addGap(211)
							.addComponent(jLabel1)))
					.addContainerGap())
		);
		jPanel5Layout.setVerticalGroup(
			jPanel5Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(9)
					.addGroup(jPanel5Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tempFileNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel))
						.addComponent(jButton5))
					.addContainerGap())
		);
		jTextForOpenCalaisToAnalyzeTextPane = new javax.swing.JTextPane();
		jScrollPane4.setViewportView(jTextForOpenCalaisToAnalyzeTextPane);
		jPanel5.setLayout(jPanel5Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(0)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1091, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jPanel5, 0, 0, Short.MAX_VALUE)))
					.addContainerGap(4, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel5, 0, 0, Short.MAX_VALUE)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	
	private void selectTextFileDialogForTextButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jStartSelectTextFileDialogForTextButtonActionPerformed
		// select single file for analysis
		jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = jFileChooser1.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser1.getSelectedFile();
			try {

				OCAO.setFileMain(file);
				jSelectFileToReadTextTextField.setText(file.getAbsolutePath());

			} catch (Exception ex) {
				System.out.println("problem accessing file"	+ file.getAbsolutePath());
			}
		} else {
			System.out.println("File access cancelled by user.");
		}

	}// GEN-LAST:event_jStartSelectTextFileDialogForTextButtonActionPerformed
	private void selectDirecotryTobeProcessed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
			// select directory for batch processing of documents.
		
		jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jFileChooser1.setDialogTitle("Select Directory, please!");
		jFileChooser1.setAcceptAllFileFilterUsed(false);

		if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File directoryPath = jFileChooser1.getSelectedFile();
			OCAO.setDirectoryForBatchProcessing(directoryPath);
			jSelectFileToReadTextTextField.setText(jFileChooser1.getSelectedFile().getAbsolutePath());

		} else {
			System.out.println("No Selection ");
		}

	}// GEN-LAST:event_jButton1ActionPerformed
	private void readFileTextAndPrintToTextPanel(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jExtractTextToTextFieldButtonActionPerformed
		// preview text content in the textpanel
		try {
			if (OCAO.getFileMain() != null	& OCAO.getFileMain().isDirectory() == false) {
				jTextForOpenCalaisToAnalyzeTextPane.read(new FileReader(OCAO.getFileMain()), null);
			}
		} catch (Exception e) {
		}

	}// GEN-LAST:event_jExtractTextToTextFieldButtonActionPerformed
	private void startOpenCalaisServiceCallButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jStartOpenCalaisServiceCallButtonActionPerformed
		// create and populate config info, decide text, file, or batch processing, and initiate the analysis.
		OCAO.setSam(new SemanticAnalysisProjectConfigurationMetadata());

		OCAO.getSam().setFileType(jTextField2.getText());
		OCAO.getSam().setIncludeSocialTags(jCheckBox2.isSelected());
		OCAO.getSam().setLocationForCallBackToSave(jTextField4.getText());
		OCAO.getSam().setLocationForExtractEntities(jTextField1.getText());
		OCAO.getSam().setMaxSizeForDocPerOCCall(jTextField5.getText());
		OCAO.getSam().setOCApiKey(jTextField3.getText());

		if (OCAO.getFileMain() != null | OCAO.getDirectoryForBatchProcessing() != null) {
			
			OCAO.initiateAndProcessOpenCalaisCall();
		} 
		else if (jTextForOpenCalaisToAnalyzeTextPane.getText().isEmpty() != true) {
				
			File tempfile = null;
			
				try {
			
				if (tempFileNameField.getText().isEmpty() != true) {
					tempfile = new File(tempFileNameField.getText());
					BufferedWriter output = new BufferedWriter(new FileWriter(tempfile));
					output.write(jTextForOpenCalaisToAnalyzeTextPane.getText());
					output.close();
				} else {
					tempfile = new File("example - file name");
					BufferedWriter output = new BufferedWriter(new FileWriter(tempfile));
					output.write(jTextForOpenCalaisToAnalyzeTextPane.getText());
					output.close();
				}
			

				OCAO.setFileMain(tempfile);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			OCAO.initiateAndProcessOpenCalaisCall();

		} else {
			System.out.println("Please There is nothing to select?");
		}
	}// GEN-LAST:event_jStartOpenCalaisServiceCallButtonActionPerformed

	private void printListingOfDirectoryButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed

		strbif = new StringBuilder();
		System.out.println(OCAO.getDirectoryForBatchProcessing().listFiles().length);
		buildListOfFilesAndDirectoriesRecurivlyForStringBuilder(OCAO.getDirectoryForBatchProcessing().listFiles());

		jTextForOpenCalaisToAnalyzeTextPane.setText(strbif.toString());
		strbif = null;

	}// GEN-LAST:event_jButton2ActionPerformed
	private void clearContentFromTextPanel(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		// this button action clears the text pane of content.
		jTextForOpenCalaisToAnalyzeTextPane.setText("");
	}// GEN-LAST:event_jButton5ActionPerformed
	private void buildListOfFilesAndDirectoriesRecurivlyForStringBuilder(File[] sourfilestuff) {
		for (File perfile : sourfilestuff) {
			if (perfile.isDirectory()) {
				strbif = strbif.append(perfile.getAbsolutePath());
				strbif = strbif.append("\n");
				buildListOfFilesAndDirectoriesRecurivlyForStringBuilder(perfile.listFiles());
			} else {
				strbif = strbif.append("-----");
				strbif = strbif.append(perfile.getAbsolutePath());
				strbif = strbif.append("\n");
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JButton jExtractTextToTextFieldButton;
	private javax.swing.JFileChooser jFileChooser1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jResultsPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTextField jSelectFileToReadTextTextField;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JButton jStartOpenCalaisServiceCallButton;
	private javax.swing.JButton jStartSelectTextFileDialogForTextButton;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextPane jTextForOpenCalaisToAnalyzeTextPane;
	private javax.swing.JTextPane jTextPane1;
	private JTextField tempFileNameField;
}