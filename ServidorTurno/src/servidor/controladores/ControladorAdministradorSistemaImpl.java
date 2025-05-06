package servidor.controladores;

import cliente.controladores.ControladorCallBackAdminInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ControladorAdministradorSistemaImpl extends UnicastRemoteObject implements ControladorAdministradorSistemaInt {

    private final HashMap<Integer, ControladorCallBackAdminInt> referencias;
    public ControladorAdministradorSistemaImpl() throws RemoteException {
        super();
        this.referencias = new HashMap();
    }

    @Override
    public void activarSistema() throws RemoteException {
        try {
            System.out.println("Activando el sistema...");

        } catch (Exception e) {
            System.out.println("Error al activar el sistema");
            e.printStackTrace();
        }
    }

    @Override
    public void registrarReferenciaAdministradorSistema(ControladorCallBackAdminInt Administrador, int id) throws RemoteException {
        this.referencias.put(id, Administrador);
    }
    
    public void notificarAdministrador (String mensaje, int id) {
        var referencia = this.referencias.get(id);
        try {
            referencia.notificarModulosOcupados(mensaje);
        } catch (RemoteException ex) {
            System.out.println("Error al notificar al Administrador del Sistema");
        }
    }

}
