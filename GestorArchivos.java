package utils;
import modelos.Doctor;
import modelos.Paciente;
import modelos.Cita;
import modelos.Usuario;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* @author saram*/
public class GestorArchivos {
    
    private static final String DB_PATH = "db/";
    private static final String DOCTORES_FILE = DB_PATH + "doctores.csv";
    private static final String PACIENTES_FILE = DB_PATH + "pacientes.csv";
    private static final String CITAS_FILE = DB_PATH + "citas.csv";
    private static final String USUARIOS_FILE = DB_PATH + "usuarios.csv";

    // CREA LOS ARCHIVOS SI NO EXISTEN
    public static void validarArchivos() {
        try {
            Files.createDirectories(Paths.get(DB_PATH));

            crearSiNoExiste(DOCTORES_FILE, "id,nombre,especialidad");
            crearSiNoExiste(PACIENTES_FILE, "id,nombre");
            crearSiNoExiste(CITAS_FILE, "id,fechaHora,motivo,doctorId,pacienteId");
            crearSiNoExiste(USUARIOS_FILE, "id,password,rol");

            // Agregar usuario admin si no existe
            agregarAdminSiNoExiste();

        } catch (IOException e) {
            System.out.println("Error al validar archivos: " + e.getMessage());
        }
    }

    private static void crearSiNoExiste(String ruta, String encabezado) throws IOException {
        Path path = Paths.get(ruta);
        if (!Files.exists(path)) {
            Files.write(path, (encabezado + System.lineSeparator()).getBytes());
        }
    }

    private static void agregarAdminSiNoExiste() {
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("admin,")) {
                    return; // Ya existe
                }
            }
        } catch (IOException ignored) {}

        // Si no existe, lo agregamos
        guardarLinea(USUARIOS_FILE, "admin,1234,admin");
    }

    // GUARDAR REGISTROS
    public static void guardarDoctor(Doctor doctor) {
        guardarLinea(DOCTORES_FILE, doctor.toCSV());
    }

    public static void guardarPaciente(Paciente paciente) {
        guardarLinea(PACIENTES_FILE, paciente.toCSV());
    }

    public static void guardarCita(Cita cita) {
        guardarLinea(CITAS_FILE, cita.toCSV());
    }

    private static void guardarLinea(String archivo, String linea) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar en " + archivo + ": " + e.getMessage());
        }
    }

    // LEER USUARIOS PARA LOGIN
    public static List<Usuario> leerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String linea = br.readLine(); // encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    usuarios.add(new Usuario(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    // LEER DOCTORES
    public static List<Doctor> leerDoctores() {
        List<Doctor> doctores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DOCTORES_FILE))) {
            String linea = br.readLine(); // encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    doctores.add(new Doctor(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer doctores: " + e.getMessage());
        }
        return doctores;
    }

    // LEER PACIENTES
    public static List<Paciente> leerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PACIENTES_FILE))) {
            String linea = br.readLine(); // encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    pacientes.add(new Paciente(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer pacientes: " + e.getMessage());
        }
        return pacientes;
    }

    // LEER CITAS
    public static List<Cita> leerCitas() {
        List<Cita> citas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CITAS_FILE))) {
            String linea = br.readLine(); // encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    Cita c = new Cita(
                            partes[0],
                            LocalDateTime.parse(partes[1]),
                            partes[2],
                            partes[3],
                            partes[4]
                    );
                    citas.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer citas: " + e.getMessage());
        }
        return citas;
    }

}

