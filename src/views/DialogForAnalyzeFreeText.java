package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogForAnalyzeFreeText extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JTextArea textArea;
	private JButton cancelButton;

	public DialogForAnalyzeFreeText() {
		initGuiComponents();
		createEventsforthis();
		
	}

	private void initGuiComponents() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Scrollbar scrollbar = new Scrollbar();
			scrollbar.setBounds(410, 11, 17, 207);
			contentPanel.add(scrollbar);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(10, 11, 417, 207);
			contentPanel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

	private void createEventsforthis()
	{
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("content return" + textArea.getText().substring(0, 33));
				setVisible(false);
				dispose();
			}

		
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
	}
	
	public String showDialog(){
		setVisible(true);
		return textArea.getText();
	}
}




//######################################################
//public static void main(String[] args) {
//try {
//	DialogForAnalyzeFreeText dialog = new DialogForAnalyzeFreeText();
//	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//	dialog.setVisible(true);
//} catch (Exception e) {
//	e.printStackTrace();
//}
//}
