package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.ModuloDTO;

public interface ControladorAdministradorModuloInt extends Remote {
    public List<ModuloDTO> listarModulos() throws RemoteException;
    boolean liberarModulo(String idModulo) throws RemoteException;
}
