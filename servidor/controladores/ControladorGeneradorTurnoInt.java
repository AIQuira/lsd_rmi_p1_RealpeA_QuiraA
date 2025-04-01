package servidor.controladores;

import java.rmi.RemoteException;

public interface ControladorGeneradorTurnoInt extends Remote{
    public NodoTurnoDTO generarTurno (String identificacion) throws RemoteException;
}
