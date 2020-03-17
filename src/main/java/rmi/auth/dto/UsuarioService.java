package rmi.auth.dto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsuarioService extends Remote {
	Boolean salvar(String login, String senha) throws RemoteException;
}
