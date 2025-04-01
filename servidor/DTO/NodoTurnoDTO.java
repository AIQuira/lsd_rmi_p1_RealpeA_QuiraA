package servidor.DTO;

public class NodoTurnoDTO {
    private int numeroTurno;
    private int CantidadUsuariosFilaVirtual;
    private String identificacion;

    public int getNumeroTurno() {
        return numeroTurno;
    }
    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
    public int getCantidadUsuariosFilaVirtual() {
        return CantidadUsuariosFilaVirtual;
    }
    public void setCantidadUsuariosFilaVirtual(int cantidadUsuariosFilaVirtual) {
        CantidadUsuariosFilaVirtual = cantidadUsuariosFilaVirtual;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
