package com.lwq.spring.cloud.demo.utils;

import java.net.InetAddress;

public class IpUtils {

	
	public static String getIP(){
		String res="";
		 InetAddress ia=null;
	        try {
	            ia=ia.getLocalHost();
	             
	            String localname=ia.getHostName();
	            String localip=ia.getHostAddress();
	            
	            res= localip;
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return res;
	}
	
}
