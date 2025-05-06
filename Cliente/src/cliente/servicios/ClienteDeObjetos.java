package cliente.servicios;

import servidor.controladores.ControladorGeneradorTurnoInt;
import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import servidor.controladores.ControladorAdministradorModuloInt;

public class ClienteDeObjetos {
    
    private static ControladorGeneradorTurnoInt objRemoto;

    public static void main(String[] args)
    {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
         System.out.println("Cual es la direccion ip donde se encuentra el rmiregistry ");
         direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
         System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry");
         numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();
         
         objRemoto = (ControladorGeneradorTurnoInt) UtilidadesRegistroC.obtenerObjRemoto(
            direccionIpRMIRegistry,
            numPuertoRMIRegistry,
            "controladorGeneradorTurno");
         
         Menu objMenu = new Menu(objRemoto);
         objMenu.ejecutarMenuPrincipal();
    }
}
