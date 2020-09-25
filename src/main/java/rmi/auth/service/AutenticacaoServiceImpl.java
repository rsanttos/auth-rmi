package rmi.auth.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;

import rmi.auth.dominio.Usuario;
import rmi.auth.dto.AutenticacaoService;

public class AutenticacaoServiceImpl extends UnicastRemoteObject implements AutenticacaoService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	
	public AutenticacaoServiceImpl() throws RemoteException {
		super();
	}
	
	@Override
	public Boolean login(String nome, String senha) {		
		Optional<Usuario> optUsuario = usuarioService.findByNome(nome);		
		if(optUsuario.isEmpty()) {
			return false;
		} else {
			return optUsuario.get().getSenha().equals(senha);
		}		
	}

	
	
}
