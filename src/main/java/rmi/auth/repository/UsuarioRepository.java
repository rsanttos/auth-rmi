package rmi.auth.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import rmi.auth.dominio.Usuario;

public class UsuarioRepository {

	List<Usuario> usuarios = null;

	static UsuarioRepository USUARIO_REPOSITORY;

	public UsuarioRepository() {
		super();
		this.usuarios = getUsuarios();
	}

	public List<Usuario> getUsuarios() {
		if (Objects.isNull(usuarios)) {
			return new ArrayList<Usuario>();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void add(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	public static synchronized UsuarioRepository getInstance() {
		if(Objects.isNull(USUARIO_REPOSITORY)) {
			USUARIO_REPOSITORY = new UsuarioRepository();
		}
		return USUARIO_REPOSITORY;
	}
}
