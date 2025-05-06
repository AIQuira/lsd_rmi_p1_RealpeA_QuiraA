package cliente.servicios;

import cliente.controladores.ControladorCallBackAdminImpl;
import cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import servidor.controladores.ControladorAdministradorSistemaInt;

public class ClienteDeObjetos {
    
    private static ControladorAdministradorSistemaInt objRemoto;
    
    public static void main (String args[]){
        int numPuertoRMIRegistry = 0;
        int idAdministrador;
        String direccionIpRMIRegistry;
        System.out.println("Cual es la direccion ip donde se encuentra el rmiregistry del servidor de turnos:");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry del servidor de turnos:");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();
        System.out.println("Ingrese su identificación: ");
        idAdministrador = cliente.utilidades.UtilidadesConsola.leerEntero();
        
        objRemoto = (ControladorAdministradorSistemaInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistry, 
                numPuertoRMIRegistry, 
                "controladorAdministradorSistema");
        
        ControladorCallBackAdminImpl objRemotoLadoCliente;
        try {
            objRemotoLadoCliente = new ControladorCallBackAdminImpl();
            objRemoto.registrarReferenciaAdministradorSistema(objRemotoLadoCliente, idAdministrador);
            System.out.println("Esperando notificaciones...");
        } catch (RemoteException ex) {
            System.out.println("Error al registrar el administrador.");
        }
    }
}
