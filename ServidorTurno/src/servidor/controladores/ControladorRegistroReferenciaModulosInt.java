package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorRegistroReferenciaModulosInt extends Remote{
    public void registrarReferenciaModulo(ControladorCallBackInt referenciaModulo, int noModulo) throws RemoteException;
}
