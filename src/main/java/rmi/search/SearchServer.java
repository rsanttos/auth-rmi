package rmi.search;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SearchServer {

	public static void main(String args[]) {
		try {
			MySearch obj = new SearchQuery();
			LocateRegistry.createRegistry(1900);
			Naming.rebind("rmi://localhost:1900/test", obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
