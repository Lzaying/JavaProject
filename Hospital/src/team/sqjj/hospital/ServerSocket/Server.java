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
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���½
 * ��������
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.����һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket=new ServerSocket(8888);
			Socket socket=null;
			//��¼�ͻ��˵�����
			int count=0;
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			//ѭ�������ȴ��ͻ��˵�����
			while(true){
				//����accept()������ʼ�������ȴ��ͻ��˵�����
				socket=serverSocket.accept();
				//����һ���µ��߳�
				InputStream is = null;
				InputStreamReader isr = null;
				
				

				// ��ȡ������������ȡ�ͻ�����Ϣ

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
				
				
				
				
				
				
				
				
				
				count++;//ͳ�ƿͻ��˵�����
				System.out.println("�ͻ��˵�������"+count);
				InetAddress address=socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
			}
	catch (IOException e) {
			e.printStackTrace();
		}}}
		catch (IOException e) {
			e.printStackTrace();}}}

