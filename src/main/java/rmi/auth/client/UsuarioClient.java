package rmi.auth.client;

import java.rmi.Naming;

import rmi.auth.dominio.Usuario;
import rmi.auth.dto.UsuarioService;

public class UsuarioClient {
	public static void main(String args[]) {
		
		Usuario usuario = new Usuario("nome", "senha");
		
		try {
			UsuarioService usuarioService = (UsuarioService) Naming.lookup("rmi://localhost:1900/usuario");
			
			Boolean answer = usuarioService.salvar(usuario.getNome(), usuario.getSenha());
			System.out.println("Answer: " + answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
