package servidor.DTO;

import java.io.Serializable;

public class NodoTurnoDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int numeroTurno;
    private int cantidadUsuariosFilaVirtual;
    private String identificacion;

    public NodoTurnoDTO(int numeroTurno, int cantidadUsuariosFilaVirtual, String identificacion) {
        this.numeroTurno = numeroTurno;
        this.cantidadUsuariosFilaVirtual = cantidadUsuariosFilaVirtual;
        this.identificacion = identificacion;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public int getCantidadUsuariosFilaVirtual() {
        return cantidadUsuariosFilaVirtual;
    }

    public void setCantidadUsuariosFilaVirtual(int cantidadUsuariosFilaVirtual) {
        this.cantidadUsuariosFilaVirtual = cantidadUsuariosFilaVirtual;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
