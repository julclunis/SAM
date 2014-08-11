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

import logic.SamOpenCalaisEntityExtractionViewModel;
import models.SemanticAnalysisProjectConfigurationMetadata;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SamFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	SemanticAnalysisProjectConfigurationMetadata opencalaisconfiguration;
	SamOpenCalaisEntityExtractionViewModel logic;
	
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public SamFrame() {
		
		logic = new SamOpenCalaisEntityExtractionViewModel();
	
		
		
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
		
		JRadioButton rdbtnOpencalaisWebService = new JRadioButton("OpenCalais Web Service");
		rdbtnOpencalaisWebService.setSelected(true);
		menu.add(rdbtnOpencalaisWebService);
		
		JMenu menu_1 = new JMenu("Configure");
		menuBar.add(menu_1);
		
		JButton configureOpenCalaisBtn = new JButton("Configure OpenCalais Connection");
		configureOpenCalaisBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigureOpenCalaisDialog configurOC = new ConfigureOpenCalaisDialog();
				
			
				opencalaisconfiguration = configurOC.showDialog();
				
		
				
			}
		});
		menu_1.add(configureOpenCalaisBtn);
		
		JMenu mnAnalyze = new JMenu("Analyze");
		menuBar.add(mnAnalyze);
		
		JButton startSemanticAnalysisButton = new JButton("Start Semantic Analysis");
		
		//action for 
		startSemanticAnalysisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		mnAnalyze.add(startSemanticAnalysisButton);
		
		JButton btnStartFreeText = new JButton("Start Free Text Analysis");
		btnStartFreeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnalyzeFreeTextDialog aftd = new AnalyzeFreeTextDialog();
				aftd.setVisible(true);
			}
		});
		mnAnalyze.add(btnStartFreeText);
		
		SAOPCAC saopcac = new SAOPCAC();
		contentPane.add(saopcac, BorderLayout.CENTER);
		
	//System.out.println(	saopcac.getComponents());
		
		
		
		
	}

}
