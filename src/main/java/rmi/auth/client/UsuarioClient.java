package rmi.auth.client;

import java.rmi.Naming;

import rmi.auth.dominio.Usuario;
import rmi.auth.dto.AutenticacaoService;
import rmi.auth.dto.AutorizacaoService;
import rmi.auth.dto.UsuarioService;
import rmi.auth.enums.PapelEnum;

public class UsuarioClient {
	public static void main(String args[]) {
		
		Usuario usuario = new Usuario("nome", "senha", PapelEnum.USUARIO_COMUM);
		
		try {
			UsuarioService usuarioService = (UsuarioService) Naming.lookup("rmi://localhost:1900/usuario");
			
			Boolean resposta = usuarioService.salvar(usuario.getNome(), usuario.getSenha(), usuario.getPapel());
			System.out.println("Usuário cadastrado com sucesso? " + resposta);
			System.out.println(usuarioService.listar());
			
			AutenticacaoService autenticacaoService = (AutenticacaoService) Naming.lookup("rmi://localhost:1900/autenticacao");
			System.out.println("Usuário autenticado? " + autenticacaoService.login(usuario.getNome(), usuario.getSenha()));
			
			AutorizacaoService autorizacaoService = (AutorizacaoService) Naming.lookup("rmi://localhost:1900/autorizacao");
			System.out.println("Usuário autorizacao? " + autorizacaoService.acessaRecurso(usuario.getNome(), "CADASTRAR_USUARIO"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
