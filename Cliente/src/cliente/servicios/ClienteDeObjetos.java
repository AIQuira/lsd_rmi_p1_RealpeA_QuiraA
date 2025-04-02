/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.servicios;

import servidor.controladores.ControladorGeneradorTurnoInt;
import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;

/**
 *
 * @author anais
 */
public class ClienteDeObjetos {
    
    private static ControladorGeneradorTurnoInt objRemoto;
    
    public static void main(String[] args)
    {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
         System.out.println("Cual es la direccion ip donde se encuentra el rmiregistry ");
         direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
         System.out.println("Cual es el npumero de puerto por el cual escucha el rmiregistry");
         numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();
         
         objRemoto = (ControladorGeneradorTurnoInt) UtilidadesRegistroC.obtenerObjRemoto(
            direccionIpRMIRegistry,
            numPuertoRMIRegistry,
            "controladorGeneradorTurno");
         Menu objMenu = new Menu(objRemoto);
         objMenu.ejecutarMenuPrincipal();
    }
}
