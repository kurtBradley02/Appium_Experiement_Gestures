package util;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON_Reader {
	
	String platformName;
	String automationName;
	String deviceName;
	String udid;
	
	JSONParser parser;
	


	public JSON_Reader(String deviceType) {
		
        parser = new JSONParser();
        
        setup(deviceType);
        
	}
	
	public void setup(String deviceType) {

        try {
        	
        	String currentWorkingDir = System.getProperty("user.dir");
        	String filePath = currentWorkingDir + "/src/main/java/common/config_"+deviceType+".json";
        	Object obj = parser.parse(new FileReader(filePath));
            
            JSONObject jsonObject = (JSONObject) obj;
            
            platformName = (String) jsonObject.get("platformName");
            automationName = (String) jsonObject.get("automationName");
            deviceName = (String) jsonObject.get("deviceName");
//            udid = (String) jsonObject.get("udid");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
	public String getPlatformName() {
		return platformName;
	}
	
	public String getAutomationName() {
		return automationName;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public String getUdid() {
		return udid;
	}
	

}
