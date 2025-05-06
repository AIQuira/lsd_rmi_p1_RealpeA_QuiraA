package cliente.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControladorCallBackAdminImpl extends UnicastRemoteObject implements ControladorCallBackAdminInt{

    public ControladorCallBackAdminImpl() throws RemoteException{
        super();
    }
    
    @Override
    public void notificarModulosOcupados(String mensaje) throws RemoteException {
        System.out.println(mensaje);
    }
    
}
