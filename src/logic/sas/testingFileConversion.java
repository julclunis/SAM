package logic.sas;

import com.teragram.fileconverter.Test;

public class testingFileConversion {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			
			try {
				String[] ffo = new String[3];
		ffo[0] = "localhost";
		ffo[1] = "54321";
		ffo[2] = "C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\02 - Documents for Processing\\Egypt Wikileaked Cables\\2Anger And Different Explanations Over Qiz Implementation Delay.docx";
		
		
		String[] ofone = new String[1];
		ofone[0] = "--server localhost:54321 \"C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\02 - Documents for Processing\\Egypt Wikileaked Cables\\2Anger And Different Explanations Over Qiz Implementation Delay.docx\"";
			
					Test f = new Test();
				f.main(ofone);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		System.out.println(e1.getMessage());
			}
	
		
	}

}
