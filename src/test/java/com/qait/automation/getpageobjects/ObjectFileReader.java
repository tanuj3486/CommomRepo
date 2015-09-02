package com.qait.automation.getpageobjects;

import static com.qait.automation.utils.DataReadWrite.getProperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class reads the PageObjectRepository text files. Uses buffer reader.
 *
 * @author QAIT
 *
 */
public class ObjectFileReader {

    private static String tier;
    static String filepath = "src/test/resources/PageObjectRepository/";

    public static String[] getELementFromFile(String pageName,
            String elementName) {
        setTier();
        BufferedReader br = null;
        String returnElement = "";
        try {
            br = new BufferedReader(
                    new FileReader(filepath + tier +File.separator+pageName +".txt"));
            String line = br.readLine();

            while (line != null) {
                if (line.split(":", 3)[0].equalsIgnoreCase(elementName)) {
                    returnElement = line;
                    break;
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return returnElement.split(":", 3);
        // TODO: Handle Arrayoutofbounds and Filenotfound exceptions gracefully.
    }

    public static String getPageTitleFromFile(String pageName) {
        setTier();
        BufferedReader br = null;
        String returnElement = "";
        try {
            br = new BufferedReader(
                    new FileReader(filepath + tier + pageName + ".txt"));
            String line = br.readLine();

            while (line != null) {
                if (line.split(":", 3)[0].equalsIgnoreCase("pagetitle")
                        || line.split(":", 3)[0].equalsIgnoreCase("title")) {
                    returnElement = line;
                    break;
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(returnElement);
        return returnElement.split(":", 3)[1].trim();
    }

    public static String getTier(){
    	setTier();
    	return tier;
    }
    
    private static void setTier() {
    	if(System.getProperty("env")!=null)
    		tier = System.getProperty("env").toUpperCase();
    	else{
	        switch (Tiers.valueOf(getProperty("Config.properties", "tier"))) {
	        case stg:
            case staging:
            case STG:
            case STAGING:
                tier = "STG";
                break;
		default:
			tier = "STG";
			break;
	        }
    	}
    }
}
