package views;



import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import org.apache.commons.io.FileUtils;

import views.DialogForAnalyzeFreeText;
import views.DialogForConfiguringOpenCalais;
import models.OpenCalaisNERServiceCallModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;

import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;



public class SamFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private models.OpenCalaisConfigurationModel opencalaisconfiguration;
	private models.OpenCalaisNERServiceCallModel logic;
	
	private SamToolView saopcac;
	private SamToolView saopcac_1;

	

	public SamFrame(SamToolView stv) {
		this.saopcac = stv; 
		initGuiComponents();
		//createEvents();

	}

	private void initGuiComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SamFrame.class.getResource("/resources/samtitlepic32x32.png")));
		setTitle("SAM Utility Tool");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 483);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar_1.add(mnMenu);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("testhereyo");
			}
		});

		
		mnMenu.add(mntmAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnMenu.add(mntmHelp);
	
		JMenuBar menuBar = new JMenuBar();
		
		contentPane = new JPanel();

		
		contentPane.add(menuBar, BorderLayout.NORTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
	
					saopcac_1 = new SamToolView();
		contentPane.add(saopcac_1, BorderLayout.CENTER);
		
	
		setContentPane(contentPane);

	}



	protected void startSemanticsAnalysis() {
		configureOpenCalaisEngine();
		if (saopcac_1.getDirectoryOrFileLocation().getText() != null) {
			File tempfile = new File(saopcac_1.getDirectoryOrFileLocation().getText());
			
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
		
		logic = new OpenCalaisNERServiceCallModel();
		logic.setSam(opencalaisconfiguration);
		logic.getSam().setLocationForCallBackToSave(
				opencalaisconfiguration.getLocationForCallBackToSave());
		logic.getSam().setLocationForExtractEntities(
				opencalaisconfiguration.getLocationForExtractEntities());
		logic.getSam().setOCApiKey(opencalaisconfiguration.getOCApiKey());
		
	}
	

	public SamToolView getSamToolViewFromFrame() {
		return saopcac_1;
	}
}
