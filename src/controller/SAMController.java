package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.OpenCalaisConfigurationModel;
import models.OpenCalaisNERServiceCallModel;
import views.DialogForAnalyzeFreeText;
import views.SamFrame;
import views.SamToolView;

public class SAMController {

	private SamFrame frame;
	// private SamToolView mainSTView;
	private OpenCalaisConfigurationModel openCalaisConfig;
	private OpenCalaisNERServiceCallModel openCalaisServiceLogic;
	private DialogForAnalyzeFreeText freeTextAnalysisDialog;
	

	public SAMController(SamFrame samFrame,
			OpenCalaisConfigurationModel config,
			OpenCalaisNERServiceCallModel context) {
		this.frame = samFrame;

		this.openCalaisConfig = config;
		this.openCalaisServiceLogic = context;

		ListenForStartButtonListener som = new ListenForStartButtonListener();
		this.frame.getSamToolViewFromFrame().addStartSemanticAnalysisListern(som);
		this.frame.getSamToolViewFromFrame().addSelectCopyAndPasteBtn(new ListenForCopyAndPasteAnalysisButtonListener());

	}

	class ListenForStartButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
				System.out.println("action started from btnStartOpenCalaissNer");

				// add the logic to start the OpenCalaisNerServiceCallModel.
				// It might be just making sure the config, save points. and
				// inputfile location.
				//
			}

			catch (NumberFormatException ex) {

				System.out.println(ex);

			}

		}

	}
	
	class ListenForCopyAndPasteAnalysisButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
				System.out.println("action started for copy and paste functionalight");

		//i need to add logic in capturing the copy and paste function .... then 
					//Display results
					//Save Results
			}

			catch (NumberFormatException ex) {

				System.out.println(ex);

			}

		}

	}

}

