package Servidor.DTO;

import java.io.Serializable;

public class ModuloDTO implements Serializable{
    
    private int NumeroModulo;
    private boolean ocupado;
    private int numeroTurno;
    private String identificacion;  
    
    public int getSetNumeroModulo() {
        return NumeroModulo;
    }
    public void setNumeroModulo(int setNumeroModulo) {
        this.NumeroModulo = setNumeroModulo;
    }
    public boolean isOcupado() {
        return ocupado;
    }
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public int getNumeroTurno() {
        return numeroTurno;
    }
    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
