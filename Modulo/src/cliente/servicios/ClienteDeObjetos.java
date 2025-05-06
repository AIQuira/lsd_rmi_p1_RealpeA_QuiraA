package cliente.servicios;

import cliente.controladores.ControladorCallBackImpl;
import cliente.utilidades.UtilidadesConsola;
import cliente.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.ModuloDTO;
import servidor.controladores.ControladorAdministradorModuloInt;
import servidor.controladores.ControladorRegistroReferenciaModulosInt;

public class ClienteDeObjetos {
    
    private static ControladorRegistroReferenciaModulosInt objRemoto;
//    private static ControladorAdministradorModuloInt objAdminModulo;
    
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
        
        try{
            ControladorCallBackImpl objRemotoLadoCliente;
            objRemotoLadoCliente = new ControladorCallBackImpl();
            try {
                objRemoto.registrarReferenciaModulo(objRemotoLadoCliente, noModulo);
                System.out.println("Esperando notificaciones");
            } catch (RemoteException ex) {
                System.out.println("Error al registrar el modulo en el servidor");
            }

            int opcion = 0;
            do {
                System.out.println("==============    Menu   ================");
                System.out.println("        1. Liberar Modulo        ");
                System.out.println("        2. Salir                ");
                System.out.println("==================    ===================");
                System.out.println("Digite una opcion: ");

                opcion = UtilidadesConsola.leerEntero();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el numero del modulo a liberar: ");
                        int noModuloLiberar = UtilidadesConsola.leerEntero();
                       
                        int respuestaLiberacion = objRemoto.liberarModulo(noModuloLiberar, objRemotoLadoCliente);
                        
                        if(respuestaLiberacion == -1){
                            System.out.println("No se encontro el modulo en las referencias.");
                        }if(respuestaLiberacion == -2){
                            System.out.println("No puede liberar un modulo que no sea el propio.");
                        }if(respuestaLiberacion == -3){
                            System.out.println("El modulo ya se encuentra liberado.");
                        }else{
                            System.out.println("Modulo liberado correctamente.");
                        }
                        break;
                    case 2:
                        System.out.println("Salir...");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } while (opcion != 2);
            
        } catch (RemoteException e){
            System.out.println("Error al liberar el modulo: "+ e.getMessage());
            e.printStackTrace();
        }
        
    }
}
