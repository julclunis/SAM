package app;

import java.awt.EventQueue;

import javax.swing.UIManager;

import controller.SAMController;
import models.OpenCalaisConfigurationModel;
import views.SamFrame;
import views.SamToolView;
import models.OpenCalaisConfigurationModel;
import models.OpenCalaisNERServiceCallModel;

public class SamTool {

	
	static private SamFrame frame;
	static private SamToolView mainSTView;
	static private OpenCalaisConfigurationModel openCalaisConfig;
	static private OpenCalaisNERServiceCallModel openCalaisServiceLogic;
	static private SAMController samcontrol;
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					openCalaisConfig = new OpenCalaisConfigurationModel();
					openCalaisServiceLogic = new OpenCalaisNERServiceCallModel();
					mainSTView = new SamToolView();
					frame = new SamFrame(mainSTView);
					
					samcontrol = new SAMController(frame, openCalaisConfig, openCalaisServiceLogic);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
