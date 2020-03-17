package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* 
Classname: Hello 
Comment: The remote interface. 
*/
public interface Hello extends Remote {
	String Hello() throws RemoteException;
}
