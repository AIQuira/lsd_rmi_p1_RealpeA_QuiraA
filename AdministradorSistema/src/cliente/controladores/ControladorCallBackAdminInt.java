package cliente.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorCallBackAdminInt extends Remote{
    public void notificarModulosOcupados(String mensaje) throws RemoteException;
}
