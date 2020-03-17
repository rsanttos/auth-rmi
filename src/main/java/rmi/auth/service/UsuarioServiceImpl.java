package rmi.auth.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.auth.dominio.Usuario;
import rmi.auth.dto.UsuarioService;
import rmi.auth.repository.UsuarioRepository;

public class UsuarioServiceImpl extends UnicastRemoteObject implements UsuarioService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioServiceImpl() throws RemoteException {
		super();
	}
	
	public Boolean salvar(String login, String senha) {
		try {
			Usuario usuario = new Usuario(login, senha);
			UsuarioRepository repo = UsuarioRepository.getInstance();
			repo.add(usuario);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
