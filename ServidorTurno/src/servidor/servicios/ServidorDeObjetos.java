package servidor.servicios;

import java.rmi.RemoteException;
import servidor.Repositorios.GenerarTurnoRepositoryImpl;
import servidor.controladores.ControladorDisplayInt;
import servidor.controladores.ControladorGeneradorTurnoImpl;
import servidor.utilidades.UtilidadesConsola;
import servidor.utilidades.UtilidadesRegistroC;
import servidor.utilidades.UtilidadesRegistroS;

public class ServidorDeObjetos {

    public static void main(String args[]) throws RemoteException {

        int numPuertoRMIRegistryServidorTurnos = 0;
        String direccionIpRMIRegistryServidorTurnos = "";
        
        int numPuertoRMIRegistryServidorDisplay = 0;
        String direccionIpRMIRegistryServidorDisplay = "";

        System.out.println("Cual es el la direccion ip donde se encuentra  el rmiRegistry del servidor de turno");
        direccionIpRMIRegistryServidorTurnos = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry del servidor de turno");
        numPuertoRMIRegistryServidorTurnos = UtilidadesConsola.leerEntero();

        System.out.println("Cual es el la direccion ip donde se encuentra  el rmiRegistry del servidor display");
        direccionIpRMIRegistryServidorDisplay = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry del servidor display");
        numPuertoRMIRegistryServidorDisplay = UtilidadesConsola.leerEntero();

        ControladorDisplayInt objRemotoDisplay = (ControladorDisplayInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistryServidorDisplay,
                numPuertoRMIRegistryServidorDisplay,
                "controladorDisplay");
                
        GenerarTurnoRepositoryImpl objRepositorio = new GenerarTurnoRepositoryImpl(objRemotoDisplay);
        ControladorGeneradorTurnoImpl objRemoto = new ControladorGeneradorTurnoImpl(objRepositorio);

        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryServidorTurnos);
            UtilidadesRegistroS.RegistrarObjetoRemoto(
                    objRemoto,
                    direccionIpRMIRegistryServidorTurnos,
                    numPuertoRMIRegistryServidorTurnos,
                    "controladorGeneradorTurno");

        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }
}
