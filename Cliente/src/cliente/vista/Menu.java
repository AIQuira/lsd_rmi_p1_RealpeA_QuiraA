package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.ModuloDTO;

import servidor.DTO.NodoTurnoDTO;
import servidor.controladores.ControladorAdministradorModuloInt;
import servidor.controladores.ControladorGeneradorTurnoInt;

public class Menu {

    private final ControladorGeneradorTurnoInt objRemoto;
    private final ControladorAdministradorModuloInt objAdminModulo;

    public Menu(ControladorGeneradorTurnoInt objRemoto, ControladorAdministradorModuloInt adminModulo) {
        this.objRemoto = objRemoto;
        this.objAdminModulo = adminModulo;
    }

    public void ejecutarMenuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("==============    Menu   ================");
            System.out.println("        1. Generar turno        ");
            System.out.println("        2. Administrar Modulo (Liberar)        ");
            System.out.println("        3. Salir                ");
            System.out.println("==================    ===================");
            System.out.println("Digite una opcion: ");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 3);
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
    private void Opcion2(){
        try{
            List<ModuloDTO> modulos = objAdminModulo.listarModulos();
            System.out.println("=== Lista de módulos ===");
            for (ModuloDTO m : modulos) {
                System.out.println("ID: " + m.getIdentificacion() +
                                   " | Numero de Modulo: " + m.getNumeroModulo() +
                                   " | Ocupado: " + (m.isOcupado() ? "Sí" : "No"));
            }
            
            System.out.println("Ingrese el numero del modulo a liberar: ");
            String id = UtilidadesConsola.leerCadena();
            
            boolean exito = objAdminModulo.liberarModulo(id);
            if(exito){
                System.out.println("Modulo liberado correctamente.");
            }else{
                System.out.println("No se encontro el modulo con ese numero.");
            }
        } catch (RemoteException e){
            System.out.println("Error al liberar el modulo: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
