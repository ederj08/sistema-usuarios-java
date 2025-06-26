package ProyectoFinalFase1;

import java.util.Scanner;

public class SistemaUsuarios {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorUsuario gestor = new GestorUsuario();

        int opcion;

        do {
            System.out.println("\n --- Menú del sistema de Usuarios---");
            System.out.println("1.Registrar Usuario.");
            System.out.println("2.Iniciar Sesión.");
            System.out.println("3.Recuperar Cuenta.");
            System.out.println("4.Ver Usuarios.");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre de usuario: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese la longitud de la contraseña: ");
                    int longitud = scanner.nextInt();
                    if (longitud < 6) {
                        System.out.println("La longitud mínima recomendada es de 6 digitos. se asignará longitud de 6 por defecto");
                        longitud = 6;
                    }
                    System.out.println("Escoge un nivel de complejidad (1= Bajo,2=medio,3=Alto) ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine();

                    String contrasena = GeneradorContrasena.generarContrasena(longitud, nivel);
                    if (gestor.agregarUsuario(nombre, contrasena)) {
                        System.out.println("Usuario registrado exitosamente.");
                        System.out.println("Contraseña: " + contrasena);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese nombre de usuario: ");
                    String userLogin = scanner.nextLine();
                    System.out.println("Ingrese la contraseña: ");
                    String passLogin = scanner.nextLine();

                    boolean acceso = gestor.login(userLogin, passLogin);
                    if (acceso) {
                        System.out.println("¡Inicio de Sesión exitoso!");
                    } else {
                        System.out.println("Error en inicio de Sesión");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese nombre de usuario bloqueado: ");
                    String userRecuperar = scanner.nextLine();
                    String nuevaPass;
                    do {
                        System.out.println("Ingrese nueva contraseña (mínimo 6 caracteres):");
                        nuevaPass = scanner.nextLine();

                        if (nuevaPass.length() < 6) {
                            System.out.println("La constraseña es demasiado corta, intente neuvamente");
                        }
                    }
                        while (nuevaPass.length() < 6) ;
                        gestor.recuperarCuenta(userRecuperar, nuevaPass);
                        break;

                        case 4:
                            System.out.println("\n--- Lista de Usuarios ---");
                            gestor.imprimirUsuarios();
                            break;

                        case 5:
                            System.out.println("Saliendo del sistema....");
                            break;

                        default:
                            System.out.println("Opción inválida");
                    }

        }while (opcion!=5);
        scanner.close();

        }
    }

