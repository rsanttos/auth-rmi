package rmi.auth.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.auth.dto.UsuarioService;
import rmi.auth.service.UsuarioServiceImpl;

public class UsuarioServer {

	public static void main(String args[]) {
		try {
			UsuarioService obj = new UsuarioServiceImpl();
			LocateRegistry.createRegistry(1900);
			Naming.rebind("rmi://localhost:1900/usuario", obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
