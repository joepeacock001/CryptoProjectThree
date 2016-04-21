//package assignmentThree;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class EchoServer {
	
	private static byte[][] whitelist = new byte[10][16];
	
	public static void main(String[] arstring) {
		try {
			SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory
					.getDefault();
			SSLServerSocket sslServerSocket = (SSLServerSocket) sslserversocketfactory
					.createServerSocket(9999);
			SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

			// Create Input / Output Streams for communication with the client
			while (true) {
				PrintWriter out = new PrintWriter(sslSocket.getOutputStream(),
						true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						sslSocket.getInputStream()));
				String inputLine, outputLine;

				// while ((inputLine = in.readLine()) != null) {
				// out.println(inputLine);
				// System.out.println(inputLine);
				// }
				while (((inputLine = in.readLine()) != null)) {
					
						if (inputLine.getBytes().equals(whitelist[0])) {
							out.println("true");
						} else
							out.println("false");
						System.out.println(inputLine);
				}
				
				// Close the streams and the socket
				// out.close();
				// in.close();
				// sslSocket.close();
				// sslServerSocket.close();

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static boolean contains(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num)
				return true;
		}
		return false;
	}
}