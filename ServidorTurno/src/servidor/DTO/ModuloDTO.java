package servidor.DTO;

import java.io.Serializable;

public class ModuloDTO implements Serializable{
    private int numeroModulo;
    private boolean ocupado;
    private int numeroTurno;
    private String identificacion;
    
    public ModuloDTO(){
    }
    
    public ModuloDTO(String identificacion, boolean ocupado){
       this.identificacion = identificacion;
       this.ocupado = ocupado; 
    }

    public int getNumeroModulo() {
        return numeroModulo;
    }

    public void setNumeroModulo(int numeroModulo) {
        this.numeroModulo = numeroModulo;
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
