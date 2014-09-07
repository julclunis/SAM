package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.UIManager;

import logic.openCalais.SamOpenCalaisEntityExtractionViewModel;
import models.SemanticAnalysisProjectConfigurationMetadata;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Toolkit;

public class SamFrame extends JFrame {

	private JPanel contentPane;
	private SemanticAnalysisProjectConfigurationMetadata opencalaisconfiguration;
	private SamOpenCalaisEntityExtractionViewModel logic;
	private SAOPCAC saopcac;
	private JButton configureOpenCalaisBtn;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SamFrame frame = new SamFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}


	public SamFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SamFrame.class.getResource("/gui/resources/samtitlepic32x32.png")));
		setTitle("SAM Utility Tool");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu menu = new JMenu("NLP");
		menuBar.add(menu);

		JRadioButton rdbtnOpencalaisWebService = new JRadioButton(
				"OpenCalais Web Service");
		rdbtnOpencalaisWebService.setSelected(true);
		menu.add(rdbtnOpencalaisWebService);

		JMenu menu_1 = new JMenu("Configure");
		menuBar.add(menu_1);

		configureOpenCalaisBtn = new JButton(
				"Configure OpenCalais Connection");
		
		menu_1.add(configureOpenCalaisBtn);

		JMenu mnAnalyze = new JMenu("Analyze");
		menuBar.add(mnAnalyze);

		JButton startSemanticAnalysisButton = new JButton(
				"Start Semantic Analysis");

		startSemanticAnalysisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				startSemanticsAnalysis();
			}
		});
		mnAnalyze.add(startSemanticAnalysisButton);

		JButton btnStartFreeText = new JButton("Start Free Text Analysis");
		btnStartFreeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analyzeCopyAndPasteText();
			}
		});
		mnAnalyze.add(btnStartFreeText);

		saopcac = new SAOPCAC();
		contentPane.add(saopcac, BorderLayout.CENTER);
		
		
		createEvents();

	}

	protected void startSemanticsAnalysis() {

		logic = new SamOpenCalaisEntityExtractionViewModel();

	logic.setSam(opencalaisconfiguration);
			logic.getSam().setLocationForCallBackToSave(
					opencalaisconfiguration.getLocationForCallBackToSave());
			logic.getSam().setLocationForExtractEntities(
					opencalaisconfiguration.getLocationForExtractEntities());
			logic.getSam().setOCApiKey(opencalaisconfiguration.getOCApiKey());

	
		if (saopcac.getFileOrDirectoryLocationTextfiled().getText() != null) {
			File tempfile = new File(saopcac
					.getFileOrDirectoryLocationTextfiled().getText());

			if (tempfile.isDirectory()) {
				logic.setDirectoryForBatchProcessing(tempfile);
			} else if (tempfile.isFile()) {

				logic.setFileMain(tempfile);
			}

			logic.initiateAndProcessOpenCalaisCall();

		} else {
			System.out.println("file text field is null");
		}

		// check to see if textfield is directory for batch or file for single
		// processing

		// then initlaize
	}

	private SemanticAnalysisProjectConfigurationMetadata getConfigurationForOpenCalais() {
		ConfigureOpenCalaisDialog configurOC = new ConfigureOpenCalaisDialog();
		configurOC.setModal(true);
		
	
		return configurOC.showDialog();
	}

	private void analyzeCopyAndPasteText() {
		AnalyzeFreeTextDialog aftd = new AnalyzeFreeTextDialog();
		aftd.setVisible(true);
	}

	public SAOPCAC getSaopcac() {
		return saopcac;
	}

	
	private  void createEvents(){
		configureOpenCalaisBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opencalaisconfiguration	= getConfigurationForOpenCalais();
			}
		});
	}
}
