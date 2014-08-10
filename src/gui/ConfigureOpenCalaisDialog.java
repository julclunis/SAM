package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JCheckBox;

import models.SemanticAnalysisProjectConfigurationMetadata;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigureOpenCalaisDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField locationForSaveExtractedDataCSVTextField;
	private JTextField fileSizeMaxForProcessingTextField;
	private JTextField openCalaisApiKeyCodeTextField;
	private JTextField locationForSavingOCJsonCallBackTextField;
private SemanticAnalysisProjectConfigurationMetadata opencalais = new SemanticAnalysisProjectConfigurationMetadata();

	public SemanticAnalysisProjectConfigurationMetadata showDialog(){
		setVisible(true);
		return opencalais;
	}
	
	private void getConfigurationData(){
		
		//opencalais.setFileType(FileType);
		opencalais.setLocationForCallBackToSave(locationForSavingOCJsonCallBackTextField.getText());
		opencalais.setLocationForExtractEntities(locationForSaveExtractedDataCSVTextField.getText());
		opencalais.setOCApiKey(openCalaisApiKeyCodeTextField.getText());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigureOpenCalaisDialog dialog = new ConfigureOpenCalaisDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
	/**
	 * Create the dialog.
	 */
	public ConfigureOpenCalaisDialog() {
		setBounds(100, 100, 571, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel();
			label.setBounds(325, 105, 97, 14);
			contentPanel.add(label);
			label.setText("File Length (97000):");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(11, 176, 122, 14);
			contentPanel.add(label);
			label.setText("OpenCalais API Keycode:");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 92, 206, 14);
			contentPanel.add(label);
			label.setText("Location to Save OpenCalais JSON callback");
		}
		{
			locationForSaveExtractedDataCSVTextField = new JTextField();
			locationForSaveExtractedDataCSVTextField.setBounds(11, 57, 279, 20);
			contentPanel.add(locationForSaveExtractedDataCSVTextField);
		}
		{
			JLabel label = new JLabel();
			label.setBounds(140, 7, 240, 17);
			contentPanel.add(label);
			label.setText("Document Workflow Configuration");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(339, 61, 0, 2);
			contentPanel.add(separator);
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 148, 370, 17);
			contentPanel.add(label);
			label.setText("Configure Opitions for OpenCalais's Semantic Analysis");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			fileSizeMaxForProcessingTextField = new JTextField();
			fileSizeMaxForProcessingTextField.setBounds(380, 117, 42, 20);
			contentPanel.add(fileSizeMaxForProcessingTextField);
			fileSizeMaxForProcessingTextField.setText("97000");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 32, 269, 14);
			contentPanel.add(label);
			label.setText("Location for Extracted Entities Data file --- (RDF or CSV)");
		}
		{
			openCalaisApiKeyCodeTextField = new JTextField();
			openCalaisApiKeyCodeTextField.setBounds(143, 173, 124, 20);
			contentPanel.add(openCalaisApiKeyCodeTextField);
		}
		{
			locationForSavingOCJsonCallBackTextField = new JTextField();
			locationForSavingOCJsonCallBackTextField.setBounds(11, 117, 279, 20);
			contentPanel.add(locationForSavingOCJsonCallBackTextField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						getConfigurationData();
					setVisible(false);
					dispose();
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
