package team.sqjj.hospital.ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SocketServer {
private Socket socket;
public SocketServer(Socket s){this.setSocket(s);}
public void receive(){}
public void send(Object obj){}
public Socket getSocket() {
	return socket;
}
public void setSocket(Socket socket) {
	this.socket = socket;
} 
public void dosevice(){

	
	
}
}
