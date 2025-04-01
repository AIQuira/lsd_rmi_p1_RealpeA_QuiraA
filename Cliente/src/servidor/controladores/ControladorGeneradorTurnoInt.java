/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.controladores;

import servidor.DTO.NodoTurnoDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorGeneradorTurnoInt extends Remote{
    public NodoTurnoDTO generarTurno(String identificacion) throws RemoteException;
}
