
package servidor.Repositorios;

import servidor.DTO.UsuarioDTO;

public interface UsuariosRepositoryInt
{
    
    public boolean registrarUsuario(UsuarioDTO objUsuario);
    public int consultarCantidadUsuarios();
    public UsuarioDTO consultarUsuario(int identificacion);
}


