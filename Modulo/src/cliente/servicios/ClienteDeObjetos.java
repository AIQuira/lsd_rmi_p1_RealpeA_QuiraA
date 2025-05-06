package cliente.servicios;

import cliente.controladores.ControladorCallBackImpl;
import cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import servidor.controladores.ControladorRegistroReferenciaModulosInt;

public class ClienteDeObjetos {
    
    private static ControladorRegistroReferenciaModulosInt objRemoto;
    
    public static void main (String[] args)
    {
        int numPuertoRMIRegistry = 0;
        int noModulo;
        String direccionIpRMIRegistry = "";
        System.out.println("Cual es la direccion ip donde se encuentra el rmiregistry del servidor de turnos");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry del servidor de turnos");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();
        System.out.println("Cual es el numero de modulo asignado");
        noModulo = cliente.utilidades.UtilidadesConsola.leerEntero();
        objRemoto = (ControladorRegistroReferenciaModulosInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistry,
                numPuertoRMIRegistry,
                "controladorRegistroReferenciaModulos");
        
        ControladorCallBackImpl objRemotoLadoCliente;
        try {
            objRemotoLadoCliente = new ControladorCallBackImpl();
            objRemoto.registrarReferenciaModulo(objRemotoLadoCliente, noModulo);
            System.out.println("Esperando notificaciones");
        } catch (RemoteException ex) {
            System.out.println("Error al registrar el modulo en el servidor: "+ex.getCause().getMessage());
        }
    }
}
