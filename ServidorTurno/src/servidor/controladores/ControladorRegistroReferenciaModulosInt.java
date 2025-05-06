package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.ModuloDTO;

public interface ControladorRegistroReferenciaModulosInt extends Remote{
    public void registrarReferenciaModulo(ControladorCallBackInt referenciaModulo, int noModulo) throws RemoteException;
    int liberarModulo(int idModulo, ControladorCallBackInt refModulo) throws RemoteException;
    public List<ModuloDTO> obtenerModulosDTO() throws RemoteException;
}
