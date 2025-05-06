package servidor.controladores;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.ModuloDTO;

public class ControladorAdministradorModuloImpl extends UnicastRemoteObject implements ControladorAdministradorModuloInt {
    
    private final ControladorRegistroReferenciaModulosInt registroModulos;
    
    public ControladorAdministradorModuloImpl(ControladorRegistroReferenciaModulosInt registroModulos) throws RemoteException{
        super();
        this.registroModulos = registroModulos;
    }
    
    @Override
    public boolean liberarModulo(String idModulo) throws RemoteException {
        List<ModuloDTO> modulos = registroModulos.obtenerModulosDTO();
        for (ModuloDTO modulo : modulos) {
            if (modulo.getIdentificacion().equals(idModulo)) {
                modulo.setOcupado(false); 
            }
        }
        return false;
    }
    @Override
    public List<ModuloDTO> listarModulos() throws RemoteException {
        return registroModulos.obtenerModulosDTO();
    }
}