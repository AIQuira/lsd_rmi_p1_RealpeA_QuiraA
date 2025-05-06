package servidor.controladores;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.ModuloDTO;

public class ControladorAdministradorModuloImpl extends UnicastRemoteObject implements ControladorAdministradorModuloInt {
    
    private final List<ModuloDTO> listaModulos;
    
    public ControladorAdministradorModuloImpl(List<ModuloDTO> listarModulos) throws RemoteException{
        super();
        this.listaModulos = listarModulos;
    }
    
    @Override
    public boolean liberarModulo(String idModulo) throws RemoteException {
        for(ModuloDTO modulo : listaModulos){
            if(modulo.getIdentificacion().equals(idModulo)){
                modulo.setOcupado(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ModuloDTO> listarModulos() throws RemoteException {
        return listaModulos;
    }
    
}
