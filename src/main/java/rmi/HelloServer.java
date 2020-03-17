package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/* 
Classname: HelloServerDemo 
Purpose: The RMI server. 
*/
public class HelloServer extends UnicastRemoteObject implements Hello {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloServer() throws RemoteException {
		super();
	}

	public String Hello() {
		System.out.println("Invocation to Hello was succesful!");
		return "Hello World from RMI server!";
	}

	public static void main(String args[]) {
		try {
// Creates an object of the HelloServer class. 
			HelloServer obj = new HelloServer();
// Bind this object instance to the name "HelloServer". 
			//Naming.rebind("Hello", obj);
			Naming.rebind("rmi://127.0.0.1:1020/Hello", obj);
			System.out.println("Ligado no registro");
		} catch (Exception ex) {
			System.out.println("error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}