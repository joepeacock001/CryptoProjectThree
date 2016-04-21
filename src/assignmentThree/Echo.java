package assignmentThree;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class Echo {
	public static void main(String[] args) throws IOException {
		String address = new Echo().getMacAddress();
		System.out.println(address);
	}

	public String getMacAddress() throws IOException {
		String macAddress = null;
		String command = "/sbin/ifconfig -a eth0 | grep HWaddr |  sed '/^.*HWaddr */!d; s///;q'";

		Process pid = Runtime.getRuntime().exec(command);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				pid.getInputStream()));
		while (true) {
			String line = in.readLine();
			System.out.println("line " + line);
			if (line == null)
				break;
			Pattern p = Pattern
					.compile(".*Link encap:Ethernet  HWaddr.*: (.*)");
			Matcher m = p.matcher(line);
			if (m.matches()) {
				macAddress = m.group(1);
				break;
			}
		}
		in.close();
		return macAddress;
	}

}
