package team.sqjj.hospital.ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import team.sqjj.hospital.DaoFactory.UserDaoFactory;
import team.sqjj.hospital.JFrame.*;
import team.sqjj.hospital.model.User;

/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端的请求
	public void run() {
		
		// 获取输出流，响应客户端的请求
		Iterator<Socket> it = ShareVariance.allSockets.iterator();
		while (it.hasNext()) {
			Socket u = it.next();
			if (u.equals(socket)) {
				Iterator<SocketServer> itt = ShareVariance.allservers.iterator();
				while (itt.hasNext()) {
					SocketServer x = itt.next();
					if (u.equals(x.getSocket())) {
						x.dosevice();

					}
				}

			}
			break;
		}

		if (!it.hasNext()) {InputStream is = null;
		InputStreamReader isr = null;
		
		

		// 获取输入流，并读取客户端信息

		try {
			is = socket.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		isr = new InputStreamReader(is);
BufferedReader br = null;
			br = new BufferedReader(isr);
			String info = null;
			SocketServer server = null;
			User user2=new User();
			try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
				while ((info = br.readLine()) != null) {
					String username=info.substring(0, info.indexOf(';'));
					String password=info.substring(info.indexOf(';')+1);
				if(username=="admin"&&password=="123"){
					new Client_Admin();
					
					
				}
					User user=(User) UserDaoFactory.getInstance().getByName(username);
				
				if(user!=null&&user.getPassword()==password){
					if (user.getRole()==0) {
						server = new PatientServer(socket);
						ShareVariance.patientservers.add(server);
						new Client_Patients();
					}
					else if (user.getRole()==1) {
						server = new RegisterServer(socket);
						 ShareVariance.registerservers.add(server);
						 new Client_Patients();
					}
					else if (user.getRole()==3) {
						server = new PrescribeServer(socket);
						ShareVariance.prescribeservers.add(server);
						//new Client_Prescribe();
					}
					else if (user.getRole()==4) {
						server = new DeanServer(socket);
						ShareVariance.deanservers.add(server);
						new Client_Dean();
					}
					else {
						server = new DoctorServer(socket);
						ShareVariance.doctorservers.put(username, server);
		                new Client_Doctor();			
					}

					ShareVariance.allservers.add(server);
					ShareVariance.allSockets.add(socket);
					try {
						socket.shutdownInput();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // 关闭输入流
				}
			
		else{
		pw.write("用户名或密码错误！");
		pw.flush();//调用flush()方法将缓冲输出
			
			
			
		}
	}}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // 关}

}}}