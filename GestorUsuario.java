package ProyectoFinalFase1;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {

    private List<Usuarios> listaUsuarios;

    public GestorUsuario () {

        listaUsuarios = new ArrayList<>();
    }
        public boolean agregarUsuario(String nombre, String contrasena){
         if (buscarUsuario(nombre) !=null){
             System.out.println("El usuario ya existe.");
             return false;
         }
        listaUsuarios.add(new Usuarios(nombre, contrasena));
         return  true;
    }
    public Usuarios buscarUsuario(String nombre){
        for (Usuarios u : listaUsuarios){
            if (u.getNombreUsuario().equalsIgnoreCase(nombre)){
                return u;
            }
        }
        return null;
    }

    public void imprimirUsuarios(){
        for (Usuarios u : listaUsuarios){
            System.out.println(u);
        }
    }
    public boolean login (String nombre, String contrasena){
        Usuarios u = buscarUsuario(nombre);
        if (u==null){
            System.out.println("Usuario no encontrado en el sistema");
            return false;
        }
        if (u.isEstaBloqueado()){
            System.out.println("Usuario Bloqueado");
            return false;
        }
        if (u.getContrasena().equalsIgnoreCase(contrasena)){
            u.setIntentosRestantes(3);
            return true;
        }else {
            u.restarIntento();
            System.out.println("Contraseña incorrecta. Intentos restantes: "+ u.getIntentosRestantes());
          return false;
        }
    }

    public void recuperarCuenta(String nombre, String nuevaContrasena){
        Usuarios u = buscarUsuario(nombre);
        if (u != null && u.isEstaBloqueado()){
            u.desbloquearUsuarios(nuevaContrasena);
            System.out.println("Usuario desbloqueado con nueva contraseña");
        }else {
            System.out.println("No se puede recuperar la cuenta: Usuariono está bloqueado o no existe.");
        }
    }
}
