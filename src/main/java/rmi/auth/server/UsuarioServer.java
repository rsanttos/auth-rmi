package rmi.auth.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.auth.dto.AutenticacaoService;
import rmi.auth.dto.AutorizacaoService;
import rmi.auth.dto.UsuarioService;
import rmi.auth.service.AutenticacaoServiceImpl;
import rmi.auth.service.AutorizacaoServiceImpl;
import rmi.auth.service.UsuarioServiceImpl;

public class UsuarioServer {

	public static void main(String args[]) {
		try {
			UsuarioService obj = new UsuarioServiceImpl();
			LocateRegistry.createRegistry(1900);
			Naming.rebind("rmi://localhost:1900/usuario", obj);	
			
			AutenticacaoService autenticacaoService = new AutenticacaoServiceImpl();			
			Naming.rebind("rmi://localhost:1900/autenticacao", autenticacaoService);
			
			AutorizacaoService autorizacaoService = new AutorizacaoServiceImpl();			
			Naming.rebind("rmi://localhost:1900/autorizacao", autorizacaoService);		
			
			System.out.println("Servidor executando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
