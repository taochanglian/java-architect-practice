package com.test.javaarchitect.socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	final static int PORT=8765;
	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("server starting");
			Socket socket = server.accept();
			
			new Thread(new ServerHandler(socket)).start();;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(server!=null) {
				try {
					server.close();
					server = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
