package rmi.search;

import java.rmi.*;
import java.rmi.server.*;

public class SearchQuery extends UnicastRemoteObject implements MySearch {
	SearchQuery() throws RemoteException {
		super();
	}

	public String query(String search) throws RemoteException {
		String result = "";
		if(search.equals("Reflection in Java")) {
			result = "Achou";
		} else {
			result = "Não achou";
		}
		return result;		
	}
}
