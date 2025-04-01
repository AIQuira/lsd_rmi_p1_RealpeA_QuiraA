
package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.UsuarioDTO;
import servidor.Repositorios.UsuariosRepositoryInt;

public class ControladorGestorUsuariosIml extends UnicastRemoteObject implements ControladorGestorUsuariosInt{
    
    private final UsuariosRepositoryInt objUsuariosRepository;

    public ControladorGestorUsuariosIml(UsuariosRepositoryInt objUsuariosRepository) throws RemoteException
    {
        super(); 
        this.objUsuariosRepository=objUsuariosRepository;
    }

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuario) throws RemoteException
    {
        return this.objUsuariosRepository.registrarUsuario(objUsuario);
    }
    
    @Override
    public int consultarCantidadUsuarios() throws RemoteException
    {
       return this.objUsuariosRepository.consultarCantidadUsuarios();
    }

    @Override
    public UsuarioDTO consultarUsuario(int identificacion) throws RemoteException {
        return this.objUsuariosRepository.consultarUsuario(identificacion);
    }
}
