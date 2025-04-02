package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.NodoTurnoDTO;

public interface ControladorGeneradorTurnoInt extends Remote{
    public NodoTurnoDTO generarTurno (String identificacion) throws RemoteException;
}
