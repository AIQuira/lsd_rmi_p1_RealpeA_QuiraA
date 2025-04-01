/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.DTO;

import java.io.Serializable;

public class NodoTurnoDTO implements Serializable {

    private int numeroTurno;
    private int cantidadUsuariosFilaVirtual;
    private String identificacion;

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
