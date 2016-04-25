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
		server.run();
	}

	private void run() {
		ServerSocket welcomeSocket;
		
		System.out.println("Server listening on port: " + defaultPort);
		
		try {
			int i = 1;
			welcomeSocket = new ServerSocket(defaultPort);
			
			while(true) {
				Socket connectionSocket = welcomeSocket.accept();
				ObjectInputStream incomingStream = new ObjectInputStream(connectionSocket.getInputStream());
				
				System.out.println("RECEIVED ("+ i +"): " + incomingStream.readInt());
				i++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
