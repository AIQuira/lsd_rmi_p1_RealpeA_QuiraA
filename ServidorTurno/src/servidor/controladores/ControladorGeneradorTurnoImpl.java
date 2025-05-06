package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.NodoTurnoDTO;
import servidor.Repositorios.GenerarTurnoRepositoryInt;

public class ControladorGeneradorTurnoImpl extends UnicastRemoteObject implements ControladorGeneradorTurnoInt {

    private final GenerarTurnoRepositoryInt objRepositorio;
    private final ControladorAdministradorSistemaImpl objAdministradorSistema;

    public ControladorGeneradorTurnoImpl(GenerarTurnoRepositoryInt objRepositorio, ControladorAdministradorSistemaImpl objAdministradorSistema) throws RemoteException {
        super(); //asignando el puerto de escucha del OR
        this.objRepositorio = objRepositorio;
        this.objAdministradorSistema = objAdministradorSistema;
    }

    @Override
    public NodoTurnoDTO generarTurno(String identificacion) throws RemoteException {
        if(!objAdministradorSistema.estaActivo()){
            System.out.println("El sistema no ha sido activado por el administrador.");
            throw new RemoteException ("El sistena no ha sido activado, no se pueden generar turnos");
        }
        return this.objRepositorio.generarTurno(identificacion);
    }

}
