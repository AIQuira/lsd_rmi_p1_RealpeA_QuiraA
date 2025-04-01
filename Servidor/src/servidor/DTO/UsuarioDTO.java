package servidor.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable
{	
    private int ID;
    private String nombres;
    private String apellidos;

    public UsuarioDTO(int id, String nombres, String apellidos)
    {
            this.ID = id;
            this.nombres = nombres;
            this.apellidos = apellidos; 
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
       
}
