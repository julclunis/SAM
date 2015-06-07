package app;



import java.awt.EventQueue;

import javax.swing.UIManager;

import views.SamFrame;

public class SamTool {


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

}
