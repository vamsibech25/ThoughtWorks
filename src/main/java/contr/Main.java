package contr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import GetPost.GetPostMethod;
import conve.Decrpt;
import conve.Timeconver;
import conve.Tool;
import conve.Toolusage;

public class Main {


	
	
	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	{	
//	public static void POSTRequest2(List<String> res) throws IOException {
//
//	    URL obj = new URL("https://http-hunt.thoughtworks-labs.net/challenge/output");
//	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
//	    postConnection.setRequestMethod("POST");
//	    postConnection.setRequestProperty("userId", "23qvl9k7o");
//	    postConnection.setRequestProperty("Content-Type", "application/json");
//	    postConnection.setDoOutput(true);
//	    OutputStream os = postConnection.getOutputStream();
//	    os.write(POST_PARAMS.getBytes());
//	    os.flush();
//	    os.close();
//	    int responseCode = postConnection.getResponseCode();
//	    System.out.println("time "+new Date());
//	    System.out.println("POST Response Code :  " + responseCode);
//	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
//	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
//	        BufferedReader in = new BufferedReader(new InputStreamReader(
//	            postConnection.getInputStream()));
//	        String inputLine;
//	        StringBuffer response = new StringBuffer();
//	        while ((inputLine = in .readLine()) != null) {
//	            response.append(inputLine);
//	        } in .close();
//	        // print result
//	        System.out.println("end time "+new Date());
//	        System.out.println(response.toString());
//	    } else {
//	        System.out.println("POST NOT WORKED");
//	    }
//	}
//	
//	public static void POSTRequest3(HashMap<String,Long> res) throws IOException {
//	    
//	    URL obj = new URL("https://http-hunt.thoughtworks-labs.net/challenge/output");
//	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
//	    postConnection.setRequestMethod("POST");
//	    postConnection.setRequestProperty("userId", "23qvl9k7o");
//	    postConnection.setRequestProperty("Content-Type", "application/json");
//	    postConnection.setDoOutput(true);
//	    OutputStream os = postConnection.getOutputStream();
//	    os.write(POST_PARAMS.getBytes());
//	    os.flush();
//	    os.close();
//	    int responseCode = postConnection.getResponseCode();
//	    System.out.println("time "+new Date());
//	    System.out.println("POST Response Code :  " + responseCode);
//	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
//	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
//	        BufferedReader in = new BufferedReader(new InputStreamReader(
//	            postConnection.getInputStream()));
//	        String inputLine;
//	        StringBuffer response = new StringBuffer();
//	        while ((inputLine = in .readLine()) != null) {
//	            response.append(inputLine);
//	        } in .close();
//	        // print result
//	        System.out.println("end time "+new Date());
//	        System.out.println(response.toString());
//	    } else {
//	        System.out.println("POST NOT WORKED");
//	    }
//	}
//	
//	
	}
	
	 
	 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	 		GetPostMethod gpmethod=new GetPostMethod();
	 		int opt = 4;
	 		GetPostMethod.MyGETRequest(opt);
	    //POSTRequest();

	}

}

