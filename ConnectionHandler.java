package amspackage;

import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
	private ServerSocket server;
	private Connection[] connections;
	private String[] world = new String[10]; 
	/**
	 * TODO There have to be Objects for the world, which can be delivered to the clients in Connection Threads.
	 */
	
	
	public ConnectionHandler() {
		connections = new Connection[10];
		try {
			server = new ServerSocket(12345);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				Socket socket = server.accept(); //accepts client
				for (int i = 0; i < connections.length; i++) { //gives a new Client
					if (connections[i] != null) {
						connections[i] = new Connection(socket);
						connections[i].run();
						break;
					}
				}
				//Remove old clients
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
