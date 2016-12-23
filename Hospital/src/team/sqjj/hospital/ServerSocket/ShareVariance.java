package team.sqjj.hospital.ServerSocket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShareVariance {
public static ArrayList<Socket> allSockets=new ArrayList<Socket>();
public static ArrayList<SocketServer> allservers=new ArrayList<SocketServer>();
public static ArrayList<SocketServer> deanservers=new ArrayList<SocketServer> ();
public static ArrayList<SocketServer> registerservers=new ArrayList<SocketServer> ();
public static Map<String,SocketServer>doctorservers=new HashMap<String,SocketServer> ();

public static ArrayList<SocketServer>prescribeservers=new ArrayList<SocketServer> ();
public static ArrayList<SocketServer>patientservers=new ArrayList<SocketServer> ();

}
