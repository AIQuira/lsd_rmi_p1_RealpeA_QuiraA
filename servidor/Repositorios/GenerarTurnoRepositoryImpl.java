package servidor.Repositorios;

import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.ModuloDTO;

public class GenerarTurnoRepositoryImpl implements GeneradorTurnoRepositoryInt {
    
    private int numeroTurno;
    private int CantidadUsuariosFila = 0;
    private final ModuloDTO vectorModulos[];
    private final String usuariosFilaVirtual[];

    @Override
    public GenerarTurnoRepositoryImpl()
    {
        System.out.println("Configurando Modulos...");
        this.vectorModulos = new ModuloDTO[3];
        this.usuariosFilaVirtual = new String[10];
        this.numeroTurno = 1;
        for(int i = 0; i<3; i++){
            this.vectorModulos[i] = new ModuloDTO();
            this.vectorModulos[i].setNumeroModulo(i+1);
            this.vectorModulos[i].setOcupado(false);
        }
    }

    @Override
    public ConsultarNumeroModuloDisponible(){
        int posicion = -1;

        for(int i = 0: i<3: i++){
            if (this.vectorModulos[i].isOcupado() == false) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    @Override
    public NodoTurnoDTO generarTurno(String identificacion){
        int posicion = this.
    }
}
