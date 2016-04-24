/**
 * 
 */
package HelloTCP;

import java.io.*;
import java.net.*;

/**
 * @author pille
 *
 */
public class Server {
	private static final int defaultPort = 6789;
	
	public Server() {
	}
	
	/**
	 * @param port Portnumber
	 */
	public static void main(String[] args) {
		Server server = new Server();
		
		int port;
		
		if(args.length > 0) {
			port = Integer.parseInt(args[0]);
			
			if(port < 0) {
				port = defaultPort;
			}
		} else {
			port = defaultPort;
		}
		
		server.run(port);
	}

	private void run(int port) {
		String incomingMessage;
		ServerSocket welcomeSocket;
		
		System.out.println("Using port: " + port);
		
		try {
			welcomeSocket = new ServerSocket(port);
			
			while(true) {
				Socket connectionSocket = welcomeSocket.accept();
				BufferedReader incomingStream =
						new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	
				incomingMessage = incomingStream.readLine();
				
				System.out.println("RECEIVED: " + incomingMessage);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
