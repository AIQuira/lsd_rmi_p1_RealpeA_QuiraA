package Servidor.controladores;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import servidor.DTO.NodoTurnoDTO;
import servidor.Repositorios.ControladorGeneradorTurnoInt;

public class ControladorGeneradorTurnoImpl extends UnicastRemoteObject implements ControladorGeneradorTurnoInt {
    
    private final ControladorGeneradorTurnoInt objRepositorio;

    public ControladorGeneradorTurnoImpl(GenerarTurnoRepositoryInt objRepositorio) throws RemoteException
    {
        super(); //asignando el puerto de escucha del OR
        this.objRepositorio=objRepositorio;
    }

    @Override
    public NodoTurnoDTO generarTurno(int identificacion) throws RemoteException {
        return this.objRepositorio.generarTurno(identificacion);
    }
}
