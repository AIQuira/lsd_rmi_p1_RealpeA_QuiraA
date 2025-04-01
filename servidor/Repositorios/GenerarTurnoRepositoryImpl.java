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
        int posicion = this.ConsultarNumeroModuloDisponible();

        if(posicion == -1){
            System.out.println("Los modulos se encuentran ocupado");
            this.usuariosFilaVirtual[this.CantidadUsuariosFila] = identificacion;
            this.CantidadUsuariosFila++;
            System.out.println("El usuario se agrego a la fila virtual");
        }
        else{
            System.out.println("El modulo en la posicion "+posicion+", esta libre y se "
                    + "asigna al usuario con identificacion "+identificacion);
            this.vectorModulos[posicion].setOcupado(true);
            this.vectorModulos[posicion].setNumeroTurno(this.numeroTurno);
            this.vectorModulos[posicion].setIdentificacion(identificacion);
        }
        NodoTurnoDTO objNodoTurnoDTO = new NodoTurnoDTO(numeroTurno, CantidadUsuariosFila, identificacion);
        this.numeroTurno++;
        
        return objNodoTurnoDTO;
    }
}
