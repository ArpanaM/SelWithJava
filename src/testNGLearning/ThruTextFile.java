package testNGLearning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class ThruTextFile {

	File fc;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	String src="D:\\2023\\Sel@9AM(IST)\\data.txt";
	@Test
	public void readFrmTxtFile() throws IOException
	{
		//create a new file
		fc=new File(src);
		fc.createNewFile();
		//write content to the file
		//create an objects for FileWriter and BufferedWriter classes.
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		bw.write("This is my First Line");
		bw.newLine();
		bw.write("This is my Second Line");
		bw.newLine();
		bw.write("This is my Third Line");
		bw.close();
		
		
		//read the content from the file
		//create an objects for FileReader and BufferedReader classes.
		
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		
		String cont=null;
		while((cont=br.readLine())!=null)
		{
			System.out.println(cont);
		}
		br.close();
	}
}
