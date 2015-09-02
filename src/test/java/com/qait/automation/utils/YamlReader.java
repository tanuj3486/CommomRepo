/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.utils;

import static com.qait.automation.utils.DataReadWrite.getProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.testng.Reporter;
import org.yaml.snakeyaml.Yaml;

import com.qait.automation.getpageobjects.ObjectFileReader;

@SuppressWarnings("unchecked")
public class YamlReader extends ObjectFileReader{

    public static String yamlFilePath="src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata";
    static String tier = System.getProperty("env");
    static String tier1 = null;

    @SuppressWarnings("resource")
	public static String setYamlFilePath() {
    	if (tier == null) tier1 = getProperty("Config.properties", "tier").trim();
        yamlFilePath = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata";
        if(tier1!=null){
        	tier = tier1 ;
        }
        if (tier.equalsIgnoreCase("CGATEDEV")) {
            yamlFilePath = yamlFilePath+ File.separator +"CGATEDEV_TestData.yml";
        } else if (tier.equalsIgnoreCase("SGATE")) {
        	yamlFilePath = yamlFilePath+ File.separator +"SGATE_TestData.yml";
        } else if (tier.equalsIgnoreCase("pr") || tier.equalsIgnoreCase("pristine")) {
        	yamlFilePath = yamlFilePath+ File.separator +"PR_TestData.yml";
        } else if (tier.equalsIgnoreCase("GATE") || tier.equalsIgnoreCase("gateway")) {
        	yamlFilePath = yamlFilePath+ File.separator +"GATE_TestData.yml";
        } else if (tier.equalsIgnoreCase("UGATE") || tier.equalsIgnoreCase("ugateway")) {
        	yamlFilePath = yamlFilePath+ File.separator  +"UGATE_TestData.yml";
        } else if (tier.equalsIgnoreCase("SGATEDEV") || tier.equalsIgnoreCase("Sgatewaydev") || tier.equalsIgnoreCase("preProd") )
        	yamlFilePath = yamlFilePath+ File.separator  +"SGATEDEV_TestData.yml";
        System.out.println("yaml file path ::"+yamlFilePath);
        try {
			new FileReader(yamlFilePath);
		} catch (FileNotFoundException e) {
			Reporter.log("Wrong Tier.", true);
			System.exit(0);
		}
        return yamlFilePath;
    }

    public static String getYamlValue(String token) {
        try {
            return getValue(token);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static String getData(String token) {
        return getYamlValue(token);
    }

    public static Map<String, Object> getYamlValues(String token) {
        Reader doc;
        try {
            doc = new FileReader(setYamlFilePath());
        } catch (FileNotFoundException ex) {
            System.out.println("File not valid or missing!!!");
            ex.printStackTrace();
            return null;
        }
        Yaml yaml = new Yaml();
        // TODO: check the type casting of object into the Map and create
        // instance in one place
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return parseMap(object, token + ".");
    }

    private static String getValue(String token) throws FileNotFoundException {
    	Reader doc = new FileReader(yamlFilePath);
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return getMapValue(object, token);

    }

    public static String getMapValue(Map<String, Object> object, String token) {
        // TODO: check for proper yaml token string based on presence of '.'
        String[] st = token.split("\\.");
        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    private static Map<String, Object> parseMap(Map<String, Object> object,
            String token) {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]),
                    token.replace(st[0] + ".", ""));
        }
        return object;
    }

    public static int generateRandomNumber(int MinRange, int MaxRange) {
        int randomNumber = MinRange
                + (int) (Math.random() * ((MaxRange - MinRange) + 1));
        return randomNumber;
    }
}
