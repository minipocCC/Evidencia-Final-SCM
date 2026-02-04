package modelos;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import modelos.Cita;
import modelos.Doctor;
import modelos.Paciente;
import utils.LectorCSV;

/**
 *
 * @author saram
 */
public class SistemaCitas {
     // ============================
    // MÉTODO: DAR DE ALTA DOCTOR
    // ============================
    public static void crearDoctor() {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== DAR DE ALTA DOCTOR ===");

        System.out.print("ID del doctor: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        Doctor doctor = new Doctor(id, nombre, especialidad);

        try (FileWriter fw = new FileWriter("src/db/doctores.csv", true)) {
            fw.write(doctor.toCSV() + "\n");
            System.out.println("\nDoctor registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el doctor: " + e.getMessage());
        }
    }

    // ============================
    // MÉTODO: DAR DE ALTA PACIENTE
    // ============================
    public static void crearPaciente() {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== DAR DE ALTA PACIENTE ===");

        System.out.print("ID del paciente: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        Paciente paciente = new Paciente(id, nombre);

        try (FileWriter fw = new FileWriter("src/db/pacientes.csv", true)) {
            fw.write(paciente.toCSV() + "\n");
            System.out.println("\nPaciente registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el paciente: " + e.getMessage());
        }
    }

    // ============================
    // MÉTODO: CREAR CITA
    // ============================
    public static void crearCita() {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== CREAR CITA ===");

        System.out.print("ID de la cita: ");
        String id = sc.nextLine();

        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.print("Hora (HH:MM): ");
        String hora = sc.nextLine();

        System.out.print("Motivo: ");
        String motivo = sc.nextLine();

        // Mostrar doctores
        System.out.println("\nDoctores disponibles:");
        List<String[]> doctores = LectorCSV.leerCSV("src/db/doctores.csv");
        for (String[] d : doctores) {
            System.out.println(d[0] + " - " + d[1] + " (" + d[2] + ")");
        }

        System.out.print("ID del doctor: ");
        String idDoctor = sc.nextLine();

        // Mostrar pacientes
        System.out.println("\nPacientes disponibles:");
        List<String[]> pacientes = LectorCSV.leerCSV("src/db/pacientes.csv");
        for (String[] p : pacientes) {
            System.out.println(p[0] + " - " + p[1]);
        }

        System.out.print("ID del paciente: ");
        String idPaciente = sc.nextLine();

        // Crear la cita
        Cita cita = new Cita(id, fecha, hora, motivo, idDoctor, idPaciente);

        // Guardar en CSV
        try (FileWriter fw = new FileWriter("src/db/citas.csv", true)) {
            fw.write(cita.toCSV() + "\n");
            System.out.println("\nCita creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar la cita: " + e.getMessage());
        }
    }

    // ============================
    // MÉTODO: VALIDAR LOGIN
    // ============================
    public static boolean validarUsuario(String user, String pass) {

        List<String[]> listaUsuarios = LectorCSV.leerCSV("src/db/usuarios.csv");

        for (String[] f : listaUsuarios) {
            String usuario = f[1];
            String contrasena = f[2];

            if (usuario.equals(user) && contrasena.equals(pass)) {
                return true;
            }
        }
        return false;
    }

    // ============================
    // MÉTODO: MENÚ PRINCIPAL
    // ============================
    public static void menu() {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> crearDoctor();
                case 2 -> crearPaciente();
                case 3 -> crearCita();
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }

    // ============================
    // MÉTODO MAIN
    // ============================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LOGIN
        boolean acceso = false;

        while (!acceso) {
            System.out.println("=== LOGIN DEL SISTEMA ===");
            System.out.print("Usuario: ");
            String user = sc.nextLine();

            System.out.print("Contraseña: ");
            String pass = sc.nextLine();

            if (validarUsuario(user, pass)) {
                System.out.println("Acceso concedido.\n");
                acceso = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Intente de nuevo.\n");
            }
        }

        // MENÚ PRINCIPAL
        menu();
    }

    }
    

