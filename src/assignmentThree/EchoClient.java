//package assignmentThree;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class EchoClient {
	public static void main(String[] arstring) {
		PrintWriter out = null;
        BufferedReader in = null;
		
		try {
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory
					.getDefault();
			SSLSocket sslSocket = (SSLSocket) sslsocketfactory.createSocket(
					"localhost", 9999);

			// Initializing the streams for Communication with the Server
         	out = new PrintWriter(sslSocket.getOutputStream(), true);
         	in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			byte[] userInput = check();
			out.println(userInput);

//			while ((userInput = stdIn.readLine()) != null) {
//			    out.println(userInput);
//			    System.out.println("echo: " + in.readLine());
//			}
//
//				out.println(userInput);
			System.out.println(in.readLine());
				// Closing the Streams and the Socket
				out.close();
				in.close();
				stdIn.close();
				sslSocket.close();
			
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
			
	}
	
	public static byte[] check()
	{
		BufferedReader reader;
		 String line = "";
		
		String os = System.getProperty("os.name");
		String data = "";
		if (os.charAt(0) == 'W')
		{
			String c = "ipconfig /all";
			try {
				Process p = Runtime.getRuntime().exec(c);
				reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
				 while((line = reader.readLine()) != null) {
					    data += line;
					}
				 p.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			String c = "/sbin/ifconfig -a";
			try {
				Process p = Runtime.getRuntime().exec(c);
				reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
				 while((line = reader.readLine()) != null) {
					    data += line;
					}
				 p.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return md5(data);	
	}
	
	public static byte[] md5(String in)
	{
    	
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(in.getBytes());
        
        byte byteData[] = md.digest();
        return byteData;
	}
	
	
}