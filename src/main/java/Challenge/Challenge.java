package Challenge;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import conve.Weight;
import conve.WeightMap;

public class Challenge{

	public static String message;
	public List<String> fin=new ArrayList<String>();
	public static HashMap<List<String>,Integer> pater=new HashMap<List<String>,Integer>();
	public static HashMap<String,Integer> lasss=new HashMap<String,Integer>();
	public Challenge() {
		// TODO Auto-generated constructor stub
	}
	public static String decrptmsg(String msg,Integer key)
	{
		
		String tem="";
		int len = msg.length();
		for(int i=0;i<len;i++)
        {
            //System.out.println("for");
            char temp=msg.charAt(i);
            if(!Character.isDigit(temp))
            {
            	int val=(int)temp;
            	if(val>=65 && val<=90)
            	{
            		int che=val-key;
            		if(che<65)
            		{
            			int check=65-che-1;
            			check=90-check;
            			tem+=(char)check;
            		}
            		else if(che>=65 && che<=90)
            			tem+=(char)che;
            	}
            	else
            		tem+=(char)val;
            	
            }
        }
		return tem;
		
	}

	
	
	public static List<String> decrpttoolmsg(List<String> key,String msg)
	{
		message=msg;
		Boolean pass=false;
		List<String> tem = new ArrayList<String>();
            for(int j=0;j<key.size();j++)
            {
            	String tool=key.get(j);
            	pass=checkpattern(tool);
            	if(pass == true)
            	{
            		System.out.println("tool function call :"+tool);
            		tem.add(tool);
            	}

            }

        
		return tem;
		
	}
	
	public static boolean checkpattern(String msg)
	 {
		 Boolean result=false;
			int len = message.length();
			int leng=msg.length();
			int sol=0,fs=0;
			int rr[]=new int[leng];
			Boolean fl=false;
			l1:for(int j=0;j<leng;j++)
			{
				System.out.println("for call");
				char msgtem=msg.charAt(j);
				for(int i=sol;i<len;i++)
				{
					if(j==0)
					{
						fs=i;
					}
				    char temp=message.charAt(i);
				    if(temp==msgtem)
				    {
				    	System.out.println("matched");
				    	fl=true;
				    	sol=i;
				    	rr[j]=1;
//				    	if(j==(leng-1))
//				    	{
				    		System.out.println("continue called");
				    		continue l1;
//				    	}
				    }
				    else
				    {
				    	fl=false;
				    	rr[j]=0;
				    }
				    
				
				}
				if(fl==false)
				{
					sol=fs;
				}
			}
			for(int l=0;l<leng;l++)
			{
				if(rr[l]==1)
					result=true;
				else if(rr[l]==0)
				{
					result=false;
					break;
				}
			}
			return result;
		 
	 }
	
	public static HashMap<String, Long> sortByValue(HashMap<String, Long> hmm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Long> > list = 
               new LinkedList<Map.Entry<String, Long> >(hmm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Long> >() { 
            public int compare(Map.Entry<String, Long> o1,  
                               Map.Entry<String, Long> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Long> temp = new LinkedHashMap<String, Long>(); 
        for (Map.Entry<String, Long> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        HashMap<String, Long> sorted =hmm; 
        sorted = hmm
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                		Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        System.out.println("sorted map"+sorted);
        
        return sorted; 
    } 
    
	public List<String> rankTool(List<Weight> wei,int maxw)
	{
		
		String keyss[]= new String[wei.size()];

		HashMap<List<String>,Integer> chek=new HashMap<List<String>,Integer>();
		HashMap<String,WeightMap> hmwe=new HashMap<String,WeightMap>();
		HashMap<String,Integer> hmweval=new HashMap<String,Integer>();
		HashMap<String,Integer> hmwevalww=new HashMap<String,Integer>();
		List<String> temp=new ArrayList<String>();
		List<String> temp1=new ArrayList<String>();
		HashMap<String,Integer> velhm=new HashMap<String,Integer>();
		for(int i=0;i<wei.size();i++)
		{
			WeightMap wm=new WeightMap();
			Weight wht=wei.get(i);
			wm.setValue(wht.getValue());
			wm.setWeight(wht.getWeight());
			hmwe.put(wht.getName(), wm);
			hmweval.put(wht.getName(),wht.getWeight());
			hmwevalww.put(wht.getName(),wht.getValue());
			temp.add(wht.getName());
			velhm.put(wht.getName(),wht.getWeight());
			
		}
		int mapsi=hmweval.size();
		int count=0,count1=0;
		lasss.putAll(hmweval);
      for(HashMap.Entry m:hmweval.entrySet())
      {  
      	System.out.println(" details  " +m.getKey()+" "+m.getValue() );
      }
      int weight=0;
      for(int l=0;l<temp.size();l++)
      {
      	weight+=lasss.get(temp.get(l));
      }
      java.util.Collections.sort(temp, Collator.getInstance());
      pater.put(temp,weight);
      Boolean re=printAllKLength(temp);
      if(re==true)
      {
    	  for(HashMap.Entry m:pater.entrySet())
          {  
            	System.out.println(" details  " +m.getKey()+" "+m.getValue() );
          }
      }
    HashMap<List<String>,Integer> chek1=new HashMap<List<String>,Integer>();
    chek1.putAll(pater);
    chek.putAll(pater);
    int cou=0,coun=0;
    int maxsize=0,maxweight=0;
    int outer=0,inner=0;
    int outers=0,inners=0;
    int sizxxx=chek.size();
    Boolean innerflag=false,outerflag=false;
    for(HashMap.Entry m:chek.entrySet())
    { 
    	outer=(int)m.getValue();
    	outers=((List<String>)m.getKey()).size();
    	System.out.println(" outer size"+outers);
    	temp=new ArrayList<String>();
    	Iterator it = chek1.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry pair = (Map.Entry)it.next();
        	inner=(int)pair.getValue();
        	//Object lll=pair.getKey();
        	inners=((List<String>) pair.getKey()).size();
        	System.out.println(" inner size"+inners);
        	if(cou<(sizxxx-1))
        	{
        		System.out.println(" size checking  coun "+coun+ "  cou "+cou );
        	if(coun>cou)
        	{
        		System.out.println(" checking");
        		if(outer>=inner && outers>=inners)
        		{
        			System.out.println(" 1st if");
        			if(outer<=maxw)
        			{
        				System.out.println(" outer if");
        				System.out.println(" maxweight "+maxweight+ "  maxsize "+maxsize);
        				System.out.println(" outer maxweight "+outer+ " outer maxsize "+outers);
        				if(outerflag==false) {
        					maxweight=outer;
            				maxsize=outers;
            				innerflag=true;outerflag=true;
        				}
        				if((outer>=maxweight) && (outers>=maxsize))
        				{
        					System.out.println(" outer");
            				maxweight=outer;
            				maxsize=outers;
            				temp1.clear();
            				temp1.addAll((List<String>)m.getKey());
        				}
        				else
        					System.out.println("inner else");

        			}
        		}
        		else if(outer<inner && outers<inners)
        		{
        			System.out.println(" 1st if");
        			if(inner<=maxw)
        			{
        				System.out.println(" inner  if");
        				System.out.println(" maxweight "+maxweight+ "  maxsize "+maxsize);
        				System.out.println(" inner maxweight "+inner+ " inner maxsize "+inners);
        				if(innerflag==false)
        				{
             				maxweight=inner;
            				maxsize=inners;
            				innerflag=true;outerflag=true;
        				}
        				if((inner>=maxweight) && (inners>=maxsize))
        				{
        					System.out.println(" inner");
            				maxweight=inner;
            				maxsize=inners;
            				temp1.clear();
            				temp1.addAll((List<String>)m.getKey());
        				}
        				else
        					System.out.println("inner else");

        			}
        		}
        	}
        	coun++;
    	System.out.println("outer details  " +m.getKey()+" "+m.getValue() );
    	System.out.println(" inner details  " +pair.getKey()+" "+pair.getValue());
    }
        	else
        		break;

	
        }

		coun=0;
		cou++;
    }
		
		
        
        System.out.println(" last "+temp1); 
  	  for(HashMap.Entry m:hmwevalww.entrySet())
      {  
        	System.out.println(" details  " +m.getKey()+" "+m.getValue() );
      }
  	  HashMap<String,Long> srtmp=new HashMap<String,Long>();
        for(int i=0;i<temp1.size();i++)
        {
        	Boolean ddd=false;
        			
        	System.out.println(" flag "+ddd);
        	if(hmwevalww.containsKey(temp1.get(i)))
        	{
        		ddd=true;
        		System.out.println(" remove "+temp1.get(i));
        		Integer va=hmwevalww.get(temp1.get(i));
        		srtmp.put(temp1.get(i),(long)va);
        		
        		
        	}

        }
  	  for(HashMap.Entry m:srtmp.entrySet())
      {  
        	System.out.println(" details  " +m.getKey()+" "+m.getValue() );
      }
  	  
  	HashMap<String,Long> srtmp1=sortByValue(srtmp);
  	List<String> temp2=new ArrayList<String>();
	  for(HashMap.Entry m:srtmp1.entrySet())
      { 
		  temp2.add((String) m.getKey());
        	System.out.println(" details  " +m.getKey()+" "+m.getValue() );
      }
        return temp2;
	}
	
	public static Boolean printAllKLength(List<String> set) 
	{ 
		List<String> emp=new ArrayList<String>();
	    int n = set.size(); 
	    
	    for(int i=0;i<n;i++)
	    {
	    	printAllKLengthRec(set,emp, n, i); 
	    }
		return true;
	} 
	  
	// The main recursive method 
	// to print all possible  
	// strings of length k 
	public static void printAllKLengthRec(List<String> set,  
	                               List<String> prefix,  
	                               int n, int k) 
	{ 
	      
	    // Base case: k is 0, 
	    // print prefix 
		int weight=0;
	    if (k == 0)  
	    { 
	        System.out.println(prefix);
	        for(int l=0;l<prefix.size();l++)
	        {
	        	weight+=lasss.get(prefix.get(l));
	        }
	        java.util.Collections.sort(prefix, Collator.getInstance());
	        pater.put(prefix,weight);
	        return; 
	    } 
	  
	    // One by one add all characters  
	    // from set and recursively  
	    // call for k equals to k-1 
	    for (int i = 0; i < n; ++i) 
	    { 
	  
	        // Next character of input added 
	        List<String> newPrefix=new ArrayList<String>();
	        for(int j=0;j<prefix.size();j++)
	        {
	        	if(prefix.get(j)!=set.get(i))
	        		newPrefix.add(prefix.get(j));
	        }
	        newPrefix.add(set.get(i));  
	          
	        // k is decreased, because  
	        // we have added a new character 
	        printAllKLengthRec(set, newPrefix,  
	                                n, k - 1);  
	    }
		//return pater; 
	} 
	
	
	
}