
package modelos;
import java.time.LocalDateTime;


/*@author saram*/
public class Cita {
      private String id;
    private LocalDateTime fechaHora;
    private String motivo;
    private String doctorId;
    private String pacienteId;

    // Constructor principal (LocalDateTime)
    public Cita(String id, LocalDateTime fechaHora, String motivo,
                String doctorId, String pacienteId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctorId = doctorId;
        this.pacienteId = pacienteId;
    }

    // Constructor compatible con tu SistemaCitas
    public Cita(String id, String fecha, String hora, String motivo,
                String idDoctor, String idPaciente) {

        // Convierte "YYYY-MM-DD" + "HH:MM" a LocalDateTime
        this.id = id;
        this.fechaHora = LocalDateTime.parse(fecha + "T" + hora);
        this.motivo = motivo;
        this.doctorId = idDoctor;
        this.pacienteId = idPaciente;
    }

    // Getters
    public String getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    // Convierte la cita a formato CSV
    public String toCSV() {
        return id + "," +
               fechaHora.toString() + "," +
               motivo + "," +
               doctorId + "," +
               pacienteId;
    }

}
