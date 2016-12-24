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

import team.sqjj.hospital.DaoFactory.PrescriptionDaoFactory;
import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Register;

public class DoctorThread extends Thread{
	Socket socket = null;
	public DoctorThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端的请求
	public void run() {
		while (true) {
			try {

				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				Prescription prescription = null;
				try {
					prescription = (Prescription) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (prescription != null) {
					RegisterDaoFactory.getInstance().updateIsLooked(prescription.getPrescription_Id());
					PrescriptionDaoFactory.getInstance().addPrescription(prescription);
					
					
						
							OutputStream os=ShareVariance.DrugStore.getOutputStream();
							ObjectOutputStream oos=new ObjectOutputStream(os);
							oos.writeObject(prescription);
							oos.flush();
							ShareVariance.DrugStore.shutdownOutput();//关闭输出流
							os.close();
						    oos.close();
						    ShareVariance.DrugStore.close();
						
						}
					

				

				// 4.关闭资源
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


