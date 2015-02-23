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

	
}
