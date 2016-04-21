

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SampleApp {

	public static void main(String[] args)
	{
		
		check();
		
	      

	}
	
	public static boolean check()
	{
		BufferedReader reader;
		 String line = "";
		
		
		
		System.out.println("starting");
		String c1 = "javac EchoClient.java";
		String command =  "java -Djavax.net.ssl.trustStore=mySrvKeystore -Djavax.net.ssl.trustStorePassword=1234567 EchoClient";
		
		try {
			Process p1 = Runtime.getRuntime().exec(c1);
			p1.waitFor();
			Process proc = Runtime.getRuntime().exec(command);
			 reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));
			 while((line = reader.readLine()) != null) {
				    System.out.print(line + "\n");
				    
				}
			 proc.waitFor();
			 System.out.println("finishing");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
}
