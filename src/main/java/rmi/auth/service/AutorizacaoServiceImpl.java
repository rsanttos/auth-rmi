package rmi.auth.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import rmi.auth.dominio.Usuario;
import rmi.auth.dto.AutorizacaoService;

public class AutorizacaoServiceImpl extends UnicastRemoteObject implements AutorizacaoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	
	public AutorizacaoServiceImpl() throws RemoteException {
		super();
	}
	
	@Override
	public Boolean acessaRecurso(String nome, String recurso) throws RemoteException {
		Optional<Usuario> optUsuario = usuarioService.findByNome(nome);
		
		if(optUsuario.isEmpty()) {
			return false;
		} 
		
		List<String> recursos = Arrays.asList(optUsuario.get().getPapel().getRecursos());
		return recursos.contains(recurso);
	}

}
