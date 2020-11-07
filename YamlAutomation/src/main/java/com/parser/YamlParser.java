package com.parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.yaml.snakeyaml.Loader;
import org.yaml.snakeyaml.Yaml;

public class YamlParser {

	public static int count=0;
	//public static final String fileName = "thankyou";
	//public static final String prefix = "CB_THANKYOU_";
	public static Map<String, String> map;
	public static Map<String, String> messages;
	public static Map<String, Object> newObject;
	public static StringBuilder keyValue;
	public static StringBuilder keyValue1;
	public static StringBuilder yamlStr;

	public static void main(String[] args) throws IOException {
		
		automate();
		
		}
		
		public static void automate() throws IOException {
			
			listIterator("meals-ssrcodes","CB_MEALS_SSRCODES_");
			countryMapGenerater("coutryCode");
			/*listIterator("ancillary-seat","CB_ANCILLARY_SEAT_");
			listIterator("ancillary","CB_ANCILLARY_");
			listIterator("approval","CB_APPROVAL_");
			listIterator("banner","CB_BANNER_");
			listIterator("common","CB_COMMON_");
			listIterator("flightPlanner","CB_FLIGHT_PLANNER_");
			listIterator("meta","CB_META_");
			listIterator("prebook","CB_PREBOOK_");
			listIterator("quoted-itinerary","CB_QUOTED_ITINERARY_");
			listIterator("review","CB_REVIEW_");
			listIterator("reviewtraveller","CB_REVIEW_TRAVELLER_");
			listIterator("search","CB_SEARCH_");
			listIterator("searchDetails","CB_SEARCH_DETAILS_");
			listIterator("thankyou","CB_THANKYOU_");
			listIterator("traveller","CB_TRAVELLER_");*/
		
	    }
		
		
    public static void listIterator(String fileName, String prefix) throws IOException {
    	String pathbase = "/home/mmt7564/eclipse-workspace/AlgorithmsAndDataStructures/YamlAutomation/src/resources";
		Yaml yaml = new Yaml();
		
		count=0;
		map = new LinkedHashMap<>();
		messages = new LinkedHashMap<>();
		yamlStr = new StringBuilder();
		keyValue = new StringBuilder();
		keyValue1 = new StringBuilder();
		
		try (InputStream in = Loader.class.getResourceAsStream("/resources/messages" + "/" + fileName + ".yml")) {
			@SuppressWarnings("unchecked")
			Map<String, Object> obj = (Map<String, Object>) yaml.load(in);
			newObject = new LinkedHashMap<>(obj);
			// System.out.println("Loaded object type:" + obj.getClass());
			utility(obj, "cb",0,prefix);
			for (Entry<String, String> entry : messages.entrySet()) {
				System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());
				keyValue1.append("\"" + entry.getKey().toString() + "\"" + " : " + entry.getValue().toString() + "\n");
			}
			for (Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());
				keyValue.append(entry.getKey().toString() + " : " + entry.getValue().toString() + "\n");
			}
			System.out.println(newObject);
			count = 0;
			generateFile(newObject,0,prefix);
			yamlStr.append("\n");
			System.out.println(yamlStr);
	        String path = pathbase + "/mapping/" + fileName + ".yml";
	        String path2 = pathbase + "/s3keys/" + "messages" + "_s32Keys.yml";
	        BufferedWriter out = new BufferedWriter( 
	                   new FileWriter(path, true)); 
	        out.write(yamlStr.toString()); 
	        out.close();
	        BufferedWriter out2 = new BufferedWriter( 
	                   new FileWriter(path2, true)); 
	        //out2.write(keyValue.toString()); 
	        out2.write(keyValue1.toString()); 
	        out2.close();
	        
	}
    }

	@SuppressWarnings("unchecked")
	public static String utility(Object obj, String keyStr, int deep, String prefix) {

		/*if(obj == null) {
			return keyStr;
		}*/
		
		if (obj instanceof String) {
			map.put(keyStr, "\"" + obj.toString() + "\"");
			count++;
			String numberAsString = String.valueOf(count);
		    String paddedNumberAsString = "00000".substring(numberAsString.length()) + numberAsString;
			messages.put(prefix+paddedNumberAsString, "\"" + obj.toString() + "\",");
			return keyStr;
		}
		if (obj instanceof ArrayList) {
			StringBuilder str = new StringBuilder();
			str.append("[");
			for (String value : (ArrayList<String>) obj) {
				str.append("\"" + value + "\"");

			}
			str.append("]");
			map.put(keyStr, str.toString());
			return keyStr;
		}

		for (Entry<String, Object> key : ((Map<String, Object>) obj).entrySet()) {
			if(deep==0) {
		 	  keyStr = "cb." + key.getKey();
			} else {
				keyStr = keyStr + "." + key.getKey();
			}
			String keyfinal = utility(key.getValue(), new String(keyStr),1,prefix);
			if(!keyfinal.equals("NA")) {
				key.setValue(keyfinal);
			}
		}
		return "NA";
	}
	
	
	@SuppressWarnings("unchecked")
	public static void generateFile(Object obj, int deep, String prefix) {

		if (obj instanceof String) {
			count++;
			String numberAsString = String.valueOf(count);
		    String paddedNumberAsString = prefix+ "00000".substring(numberAsString.length()) + numberAsString;
		    yamlStr.append(" \"" +paddedNumberAsString + "\"");
		    //yamlStr.append(" \"" +(String)obj + "\"");
			return;
		}

		for (Entry<String, Object> key : ((Map<String, Object>) obj).entrySet()) {
			yamlStr.append("\n");
			for(int i=0;i<deep;i++) {
				yamlStr.append(" ");
			}
			yamlStr.append(key.getKey() + ":");
			generateFile(key.getValue(),deep+1, prefix);
		}
	}
	
	public static void countryMapGenerater(String fileName) throws IOException {
		String pathbase = "/home/mmt7564/eclipse-workspace/AlgorithmsAndDataStructures/YamlAutomation/src/resources";
		Yaml yaml = new Yaml();
		
		count=0;
		map = new LinkedHashMap<>();
		messages = new LinkedHashMap<>();
		yamlStr = new StringBuilder();
		keyValue = new StringBuilder();
		keyValue1 = new StringBuilder();
	
		try (InputStream in = Loader.class.getResourceAsStream("/resources/messages" + "/" + fileName + ".yml")) {
			@SuppressWarnings("unchecked")
			Map<String, Object> obj = (Map<String, Object>) yaml.load(in);
			newObject = new LinkedHashMap<>(obj);
		    utility2(obj, "cb");
	}

	
	
	@SuppressWarnings("unchecked")
	public static String utility2(Object obj, String keyStr) {

		/*if(obj == null) {
			return keyStr;
		}*/
		
		if (obj instanceof String) {
			map.put(keyStr, "\"" + obj.toString() + "\"");
			count++;
			String numberAsString = String.valueOf(count);
		    String paddedNumberAsString = "00000".substring(numberAsString.length()) + numberAsString;
			messages.put(prefix+paddedNumberAsString, "\"" + obj.toString() + "\",");
			return keyStr;
		}
		if (obj instanceof ArrayList) {
			StringBuilder str = new StringBuilder();
			str.append("[");
			for (String value : (ArrayList<String>) obj) {
				str.append("\"" + value + "\"");

			}
			str.append("]");
			map.put(keyStr, str.toString());
			return keyStr;
		}

		for (Entry<String, Object> key : ((Map<String, Object>) obj).entrySet()) {
			if(key.getKey().equals("key")) {
		 	  keyStr = key.getValue().toString();
			}
			String keyfinal = utility(key.getValue(), new String(keyStr),1);
			if(!keyfinal.equals("NA")) {
				key.setValue(keyfinal);
			}
		}
		return "NA";
	}
}
