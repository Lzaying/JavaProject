package team.sqjj.hospital.ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Set;

import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.model.Register;

public class RegisterServer extends SocketServer {

	public RegisterServer(Socket s) {
		super(s);
		// TODO Auto-generated constructor stub
	}


		

	@Override
	public void receive() {
		// TODO Auto-generated method stub
		Socket socket=super.getSocket();
		try {
			
			InputStream is=socket.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			Register register=null;
			try {
				register = (Register)ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(register!=null){
				RegisterDaoFactory.getInstance().addRegister(register);
				Set<String> set=ShareVariance.doctorservers.keySet();
				Iterator<String> keyit=set.iterator();
				while(keyit.hasNext()){
					String receivekey=keyit.next();
					if(register.getDoctor().equals(receivekey)){
						ShareVariance.doctorservers.get(receivekey).send(register);
					}
				}
				
				
			}	
			
			//4.¹Ø±Õ×ÊÔ´
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




	

