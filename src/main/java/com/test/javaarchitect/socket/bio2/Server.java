package com.test.javaarchitect.socket.bio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//跟bio的区别就是使用了线程池的概念 即伪异步io
//就这个类不一样，其它的类都一样

public class Server {
	final static int PORT = 8765;
	
	public static void main(String[] args) {
		ServerSocket server = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("server start");
			Socket socket = null;
			HandlerExecutorPool execurotPool = new HandlerExecutorPool(50,100);
			while(true) {
				socket = server.accept();
				execurotPool.execute(new ServerHandler(socket));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
}











































