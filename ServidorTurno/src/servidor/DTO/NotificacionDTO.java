package servidor.DTO;

import java.io.Serializable;

public class NotificacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private ModuloDTO vectorModulos[];
    private int cantidadUsuariosFilaVirtual;
    
    public NotificacionDTO (){
        
    }

    public ModuloDTO[] getVectorModulos() {
        return vectorModulos;
    }

    public void setVectorModulos(ModuloDTO[] vectorModulos) {
        this.vectorModulos = vectorModulos;
    }

    public int getCantidadUsuariosFilaVirtual() {
        return cantidadUsuariosFilaVirtual;
    }

    public void setCantidadUsuariosFilaVirtual(int cantidadUsuariosFilaVirtual) {
        this.cantidadUsuariosFilaVirtual = cantidadUsuariosFilaVirtual;
    }
    
    
}
