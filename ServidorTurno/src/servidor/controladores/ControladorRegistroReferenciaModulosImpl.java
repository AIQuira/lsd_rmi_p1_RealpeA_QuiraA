package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ControladorRegistroReferenciaModulosImpl extends UnicastRemoteObject implements ControladorRegistroReferenciaModulosInt{
    
    private final HashMap<Integer, ControladorCallBackInt> referencias;
    
    public ControladorRegistroReferenciaModulosImpl() throws RemoteException {
        super();
        this.referencias = new HashMap();
    }

    @Override
    public void registrarReferenciaModulo(ControladorCallBackInt referenciaModulo, int noModulo) throws RemoteException {
        this.referencias.put(noModulo, referenciaModulo);
    }
    
    public void notificarModulo(String mensaje, int noModulo) {
        var referencia = this.referencias.get(noModulo);
        try {
            referencia.notificarAsignacionTurno(mensaje);
        } catch (RemoteException ex) {
            System.out.println("Error al notificar al modulo");
        }
    }
    
}
