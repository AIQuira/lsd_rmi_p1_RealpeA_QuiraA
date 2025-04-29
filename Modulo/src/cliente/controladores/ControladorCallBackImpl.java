package cliente.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControladorCallBackImpl extends UnicastRemoteObject implements ControladorCallBackInt{

    public ControladorCallBackImpl() throws RemoteException {
        super();
    }
    
    @Override
    public void notificarAsignacionTurno(String mensaje) throws RemoteException {
        System.out.println(mensaje);
    }
    
}
