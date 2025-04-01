/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.servicios;

import java.rmi.RemoteException;
import Servidor.utilidades.UtilidadesRegistroS;
import Servidor.Repositorios.GenerarTurnoRepositoryImpl;
import Servidor.controladores.ControladorGeneradorTurnoImpl;
import Servidor.utilidades.UtilidadesConsola;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                       
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();

        GenerarTurnoRepositoryImpl objRepositorio = new GenerarTurnoRepositoryImpl();
        ControladorGeneradorTurnoImpl objRemoto = new ControladorGeneradorTurnoImpl(objRepositorio);
        
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(
            objRemoto,
            direccionIpRMIRegistry,
            numPuertoRMIRegistry,
            "controladorGeneradorTurno");            
           
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
