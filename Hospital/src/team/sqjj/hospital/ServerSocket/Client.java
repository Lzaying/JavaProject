package team.sqjj.hospital.ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//1.�����ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket=new Socket("localhost", 8888);
			//2.��ȡ���������������˷�����Ϣ
		
			OutputStream os=socket.getOutputStream();//�ֽ������
			PrintWriter pw=new PrintWriter(os);//���������װΪ��ӡ��
			pw.write("doctor");
			pw.flush();
			socket.shutdownOutput();//�ر������
			//3.��ȡ������������ȡ�������˵���Ӧ��Ϣ
			InputStream is=socket.getInputStream();
			ObjectInputStream br=new ObjectInputStream(is);
			
				//System.out.println("���ǿͻ��ˣ�������˵��"+br);
			//4.�ر���Դ
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
