package amspackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements Runnable {
	private Socket socket;
	private int health, money, playermodel;
	private String name;
	private PrintWriter printWriter;
  	BufferedReader bufferedReader;
	
	
	/**
	 * @param Socket socket
	 */
	public Connection(Socket socket) {
		this.socket = socket;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String command = bufferedReader.readLine(); //get the standardattributes from the client : "name health money playermodel"
			String[] commands = command.split("\\s"); //split at the whitespaces
			name = commands[0];
			health = Integer.parseInt(commands[1]);
			money = Integer.parseInt(commands[2]);
			playermodel = Integer.parseInt(commands[3]);
		} catch (IOException e) {e.printStackTrace();}
		
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getPlayermodel() {
		return playermodel;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		while(true) {
			/**
			 * TODO printWriter has to inform the client about all the other clients and their attributes such as name, health etc.
			 * TODO bufferedReader has to get all the information from the client and perhaps look, if that matches with the logic (prevent others to manipulate their own attributes!)
			 */
		}
	}

}
