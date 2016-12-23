package team.sqjj.hospital.ServerSocket;

import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.Socket;


public class DoctorServer extends SocketServer {

	public DoctorServer(Socket s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(Object obj) {
		// TODO Auto-generated method stub
		Socket socket = super.getSocket();
		OutputStream os=null;
		ObjectOutputStream oos = null;
		try {
			os = socket.getOutputStream();

			oos = new ObjectOutputStream(os);// 将输出流包装为对象流
			oos.writeObject(obj);
			oos.flush();
			socket.shutdownOutput();//关闭输出流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				os.close();

				oos.close();

				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Socket getSocket() {
		// TODO Auto-generated method stub
		return super.getSocket();
	}

	@Override
	public void setSocket(Socket socket) {
		// TODO Auto-generated method stub
		super.setSocket(socket);
	}

	@Override
	public void dosevice() {
		// TODO Auto-generated method stub
		super.dosevice();
	}

}
