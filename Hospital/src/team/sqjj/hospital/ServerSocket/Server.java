package team.sqjj.hospital.ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import team.sqjj.hospital.DaoFactory.UserDaoFactory;
import team.sqjj.hospital.JFrame.Client_Admin;
import team.sqjj.hospital.JFrame.Client_Dean;
import team.sqjj.hospital.JFrame.Client_Doctor;
import team.sqjj.hospital.JFrame.Client_Patients;
import team.sqjj.hospital.model.User;

/*
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket=new ServerSocket(8888);
			Socket socket=null;
			//记录客户端的数量
			int count=0;
			System.out.println("***服务器即将启动，等待客户端的连接***");
			//循环监听等待客户端的连接
			while(true){
				//调用accept()方法开始监听，等待客户端的连接
				socket=serverSocket.accept();
				//创建一个新的线程
				InputStream is = null;
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
							
							if (info=="2") {
								RegisterThread rt=new RegisterThread(socket);
							    rt.start();
							}
							else  {
								DoctorThread dt=new DoctorThread(socket);
								dt.start();
								ShareVariance.doctorservers.put(info, socket);
							}
							
						}
				
				
				
				
				
				
				
				
				
				count++;//统计客户端的数量
				System.out.println("客户端的数量："+count);
				InetAddress address=socket.getInetAddress();
				System.out.println("当前客户端的IP："+address.getHostAddress());
			}
	catch (IOException e) {
			e.printStackTrace();
		}}}
		catch (IOException e) {
			e.printStackTrace();}}}

