package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.NodoTurnoDTO;
import servidor.Repositorios.GenerarTurnoRepositoryInt;

public class ControladorGeneradorTurnoImpl extends UnicastRemoteObject implements ControladorGeneradorTurnoInt {

    private final GenerarTurnoRepositoryInt objRepositorio;

    public ControladorGeneradorTurnoImpl(GenerarTurnoRepositoryInt objRepositorio) throws RemoteException {
        super(); //asignando el puerto de escucha del OR
        this.objRepositorio = objRepositorio;
    }

    @Override
    public NodoTurnoDTO generarTurno(String identificacion) throws RemoteException {
        return this.objRepositorio.generarTurno(identificacion);
    }

}
