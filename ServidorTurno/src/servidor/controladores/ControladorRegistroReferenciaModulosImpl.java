package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import servidor.DTO.ModuloDTO;

public class ControladorRegistroReferenciaModulosImpl extends UnicastRemoteObject implements ControladorRegistroReferenciaModulosInt{
    
    private final HashMap<Integer, ControladorCallBackInt> referencias;
    private final HashMap<Integer, ModuloDTO> modulosRegistrados; // nuevo
    private final ControladorAdministradorSistemaImpl adminSistema;
    
    public ControladorRegistroReferenciaModulosImpl(ControladorAdministradorSistemaImpl adminSistema) throws RemoteException {
        super();
        this.referencias = new HashMap();
        this.modulosRegistrados = new HashMap<>();
        this.adminSistema = adminSistema;
    }

    @Override
    public void registrarReferenciaModulo(ControladorCallBackInt referenciaModulo, int noModulo) throws RemoteException {
        if (adminSistema.estaActivo()){
            if(!referencias.containsKey(noModulo)){
                this.referencias.put(noModulo, referenciaModulo);
                this.modulosRegistrados.put(noModulo, new ModuloDTO(String.valueOf(noModulo), true)); // ocupado
            }else{
                System.out.println("Error al registrar el modulo en el servidor, ese modulo ya esta registrado.");
                throw new IllegalArgumentException("Error al registrar el modulo en el servidor, ese modulo ya esta registrado.");
            }
        } else {
            System.out.println("El sistema no ha sido activado, no se pueden asignar modulos.");
            throw new RemoteException("El sistema no ha sido activado, no se pueden asignar modulos.");
        }
    }
    
    public void notificarModulo(String mensaje, int noModulo) {
        var referencia = this.referencias.get(noModulo);
        try {
            referencia.notificarAsignacionTurno(mensaje);
        } catch (RemoteException ex) {
            System.out.println("Error al notificar al modulo");
        }
    }

    @Override
    public List<ModuloDTO> obtenerModulosDTO() throws RemoteException {
        return new ArrayList<>(modulosRegistrados.values());
    }

    @Override
    public int liberarModulo(int idModulo, ControladorCallBackInt refModulo) throws RemoteException {
        if(!referencias.containsKey(idModulo)){
            return -1;
        }
        if(!referencias.get(idModulo).equals(refModulo)){
            return -2;
        }
        else if(!modulosRegistrados.get(idModulo).isOcupado()){
            return -3;
        }
        modulosRegistrados.get(idModulo).setOcupado(false);
        return 1;
    }
}