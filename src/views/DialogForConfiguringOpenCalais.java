package views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import models.OpenCalaisConfigurationModel;

@SuppressWarnings("serial")
public class DialogForConfiguringOpenCalais extends JDialog {


	private final JPanel contentPanel = new JPanel();

	private JTextField locationForSaveExtractedDataCSVTextField;
	private JTextField fileSizeMaxForProcessingTextField;
	private JTextField openCalaisApiKeyCodeTextField;
	private JTextField locationForSavingOCJsonCallBackTextField;

	private OpenCalaisConfigurationModel opencalais = null;
	private OpenCalaisConfigurationModel savedConfiguration = null;

	private JButton okButton;
	private JButton cancelButton;

	public DialogForConfiguringOpenCalais() {
		opencalais = new OpenCalaisConfigurationModel();
		initComponents();
		createEvents();

	}

	public DialogForConfiguringOpenCalais(
			OpenCalaisConfigurationModel savedConfig) {
		this();

		savedConfiguration = savedConfig;
		locationForSavingOCJsonCallBackTextField.setText(savedConfig
				.getLocationForCallBackToSave().toString());
		locationForSaveExtractedDataCSVTextField.setText(savedConfig
				.getLocationForExtractEntities().toString());
		openCalaisApiKeyCodeTextField.setText(savedConfig.getOCApiKey()
				.toString());
		fileSizeMaxForProcessingTextField.setText(savedConfig
				.getMaxSizeForDocPerOCCall().toString());
	}

	private void initComponents() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 571, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel();
			label.setBounds(11, 176, 122, 14);
			contentPanel.add(label);
			label.setText("OpenCalais API Keycode:");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(11, 57, 206, 14);
			contentPanel.add(label);
			label.setText("Location to Save OpenCalais JSON callback");
		}
		{
			locationForSaveExtractedDataCSVTextField = new JTextField();
			locationForSaveExtractedDataCSVTextField.setBounds(11, 26, 279, 20);
			contentPanel.add(locationForSaveExtractedDataCSVTextField);
		}
		{
			JLabel label = new JLabel();
			label.setBounds(11, 90, 369, 20);
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
			JLabel lblLocationForExtracted = new JLabel();
			lblLocationForExtracted.setBounds(10, 11, 269, 14);
			contentPanel.add(lblLocationForExtracted);
			lblLocationForExtracted.setText("Location for Extracted Entities Data file --- (CSV)");
		}
		{
			openCalaisApiKeyCodeTextField = new JTextField();
			openCalaisApiKeyCodeTextField.setBounds(143, 173, 124, 20);
			contentPanel.add(openCalaisApiKeyCodeTextField);
		}
		{
			locationForSavingOCJsonCallBackTextField = new JTextField();
			locationForSavingOCJsonCallBackTextField
					.setBounds(11, 71, 279, 20);
			contentPanel.add(locationForSavingOCJsonCallBackTextField);
		}
		{
			fileSizeMaxForProcessingTextField = new JTextField();
			fileSizeMaxForProcessingTextField.setBounds(143, 198, 42, 20);
			contentPanel.add(fileSizeMaxForProcessingTextField);
			fileSizeMaxForProcessingTextField.setText("97000");
		}
		{
			JLabel label = new JLabel();
			label.setBounds(10, 201, 97, 14);
			contentPanel.add(label);
			label.setText("File Length (97000):");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 218, 434, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				okButton = new JButton("OK");

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void createEvents() {

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// getConfigurationData();
				// opencalais.setFileType(FileType);
				opencalais
						.setLocationForCallBackToSave(locationForSavingOCJsonCallBackTextField
								.getText());
				opencalais
						.setLocationForExtractEntities(locationForSaveExtractedDataCSVTextField
								.getText());
				opencalais.setOCApiKey(openCalaisApiKeyCodeTextField.getText());
				opencalais
						.setMaxSizeForDocPerOCCall(fileSizeMaxForProcessingTextField
								.getText().trim());
				setVisible(false);
				dispose();

				printoutsettingsinfo();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (savedConfiguration == null) {
					opencalais = null;
				} else {
					opencalais = savedConfiguration;
				}
				setVisible(false);
			}
		});

	}// end of attaching events to components

	private void printoutsettingsinfo() {

		System.out.println("printing opencalais confiruation information.....");
		System.out.println("location for saving json callback: "
				+ locationForSavingOCJsonCallBackTextField.getText());
		System.out.println("location for saving results from : "
				+ locationForSaveExtractedDataCSVTextField.getText());
		System.out.println("Code for API: "
				+ openCalaisApiKeyCodeTextField.getText().trim());
		System.out.println("File Size for processing: "
				+ fileSizeMaxForProcessingTextField.getText().trim());

	}

	public OpenCalaisConfigurationModel showDialog() {
		setVisible(true);
		return opencalais;
	}

}

// public static void main(String[] args) {
// try {
// ConfigureOpenCalaisDialog dialog = new ConfigureOpenCalaisDialog();
// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
// dialog.setVisible(true);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }