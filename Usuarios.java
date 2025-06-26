package ProyectoFinalFase1;

public class Usuarios {

    private String nombreUsuario;
    private String contrasena;
    private boolean estaBloqueado;
    private int intentosRestantes;

    public Usuarios( String nombreUsuario, String contrasena){
        this.nombreUsuario=nombreUsuario;
        this.contrasena=contrasena;
        this.estaBloqueado=false;
        this.intentosRestantes=3;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena.length() < 6) {
            System.out.println("La contraseña debe tener al menos 6 caracteres.");
        } else {
            this.contrasena = contrasena;
        }
    }
    public boolean isEstaBloqueado() {
        return estaBloqueado;
    }

    public void setEstaBloqueado(boolean estaBloqueado) {
        this.estaBloqueado = estaBloqueado;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public void setIntentosRestantes(int intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    public  void restarIntento (){
        if (intentosRestantes>0){
            intentosRestantes--;
            if (intentosRestantes ==0){
                estaBloqueado=true;
            }
        }
    }
    public void desbloquearUsuarios (String nuevaContrasena){
        this.estaBloqueado=false;
        this.intentosRestantes=3;
        this.contrasena=nuevaContrasena;
    }
    @Override
    public String toString (){
        return  "Usuario: " + nombreUsuario + " | Estado: " + (estaBloqueado ? "Bloqueado " : "Activo");

    }
}
