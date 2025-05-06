package servidor.controladores;

import cliente.controladores.ControladorCallBackAdminInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControladorAdministradorSistemaImpl extends UnicastRemoteObject implements ControladorAdministradorSistemaInt{

    private boolean sistemaActivo = false;
    private ControladorCallBackAdminInt referencia;
    
    public ControladorAdministradorSistemaImpl() throws RemoteException{
        super();
        this.referencia = null;
    }
    
    @Override
    public boolean activarSistema() throws RemoteException {
        if (this.sistemaActivo == false){
            this.sistemaActivo = true;
            System.out.println("Activando sistema...");
        } else {
            System.out.println("No se puede activar el sistema.");
        }
        return sistemaActivo;
    }

    @Override
    public void registrarReferenciaAdministradorSistema(ControladorCallBackAdminInt Administrador) throws RemoteException {
        if(this.referencia == null) {
            this.referencia = Administrador;
            System.out.println("Administrador del Sistema registrado exitosamente.");
        } else {
            System.out.println("Ya hay un administrador del sistema conectado");
        }
    }
    
    public void notificarAdministrador(String mensaje) {
        try {
            referencia.notificarModulosOcupados(mensaje);
        } catch (RemoteException ex) {
            System.out.println("Error al notificar al administrador del sistema.");
        }
    }
    
    public boolean estaActivo() {
        return this.sistemaActivo;
    }
}
