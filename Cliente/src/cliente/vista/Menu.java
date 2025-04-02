package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;

import servidor.DTO.NodoTurnoDTO;
import servidor.controladores.ControladorGeneradorTurnoInt;

public class Menu {

    private final ControladorGeneradorTurnoInt objRemoto;

    public Menu(ControladorGeneradorTurnoInt objRemoto) {
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("===========   Menu   ===========");
            System.out.println("        1. Generar turno        ");
            System.out.println("        2. Salir                ");
            System.out.println("==============    ==============");
            System.out.println("Digite una opcion: ");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 2);
    }

    private void Opcion1() {
        try {
            System.out.println("Digite la identificacion: ");
            String id = UtilidadesConsola.leerCadena();

            NodoTurnoDTO objNodoTurno = objRemoto.generarTurno(id);
            if (objNodoTurno != null) {
                System.out.println("Datos generados por el sistema");
                System.out.println("Numero de identificacion: " + objNodoTurno.getIdentificacion());
                System.out.println("Numero de turno: " + objNodoTurno.getNumeroTurno());
                System.out.println("Cantidad de usuarios en la fila virtual: " + objNodoTurno.getCantidadUsuariosFilaVirtual());
            }
        } catch (RemoteException e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
            e.printStackTrace();
        }
    }
}
