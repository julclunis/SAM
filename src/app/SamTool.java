package app;

import java.awt.EventQueue;

import javax.swing.UIManager;

import controller.SAMController;
import views.SamToolView;



public class SamTool {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SamToolView frame = new SamToolView();
					frame.setVisible(true);
				SAMController sc = new SAMController();
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
