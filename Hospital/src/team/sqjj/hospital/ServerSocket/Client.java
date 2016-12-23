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
 * 客户端
 */
public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//1.创建客户端Socket，指定服务器地址和端口
			Socket socket=new Socket("localhost", 8888);
			//2.获取输出流，向服务器端发送信息
		
			OutputStream os=socket.getOutputStream();//字节输出流
			PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
			pw.write("doctor");
			pw.flush();
			socket.shutdownOutput();//关闭输出流
			//3.获取输入流，并读取服务器端的响应信息
			InputStream is=socket.getInputStream();
			ObjectInputStream br=new ObjectInputStream(is);
			
				//System.out.println("我是客户端，服务器说："+br);
			//4.关闭资源
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
