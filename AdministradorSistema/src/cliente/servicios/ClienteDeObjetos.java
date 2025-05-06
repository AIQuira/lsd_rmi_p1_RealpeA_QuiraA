package cliente.servicios;

import cliente.controladores.ControladorCallBackAdminImpl;
import cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import servidor.controladores.ControladorAdministradorSistemaInt;

public class ClienteDeObjetos {

    private static ControladorAdministradorSistemaInt objRemoto;

    public static void main(String args[]) {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry;
        System.out.println("Cual es la direccion ip donde se encuentra el rmiregistry del servidor de turnos:");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry del servidor de turnos:");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        objRemoto = (ControladorAdministradorSistemaInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistry,
                numPuertoRMIRegistry,
                "controladorAdministradorSistema");

        ControladorCallBackAdminImpl objRemotoLadoCliente;
        try {
            objRemotoLadoCliente = new ControladorCallBackAdminImpl();
            objRemoto.registrarReferenciaAdministradorSistema(objRemotoLadoCliente);
            System.out.println("Solicitando activación del sistema...");
            boolean activado = objRemoto.activarSistema();
            if (activado) {
                System.out.println("El sistema fue activado correctamente.");
                System.out.println("Esperando notificaciones...");
            } else {
                System.out.println("No se pudo activar el sistema.");
            }

        } catch (RemoteException ex) {
            System.out.println("Error al registrar el administrador.");
        }
    }
}
