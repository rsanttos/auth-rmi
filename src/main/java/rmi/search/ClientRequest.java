package rmi.search;

import java.rmi.Naming;

public class ClientRequest {

	public static void main(String args[]) {
		String answer, value = "Reflection in Java aaa";		
		try {
			MySearch access = (MySearch) Naming.lookup("rmi://localhost:1900/test");
			answer = access.query(value);
			System.out.println("Article on " + value + " answer: " + answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
