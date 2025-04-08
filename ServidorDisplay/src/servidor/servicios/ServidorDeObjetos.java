package servidor.servicios;

import java.rmi.RemoteException;
import servidor.controladores.ControladorDisplayImpl;
import servidor.utilidades.UtilidadesConsola;
import servidor.utilidades.UtilidadesRegistroS;

public class ServidorDeObjetos {
    public static void main(String args[]) throws RemoteException {
        int numPuertoRMIRegistryServidorDisplay = 0;
        String direccionIpRMIRegistryServidorDisplay = "";
        System.out.println("Cual es la direccion ip donde se encuentra el rmiRegistry del servidor display");
        direccionIpRMIRegistryServidorDisplay = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero del puerto por el cual escucha el rmiRegistry del servidor display");
        numPuertoRMIRegistryServidorDisplay = UtilidadesConsola.leerEntero();
        ControladorDisplayImpl objRemoto = new ControladorDisplayImpl();
        
        try
        {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryServidorDisplay);
            UtilidadesRegistroS.RegistrarObjetoRemoto(
                    objRemoto, 
                    direccionIpRMIRegistryServidorDisplay, 
                    numPuertoRMIRegistryServidorDisplay, 
                    "controladorDisplay");
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
