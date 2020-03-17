package rmi.search;

//Creating a Search interface  
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MySearch extends Remote  { 
	String query(String search) throws RemoteException;  
}
