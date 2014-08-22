package logic.sas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.teragram.fileconverter.Client;
import com.teragram.fileconverter.Exception;
import com.teragram.fileconverter.Input;
import com.teragram.fileconverter.Output;

public class ConvertDocsToTxt {



	static private String textfile = "C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\02 - Documents for Processing\\Egypt Wikileaked Cables\\2Anger And Different Explanations Over Qiz Implementation Delay.docx";


	public static void main(String[] args) {

		Client clientForFC = new Client("localhost", 54321);

		try {
			InputStream inputstre = new FileInputStream(textfile);

			Input inputfile = new Input();
			byte[] fffff = IOUtils.toByteArray(inputstre);

			// inputstre.close();
			inputfile.content = fffff;

			Output outputhere = clientForFC.convert(inputfile);

			System.out.print(outputhere.text);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

			System.out.println(e1.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
