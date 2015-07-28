//Kyle Humphries

package org.eoti.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.GradleException;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class MyJavaTask extends DefaultTask {

    @TaskAction
    public void javaTask() {
    	
    	//Allows use of fields declared in the MyJavaExtention.java file
    	MyJavaExtension extension = getProject().getExtensions().findByType(MyJavaExtension.class);
        if(extension == null)
            extension = new MyJavaExtension();
        //gets the file to look for
        if(getProject().hasProperty("fileName")){

    		extension.setFileName(getProject().getProperties().get("fileName") + "");
    		System.out.print("\n" + extension.getFileName());
    	}
        	//trys to get the current working directory
        	try{
        	extension.setGradleDir(new File(".").getCanonicalPath());
        	}
        	catch(IOException ex){
        		System.out.println (ex.toString());
        		System.out.println("Could not access the directory housing the script.");
        	}

        	System.out.println("\nThe path to the directory being checked is " +extension.getGradleDir() + "\n");
        	//checks for the names of the files
            extension.setTest(new File(extension.getGradleDir()).list());
            
            for(int i=0;i<extension.getTest().length;i++) {
            	//checks for the value input
            	if(extension.getTest()[i].equals(extension.getFileName())) {
            	  	findBooleanValue(extension.getFileName());
     				extension.setFileExists(true);	
     				System.out.println(extension.getFileName() + " was found and checked.");
				}
			}
			//if the value input doesn't exist or if no input was given it checks all .java files
			if(!extension.getFileExists()){
				System.out.println(extension.getFileName() + " was not found, checking all java files.");
				for(int i=0;i<extension.getTest().length;i++) {
					if(extension.getTest()[i].substring(extension.getTest()[i].lastIndexOf(".") + 1, extension.getTest()[i].length()).equals("java")) {
						extension.setCount(extension.getCount() +1);
						findBooleanValue(extension.getTest()[i]);
					}
				}
			System.out.println("\nThere are (is) " + extension.getCount() + " .java files.");
			}
	}
	//method to check for the boolean varibles in question
	public boolean findBooleanValue(String name_of_file){

		System.out.println(name_of_file);
		
		//find the boolean variable in the file
		try{
			Scanner file = new Scanner( new File(name_of_file) );
			while(file.hasNextLine()) {
				if(file.hasNext("boolean")) {
					Pattern pattern = Pattern.compile("(boolean\\s+testBool(1|2|3|4|5|6|7)*\\s*=\\s*(true|false)\\s*;)");
            		Matcher matcher = pattern.matcher(file.nextLine());
            		if(matcher.find()) {
            			System.out.println("\t" +matcher.group(0));
            			throw new GradleException("Boolean flag was found and build was aborted.");
					}
				}
				else{
					file.nextLine();
				}
			}
			file.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(ex.toString());
			System.out.println("No File by that name found");
		}
	return true;
	}	
		
	    
}


