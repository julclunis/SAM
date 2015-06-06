package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;

import models.SamOpenCalaisEntityExtractionViewModel;
import models.SemanticAnalysisProjectConfigurationMetadata;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;

public class SamFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private SemanticAnalysisProjectConfigurationMetadata opencalaisconfiguration;
	private SamOpenCalaisEntityExtractionViewModel logic;
	
	private OpenCalaisSemanticApp saopcac;
	
	private JButton configureOpenCalaisBtn;
	private JButton startSemanticAnalysisButton;
	private JButton btnStartFreeText;

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
		
		initGuiComponents();
		createEvents();

	}

	private void initGuiComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SamFrame.class.getResource("/gui/resources/samtitlepic32x32.png")));
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

		configureOpenCalaisBtn = new JButton("Configure OpenCalais Connection");
		menu_1.add(configureOpenCalaisBtn);

		JMenu mnAnalyze = new JMenu("Analyze");
		menuBar.add(mnAnalyze);

		startSemanticAnalysisButton = new JButton("Start Semantic Analysis");
		mnAnalyze.add(startSemanticAnalysisButton);

		btnStartFreeText = new JButton("Start Free Text Analysis");
		mnAnalyze.add(btnStartFreeText);

		saopcac = new OpenCalaisSemanticApp();
		contentPane.add(saopcac, BorderLayout.CENTER);
	}

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
}
