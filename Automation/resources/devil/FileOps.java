package devil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOps {
	public static void CreateDirectory(String path) {
		File file = new File(path);
        if (!file.exists()) {
            if (file.mkdirs()) {
                //System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void deletedirectory(File directory) {
	    File[] files = directory.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	            	deletedirectory(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    directory.delete();
	}
	
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

}
