/**
 * 
 */
package HelloTCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * @author pille
 *
 */
public class Client {
	private static final int defaultPort = 6789;
	private static final String defaultServerAdress = "Localhost";
	
	public Client() {
	}
	
	/**
	 * @param adress Server adress
	 * @param port Port number
	 */
	public static void main(String[] args) {
		Client client = new Client();
		
		String serverAdress;
		int port;
		
		if(args.length > 0) {
			serverAdress = args[0];
		} else {
			serverAdress = defaultServerAdress;
		}
			
		if(args.length > 1) {
			port = Integer.parseInt(args[1]);
			
			if(port < 0 || port > 65535) {
				port = defaultPort;
			}
		} else {
			port = defaultPort;
		}
		
		System.out.println("Connecting to: " + serverAdress + "using port: " + port);
		client.run(serverAdress, port);
	}
	
	public void run(String serverAdress, int port) {
		String outgoingMessage = "";
		Scanner stdin = new Scanner(System.in);
		
		try {
			while(!outgoingMessage.toLowerCase().trim().equals("exit")) {
				Socket clientSocket = new Socket(serverAdress, port);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				
				System.out.println("Enter message to server or type 'exit' to close:");
				outgoingMessage = stdin.nextLine();
				
				outToServer.writeBytes(outgoingMessage);
				clientSocket.close();
			}
			
			stdin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
