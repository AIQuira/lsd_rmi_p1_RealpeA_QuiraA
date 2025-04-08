/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.DTO;

import servidor.DTO.ModuloDTO;
import java.io.Serializable;

/**
 *
 * @author FIET-PIS
 */

public class NotificacionDTO {
    private ModuloDTO vectorModulos[];
    private int cantidadUsuarioVirtual;
    
    public NotificacionDTO(){}

    public int getCantidadUsuarioVirtual() {
        return cantidadUsuarioVirtual;
    }

    public void setCantidadUsuarioVirtual(int cantidadUsuarioVirtual) {
        this.cantidadUsuarioVirtual = cantidadUsuarioVirtual;
    }

    public ModuloDTO[] getVectorModulos() {
        return vectorModulos;
    }

    public void setVectorModulos(ModuloDTO[] vectorModulos) {
        this.vectorModulos = vectorModulos;
    }
    
    
}
