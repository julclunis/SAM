package app;

import java.awt.EventQueue;

import javax.swing.UIManager;

import models.*;
import controller.SAMController;

import views.SamToolView;



public class SamTool {

	public static void main(String[] args) {
		
		SamToolView theView = new SamToolView();
		OpenCalaisConfigurationModel theOpenCalaisConfigModel = new OpenCalaisConfigurationModel();
		OpenCalaisNERServiceCallModel theOpenCalaisCallModel = new OpenCalaisNERServiceCallModel();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SamToolView frame = new SamToolView();
				
				SAMController sc = new SAMController(theView, theOpenCalaisConfigModel, theOpenCalaisCallModel);
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
