package team.sqjj.hospital.ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Set;

import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.model.Register;

public class RegisterThread extends Thread {
	Socket socket = null;

	public RegisterThread(Socket socket) {
		this.socket = socket;
	}

	// �߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run() {
		while (true) {
			try {

				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				Register register = null;
				try {
					register = (Register) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (register != null) {
					RegisterDaoFactory.getInstance().addRegister(register);
					Set<String> set = ShareVariance.doctorservers.keySet();
					Iterator<String> keyit = set.iterator();
					while (keyit.hasNext()) {
						String receivekey = keyit.next();
						if (register.getDoctor().equals(receivekey)) {
							OutputStream os=ShareVariance.doctorservers.get(receivekey).getOutputStream();
							ObjectOutputStream oos=new ObjectOutputStream(os);
							oos.writeObject(register);
							oos.flush();
							ShareVariance.doctorservers.get(receivekey).shutdownOutput();//�ر������
							os.close();
						    oos.close();
						    ShareVariance.doctorservers.get(receivekey).close();
						
						}
					}

				}

				// 4.�ر���Դ
				ois.close();
				is.close();

				socket.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
