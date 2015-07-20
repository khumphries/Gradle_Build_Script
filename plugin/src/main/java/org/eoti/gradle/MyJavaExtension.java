package org.eoti.gradle;

import org.gradle.api.*;

public class MyJavaExtension
{
    private String gradleDir = "";
    
    public String getGradleDir(){return gradleDir;}
    public void setGradleDir(String gradleDir){this.gradleDir = gradleDir;}

    private int count = 0;
    
    public int getCount(){return count;}
    public void setCount(int count){this.count = count;}

    private String[] test = null;
    
    public String[] getTest(){return test;}
    public void setTest(String[] test){this.test = test;}

    private String fileName = "NOT_A_FILE";

    public String getFileName(){return fileName;}
    public void setFileName(String fileName){this.fileName = fileName;}

    private boolean fileExists = false;

    public boolean getFileExists(){return fileExists;}
    public void setFileExists(boolean fileExists){this.fileExists = fileExists;}
}


