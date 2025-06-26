package ProyectoFinalFase1;

import java.security.SecureRandom;

public class GeneradorContrasena {


    public static String generarContrasena (int longitud, int nivelComplejidad) {
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String simbolos = "!@#$%&*()_-+=<>?/{}[]";

        String caracterespermitidos = "";

        switch (nivelComplejidad){
            case 1:
                caracterespermitidos=minusculas;
                break;
            case 2:
                caracterespermitidos =minusculas + mayusculas + numeros;
                break;
            case 3:
                caracterespermitidos= minusculas + mayusculas+numeros+simbolos;
                break;
            default:
                System.out.println("Nivel de complejidad inválido. Usando nivel 1 por defecto.");
                caracterespermitidos=minusculas;
        }

        SecureRandom random= new SecureRandom();
        StringBuilder contrasena = new StringBuilder();
        for (int i=0; i< longitud; i++){
            int index = random.nextInt(caracterespermitidos.length());
            contrasena.append(caracterespermitidos.charAt(index));
        }
        return  contrasena.toString();
    }
}
