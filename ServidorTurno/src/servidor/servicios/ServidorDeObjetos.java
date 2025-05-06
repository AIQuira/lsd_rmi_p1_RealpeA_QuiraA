package servidor.servicios;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import servidor.DTO.ModuloDTO;
import servidor.Repositorios.GenerarTurnoRepositoryImpl;
import servidor.controladores.ControladorDisplayInt;
import servidor.controladores.ControladorGeneradorTurnoImpl;
import servidor.controladores.ControladorRegistroReferenciaModulosImpl;
import servidor.utilidades.UtilidadesConsola;
import servidor.utilidades.UtilidadesRegistroC;
import servidor.utilidades.UtilidadesRegistroS;
import servidor.controladores.ControladorAdministradorModuloImpl;


public class ServidorDeObjetos {

    public static void main(String args[]) throws RemoteException {

        int numPuertoRMIRegistryServidorTurnos = 0;
        String direccionIpRMIRegistryServidorTurnos = "";
        
        int numPuertoRMIRegistryServidorDisplay = 0;
        String direccionIpRMIRegistryServidorDisplay = "";

        System.out.println("Cual es el la direccion ip donde se encuentra  el rmiRegistry del servidor de turno");
        direccionIpRMIRegistryServidorTurnos = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry del servidor de turno");
        numPuertoRMIRegistryServidorTurnos = UtilidadesConsola.leerEntero();

        System.out.println("Cual es el la direccion ip donde se encuentra  el rmiRegistry del servidor display");
        direccionIpRMIRegistryServidorDisplay = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry del servidor display");
        numPuertoRMIRegistryServidorDisplay = UtilidadesConsola.leerEntero();

        ControladorDisplayInt objRemotoDisplay = (ControladorDisplayInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistryServidorDisplay,
                numPuertoRMIRegistryServidorDisplay,
                "controladorDisplay");
        
        ControladorRegistroReferenciaModulosImpl objRemotoRegistroRefModulos = new ControladorRegistroReferenciaModulosImpl();
        GenerarTurnoRepositoryImpl objRepositorio = new GenerarTurnoRepositoryImpl(objRemotoDisplay, objRemotoRegistroRefModulos);
        ControladorGeneradorTurnoImpl objRemoto = new ControladorGeneradorTurnoImpl(objRepositorio);
        
        //Listado de modulos
        List<ModuloDTO> listaModulos = new ArrayList<>();
        for (int i = 1; i <= 3; i++){
            ModuloDTO modulo = new ModuloDTO();
            modulo.setNumeroModulo(i);
            modulo.setOcupado(false);
            modulo.setNumeroTurno(0);
            modulo.setIdentificacion("modulo"+i);
            listaModulos.add(modulo);
        }
        ControladorAdministradorModuloImpl objAdministradorModulo = new ControladorAdministradorModuloImpl(listaModulos);
        
        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryServidorTurnos);
            UtilidadesRegistroS.RegistrarObjetoRemoto(
                    objRemoto,
                    direccionIpRMIRegistryServidorTurnos,
                    numPuertoRMIRegistryServidorTurnos,
                    "controladorGeneradorTurno");
            
            UtilidadesRegistroS.RegistrarObjetoRemoto(
                    objRemotoRegistroRefModulos,
                    direccionIpRMIRegistryServidorTurnos,
                    numPuertoRMIRegistryServidorTurnos,
                    "controladorRegistroReferenciaModulos");
            
            UtilidadesRegistroS.RegistrarObjetoRemoto(
                    objAdministradorModulo,
                    direccionIpRMIRegistryServidorTurnos,
                    numPuertoRMIRegistryServidorTurnos,
                    "controladorAdministradorModulos");
        } catch (RemoteException e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }
}
