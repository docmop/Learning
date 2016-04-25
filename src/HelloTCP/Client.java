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
		client.run();
	}
	
	public void run() {
		try {
			System.out.println("Connecting to: " + defaultServerAdress + " using port: " + defaultPort);		
						
			Socket clientSocket = new Socket(defaultServerAdress, defaultPort);
			ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			
			System.out.println("Sending Int 1: 123");
			outToServer.writeInt(123);;
			
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
