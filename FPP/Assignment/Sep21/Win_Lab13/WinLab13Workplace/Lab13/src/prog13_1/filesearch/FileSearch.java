package prog13_1.filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
//PSEUDO-CODE
boolean searchForFile(Object file, Object startDir) {
	Object[] fileSystemObjects =
						startDir.getContents();
	for(Object o: fileSystemObjects) {
		//base case
		if(isFile(o) && isSameFile(o,f)) {
			return true;
		}

		if(isDirectory(o)) {
			searchForFile(file, o);
		}
	}
	//file not found in startDir
	return false;
} 
 */
public class FileSearch {
	static boolean found = false;
	//Store the text that is found in the
	//file that is found in this String variable
	static String discoveredText = null;
	public static boolean searchForFile(String filename, String startDir) {
		System.out.println("Starting searching : "+filename + " in "+startDir);
		try {
			File f=new File(filename);
			if(f.exists()) {
				FileReader reader = new FileReader(filename); 
				BufferedReader bufreader = new BufferedReader(reader); 
				String line = null;
				System.out.println("Found that finally");
				discoveredText="";
				while( (line = bufreader.readLine()) != null){
					discoveredText+=line;
				}
				System.out.println("Text in that file : \n\"" + discoveredText + "\"");
				bufreader.close();
				reader.close();
				return true;
			}
			else 
				System.out.println("Can't find that file");
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
		return false;
	}
}