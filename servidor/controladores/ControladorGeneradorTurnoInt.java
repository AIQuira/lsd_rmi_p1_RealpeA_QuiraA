package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Servidor.DTO.NodoTurnoDTO;

public interface ControladorGeneradorTurnoInt extends Remote{
    public NodoTurnoDTO generarTurno (String identificacion) throws RemoteException;
}
