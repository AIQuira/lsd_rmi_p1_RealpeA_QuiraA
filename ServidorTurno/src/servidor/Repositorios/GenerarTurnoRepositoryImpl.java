package servidor.Repositorios;

import servidor.DTO.ModuloDTO;
import servidor.DTO.NodoTurnoDTO;
import servidor.DTO.NotificacionDTO;
import servidor.controladores.ControladorDisplayInt;
import java.rmi.RemoteException;
import servidor.controladores.ControladorAdministradorSistemaImpl;
import servidor.controladores.ControladorRegistroReferenciaModulosImpl;

public class GenerarTurnoRepositoryImpl implements GenerarTurnoRepositoryInt {

    private int numeroTurno;
    private int CantidadUsuariosFila = 0;
    private final ModuloDTO vectorModulos[];
    private final String usuariosFilaVirtual[];
    //Almacena referencia remota al servidor display
    private final ControladorDisplayInt objRemotoDisplay;
    private final ControladorRegistroReferenciaModulosImpl objRemotoRegistroModulos;
    private final ControladorAdministradorSistemaImpl objRemotoAdministrador;
    
    public GenerarTurnoRepositoryImpl(ControladorDisplayInt objRemotoDisplay, ControladorRegistroReferenciaModulosImpl objRemotoRegistroModulos, ControladorAdministradorSistemaImpl objRemotoAdministrador) {
        System.out.println("Configurando Modulos...");
        this.objRemotoDisplay = objRemotoDisplay;
        this.objRemotoRegistroModulos = objRemotoRegistroModulos;
        this.objRemotoAdministrador = objRemotoAdministrador;
        this.vectorModulos = new ModuloDTO[3];
        this.usuariosFilaVirtual = new String[10];
        this.numeroTurno = 1;
        for (int i = 0; i < 3; i++) {
            this.vectorModulos[i] = new ModuloDTO();
            this.vectorModulos[i].setNumeroModulo(i + 1);
            this.vectorModulos[i].setOcupado(false);
        }
    }

    private int ConsultarNumeroModuloDisponible() {
        int posicion = -1;

        for (int i = 0; i < 3; i++) {
            if (this.vectorModulos[i].isOcupado() == false) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    @Override
    public NodoTurnoDTO generarTurno(String identificacion) {
        int posicion = this.ConsultarNumeroModuloDisponible();

        if (posicion == -1) {
            System.out.println("Los modulos se encuentran ocupado");
            this.usuariosFilaVirtual[this.CantidadUsuariosFila] = identificacion;
            this.CantidadUsuariosFila++;
            System.out.println("Notificando al administrador...");
            this.objRemotoAdministrador.notificarAdministrador("Todos los modulos se encuentran ocupados, se procede a reenviar los turnos a la fila virtual.");
            System.out.println("El usuario se agrego a la fila virtual");
        } else {
            System.out.println("El modulo en la posicion " + posicion + ", esta libre y se "
                    + "asigna al usuario con identificacion " + identificacion);
            this.vectorModulos[posicion].setOcupado(true);
            this.vectorModulos[posicion].setNumeroTurno(this.numeroTurno);
            this.vectorModulos[posicion].setIdentificacion(identificacion);
            System.out.println("Notificando al modulo");
            this.objRemotoRegistroModulos.notificarModulo("Turno "+this.numeroTurno+" asignado al usuario con "+identificacion, posicion+1);
        }
        NodoTurnoDTO objNodoTurnoDTO = new NodoTurnoDTO(numeroTurno, CantidadUsuariosFila, identificacion);
        this.numeroTurno++;
        
        //Se invoca el método remoto mostrar notificación para enviar un mensaje al servidor display
        NotificacionDTO objNotificacion = new NotificacionDTO();
        objNotificacion.setVectorModulos(vectorModulos);
        objNotificacion.setCantidadUsuariosFilaVirtual(CantidadUsuariosFila);
        
        try{
            this.objRemotoDisplay.mostrarNotificacion(objNotificacion);
            System.out.println("Notificando al servidor display...");
        } catch(RemoteException ex){
            System.out.println("No fue posible notificar al servidor display..."+ex.getMessage());
        }
        
        return objNodoTurnoDTO;
    }
    

}