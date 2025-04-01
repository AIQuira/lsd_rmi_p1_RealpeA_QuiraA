package Servidor.controladores;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import Servidor.Repositorios.GenerarTurnoRepositoryInt;
import Servidor.DTO.NodoTurnoDTO;

public class ControladorGeneradorTurnoImpl extends UnicastRemoteObject implements ControladorGeneradorTurnoInt {
    
    private final GenerarTurnoRepositoryInt objRepositorio;

    public ControladorGeneradorTurnoImpl(GenerarTurnoRepositoryInt objRepositorio) throws RemoteException
    {
        super(); //asignando el puerto de escucha del OR
        this.objRepositorio=objRepositorio;
    }

    @Override
    public NodoTurnoDTO generarTurno (String identificacion) throws RemoteException {
        return this.objRepositorio.generarTurno(identificacion);
    }
}
