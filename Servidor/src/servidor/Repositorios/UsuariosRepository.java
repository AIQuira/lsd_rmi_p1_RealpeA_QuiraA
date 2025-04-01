package servidor.Repositorios;

import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.UsuarioDTO;

/*
Clase que implementa la interface remota GestorUsuariosInt
*/

public class UsuariosRepository implements UsuariosRepositoryInt
{  
    private final ArrayList<UsuarioDTO> misUsuarios;

    public UsuariosRepository()
    {        
        this.misUsuarios = new ArrayList();
    }

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuario)
    {
        System.out.println("Entrando a registrar usuario");
        boolean bandera=false;
        
        if(misUsuarios.size() < 5)
        {            
            bandera=misUsuarios.add(objUsuario);
            System.out.println("Usuario registrado: identificación: " + objUsuario.getID() + ", nombres: " + objUsuario.getNombres() + ", apellidos. " +objUsuario.getApellidos() );
        }
        
        return bandera;
    }
    
    
    @Override
    public int consultarCantidadUsuarios()
    {
        System.out.println("Entrando a Cantidad");
        return misUsuarios.size();
    }

    
    @Override
    public UsuarioDTO consultarUsuario(int identificacion)
    {
        UsuarioDTO objUsuario=null;
        
        for (int i = 0; i < this.misUsuarios.size(); i++) {
            if(this.misUsuarios.get(i).getID()==identificacion)
            {
                objUsuario=this.misUsuarios.get(i);
                break;
            }
        }
        return objUsuario;    
    }
       
}
