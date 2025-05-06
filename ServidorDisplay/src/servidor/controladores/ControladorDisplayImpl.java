package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import servidor.DTO.ModuloDTO;
import servidor.DTO.NotificacionDTO;

public class ControladorDisplayImpl extends UnicastRemoteObject implements ControladorDisplayInt{
    
    public ControladorDisplayImpl () throws RemoteException
    {
        super();
    }

    @Override
    public void mostrarNotificacion(NotificacionDTO objNotificacion) throws RemoteException {
        String horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        ModuloDTO vectorModulos[] = objNotificacion.getVectorModulos();
        System.out.println("==== Turnos y Modulos asignados ====");
        System.out.printf("%-10s %-10s %-20s%n", "No modulo", "No Turno", "No Identificacion");
        for (int i = 0; i<3; i++){
            if(vectorModulos[i].isOcupado()) {
                System.out.printf("%-10d %-10d %-20s%n",
                                    vectorModulos[i].getNumeroModulo(),
                                    vectorModulos[i].getNumeroTurno(),
                                    vectorModulos[i].getIdentificacion());
            }
        }
        if(objNotificacion.getCantidadUsuariosFilaVirtual() != 0) {
            System.out.println("Cantidad de usuarios en la fila virtual: "+objNotificacion.getCantidadUsuariosFilaVirtual());
        }
        System.out.println("Ultima actualizacion: "+ horaActual);
    }
}
