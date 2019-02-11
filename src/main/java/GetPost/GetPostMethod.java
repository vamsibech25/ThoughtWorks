package GetPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import Challenge.Challenge;
import conve.Challenge4;
import conve.Decrpt;
import conve.Timeconver;
import conve.Tool;
import conve.Toolusage;
import conve.Weight;

public class GetPostMethod {

	public static HashMap<String,Long> hm=new HashMap<String,Long>(); 
	public static String POST_PARAMS;
	public static String resu;
    public static List<String> resl = new ArrayList<String>();
    public static HashMap<String,Long> ttss=new HashMap<String ,Long>();
    public static List<String> lst=new ArrayList<String>();
	public static List<String> getLst() {
		return lst;
	}

	public static String getResu() {
		return resu;
	}

	public static List<String> getResl() {
		return resl;
	}

	public static HashMap<String, Long> getTtss() {
		return ttss;
	}

	public GetPostMethod() {
		// TODO Auto-generated constructor stub
	}
	
	public static void MyGETRequest(int opt) throws IOException {
	    URL urlForGetRequest = new URL("https://http-hunt.thoughtworks-labs.net/challenge/input");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    conection.setRequestProperty("userId", "23qvl9k7o"); // set userId its a sample here
	    int responseCode = conection.getResponseCode();
	    System.out.println("time "+new Date());
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        // print result
	        Challenge cha=new Challenge();
	        Gson gs=new Gson();
	        switch(opt)
	        {
	        
	        	case 1:
	        		Decrpt dec1= gs.fromJson(response.toString(),Decrpt.class);  //challenge 1
	    	        resu=cha.decrptmsg(dec1.getEncryptedMessage(),dec1.getKey());
	    	        System.out.println("decrpt msg: "+resu);
	    	        POSTRequest(1);  
	    	        System.out.println("JSON String Result " + response.toString());
	        break;
	        
	        	case 2:
	        		Tool dec2= gs.fromJson(response.toString(),Tool.class); 		//challenge 2
	    			System.out.println("msg : "+dec2.getHiddenTools());
	    			String message = dec2.getHiddenTools();
	    			List<String> tool = new ArrayList<String>();
	    			tool=dec2.getTools(); 
	    			for (int i = 0; i < tool.size(); i++)
	    			{
	    				System.out.println("tool: "+tool.get(i));				//challenge 2
	    			}

	    	        resl=cha.decrpttoolmsg(tool,message);
	    	        System.out.println("list msg: "+resl);
	    	        POSTRequest(2);										//for challenge 2
//	    	        GetAndPost.POSTRequest(response.toString());
	    	        System.out.println("JSON String Result " + response.toString());
	        break;
	        	case 3:
	        		Timeconver dec= gs.fromJson(response.toString(),Timeconver.class); //challenge 3
	    	        
	    	        
	    	        List<Toolusage> toolusage=new ArrayList<Toolusage>();
	    	        System.out.println("size "+toolusage.size()+"   list  "+toolusage);
	    	        toolusage=dec.getToolUsage();
	    	        for(int i=0;i<toolusage.size();i++)
	    	        {
	    	        	
	    	        	Toolusage usage=new Toolusage();
	    	        	usage=toolusage.get(i);
	    	        	String obj=usage.getName();
	    	        	System.out.println("obj "+obj);
	    	        	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

	    	            Date d1 = null;
	    	            Date d2 = null;
	    	            try {
	    	                d1 = format.parse(usage.getUseStartTime());
	    	                d2 = format.parse(usage.getUseEndTime());
	    	            } catch (ParseException e) {
	    	                e.printStackTrace();
	    	            }
	    	            System.out.println("d1 "+d1+"   d2 "+d2);
	    	            System.out.println("d1 "+d1.getTime()+"   d2 "+d2.getTime());
	    	            long diff = d2.getTime() - d1.getTime();
	    	            long diffMinutes = diff / (60 * 1000);
	    	            System.out.println("diff "+diff+"   minu "+diffMinutes);
	    	            if(hm.containsKey(obj))
	    	            {
	    	            	Long val=hm.get(obj);
	    	            	val+=diffMinutes;
	    	            	hm.put(obj,val);
	    	            }
	    	            else 
	    	            	hm.put(obj,diffMinutes);
	    	        }
	    	        for(HashMap.Entry m:hm.entrySet()){  
	    	        	
	    	            System.out.println(" details" +m.getKey()+" "+m.getValue());    
	    	           } 
	    	        ttss=cha.sortByValue(hm);
	    	        POSTRequest(3);
	    	        System.out.println("JSON String Result " + response.toString());
	        break;
	        case 4:
	        	System.out.println("JSON String Result " + response.toString());
	        	Challenge4 ch4=gs.fromJson(response.toString(),Challenge4.class);
	        	int maxwht=ch4.getMaximumWeight();
	        	List<Weight> wht=ch4.getTools();
	        	lst=cha.rankTool(wht,maxwht);
	        	POSTRequest(4);
	        break;	
	        }
	        
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	}
	
	
	
	public static void POSTRequest(int opt) throws IOException {
		
		POST_PARAMS="";
		switch(opt)
		{
		case 1:
			String res=getResu();
			POST_PARAMS = "{\n" + "\"message\":\""+ res+"\"}";
		    System.out.println(POST_PARAMS);
		break;
			
		case 2:
			List<String> reslt=getResl();
		    POST_PARAMS = "{\n" + "\"toolsFound\":[";
		    for(int i=0;i<reslt.size();i++)
		    {
		    	POST_PARAMS+="\""+reslt.get(i)+"\"";
		    	if(i!=(reslt.size()-1))
		    		POST_PARAMS+=",";
		    }
		    POST_PARAMS+="]\n}";
		    System.out.println(POST_PARAMS);
		break;
		case 3:
			HashMap<String,Long> reshm=getTtss();
		POST_PARAMS = "{\n" + "\"toolsSortedOnUsage\":[\n";
		    int hm_size=reshm.size(),i=0;
	        for(HashMap.Entry m:reshm.entrySet())
	        {  
	        	POST_PARAMS+="{\n\"name\":\""+m.getKey()+"\",\n\"timeUsedInMinutes\":"+m.getValue()+"\n}";
	        	if(i!=(hm_size-1))
	        	{
	        		POST_PARAMS+=",\n";
	        	}
	        	i++;    
	           } 
	        
		    POST_PARAMS+="\n]\n}";
		    System.out.println(POST_PARAMS);
		break;
		case 4:
			List<String> lstres=getLst();
		    POST_PARAMS = "{\n" + "\"toolsToTakeSorted\":[\n";
		    for(int i1=0;i1<lstres.size();i1++)
		    {
		    	POST_PARAMS+="\""+lstres.get(i1)+"\"";
		    	if(i1!=(lstres.size()-1))
		    		POST_PARAMS+=",\n";
		    }
		    POST_PARAMS+="\n]\n}";
		    System.out.println(POST_PARAMS);
		break;
		
		}

	    URL obj = new URL("https://http-hunt.thoughtworks-labs.net/challenge/output");
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("userId", "23qvl9k7o");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("time "+new Date());
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();
	        // print result
	        System.out.println("end time "+new Date());
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	}
	


}
