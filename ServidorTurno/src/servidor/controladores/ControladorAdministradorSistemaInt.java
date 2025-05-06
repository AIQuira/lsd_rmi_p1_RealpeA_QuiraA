package servidor.controladores;

import cliente.controladores.ControladorCallBackAdminInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorAdministradorSistemaInt  extends Remote{
    public void activarSistema () throws RemoteException;
    public void registrarReferenciaAdministradorSistema (ControladorCallBackAdminInt Administrador, int id) throws RemoteException;
}
