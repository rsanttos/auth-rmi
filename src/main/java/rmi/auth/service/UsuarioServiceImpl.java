package rmi.auth.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import rmi.auth.dominio.Usuario;
import rmi.auth.dto.UsuarioService;
import rmi.auth.enums.PapelEnum;
import rmi.auth.repository.UsuarioRepository;

public class UsuarioServiceImpl extends UnicastRemoteObject implements UsuarioService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioServiceImpl() throws RemoteException {
		super();
	}
	
	public Boolean salvar(String login, String senha, PapelEnum papel) {
		try {
			Usuario usuario = new Usuario(login, senha, papel);
			UsuarioRepository repo = UsuarioRepository.getInstance();
			repo.add(usuario);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public List<Usuario> listar() throws RemoteException {
		UsuarioRepository repo = UsuarioRepository.getInstance();		
		return repo.getUsuarios();
	}

	public Optional<Usuario> findByNome(String nome){
		Predicate<Usuario> byNome = usuario -> usuario.getNome().equals(nome);
		UsuarioRepository repo = UsuarioRepository.getInstance();	
        List<Usuario> usuariosEncontrados = repo.getUsuarios().stream().filter(byNome).collect(Collectors.toList());
        
        Optional<Usuario> opt = Optional.empty();
        
        if(!Objects.isNull(usuariosEncontrados) && usuariosEncontrados.size() > 0) {
        	opt = Optional.ofNullable(usuariosEncontrados.get(0));
        }
        return opt;
	}
	
}
