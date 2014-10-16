package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class DialogForPreviewingText extends JDialog {
	
	
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	private JButton closeButton;

	public DialogForPreviewingText() {
	
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 410);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				closeButton = new JButton("Close");
				closeButton.setActionCommand("OK");
				buttonPane.add(closeButton);
				getRootPane().setDefaultButton(closeButton);
			}
		}
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(textArea);
		
		createEvents();
	}

	private void createEvents(){
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}


	public void showCustomContentInDialog(File fileToRead) {

		this.setVisible(true);
		try {
			textArea.read(new FileReader(fileToRead), null);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public JTextArea getTextArea() {
		return textArea;
	}
}


//File fileToRead
//showCustomContentInDialog(fileToRead);

// Auto-generated catch block
// Auto-generated catch block
//
///**
// * Launch the application.
// */
//public static void main(String[] args) {
//	try {
//		DialogForPreviewingText dialog = new DialogForPreviewingText();
//		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		dialog.setVisible(true);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}
//
///**
// * Create the dialog.
// */