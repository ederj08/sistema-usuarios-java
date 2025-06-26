# User Management System in Java

This Java project allows you to manage user accounts with the following features:

- 🔐 Secure registration with generated passwords (low, medium, high complexity)
- 🔓 Login authentication
- 🚫 Automatic account blocking after 3 failed attempts
- 🔄 Password recovery and account reactivation
- 📋 User list display

## How It Works

The system runs on the console and includes:

- `GeneradorContrasena.java`: Generates secure passwords.
- `Usuarios.java`: Represents each user account.
- `GestorUsuario.java`: Manages registration, login, and recovery.
- `SistemaUsuarios.java`: The main application with the user interface.

## How to Run

Make sure you have Java installed. Compile and run `SistemaUsuarios.java` from your IDE or terminal.

```bash
javac SistemaUsuarios.java
java SistemaUsuarios
