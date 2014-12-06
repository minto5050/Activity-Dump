import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ActivityDump {
public static void main(String[] args) {
	 try {
	      String line,para="";
	      /**
	       * 
	       * Set the add the path of android sdk/platform-tools to PATH variable
	       * 
	       */
	     // System.out.println("%%%%%%%%%%%%%%%");
	      Process p = Runtime.getRuntime().exec("adb shell dumpsys activity activities");
	      //System.out.println("%%%%%%%%%%%%%%%");
	      BufferedReader bri = new BufferedReader
	        (new InputStreamReader(p.getInputStream()));
	      //BufferedReader bre = new BufferedReader
	      //  (new InputStreamReader(p.getErrorStream()));
	      
	      while ((line = bri.readLine()) != null) {
	        if(line.contains("* Hist #"))
	    	  System.out.println((line.substring(line.indexOf("{"),line.length())).replaceAll("\\{", "").replaceAll("\\}", "").substring(line.indexOf(" ")));
	        para=para+line;
	      }
	      bri.close();
	      //System.out.println(para);
	      //while ((line = bre.readLine()) != null) {
	       // System.out.println(line);
	      //}
	     // bre.close();
	     // p.waitFor();
	      System.out.println("Done.");
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
}
}
