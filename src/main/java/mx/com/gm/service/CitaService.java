package mx.com.gm.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import mx.com.gm.model.Cita;
import mx.com.gm.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CitaService extends   CitaRepository{
    void registrarCita(String cita);
    void validateAndSave(Cita cita);
    //void validateAndSave(Cita cita);
/*    @Autowired
    private CitaRepository citaRepository;

    public void validateAndSave(Cita cita) throws IllegalArgumentException {
        // Rule 1: No same consultorio at same time
        List<Cita> roomConflicts = citaRepository.findByConsultingRoomIdAndAppointmentTimeBetween(
                Long.valueOf(cita.getConsultorio().getId()),
                cita.getCitaHora(),
                cita.getCitaHora().plusHours(1)
        );
        if (!roomConflicts.isEmpty()) {
            throw new IllegalArgumentException("La sala de consulta ya está reservada en este momento.");
        }

        // Rule 2: No same doctor at same time
        List<Cita> doctorConflicts = citaRepository.findByDoctorIdAndAppointmentTimeBetween(
                cita.getDoctor().getId(),
                cita.getCitaHora(),
                cita.getCitaHora().plusHours(1)
        );
        if (!doctorConflicts.isEmpty()) {
            throw new IllegalArgumentException("El médico ya tiene cita en este momento.");
        }

        // Rule 3: Patient can't have appointments within 2 hours
        List<Cita> patientConflicts = citaRepository.findByPatientNameAndAppointmentTimeBetween(
                cita.getNombrePaciente(),
                cita.getCitaHora().minusHours(2),
                cita.getCitaHora().plusHours(2)
        );
        if (!patientConflicts.isEmpty()) {
            throw new IllegalArgumentException("El paciente ya tiene cita dentro de 2 horas.");
        }

        // Rule 4: Doctor can't have more than 8 appointments per day
        long dailyAppointments = citaRepository.countByDoctorAndDate(
                cita.getDoctor().getId(),
                cita.getCitaHora().toLocalDate()
        );
        if (dailyAppointments >= 8) {
            throw new IllegalArgumentException("El paciente ya tiene cita dentro de 2 horas.");
        }

        citaRepository.save(cita);
    }

    public List<Cita> findByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return citaRepository.findByAppointmentTimeBetween(start, end);
    }

    public List<Cita> findByDoctorAndDate(Long doctorId, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return citaRepository.findByDoctorIdAndAppointmentTimeBetween(doctorId, start, end);
    }

    public List<Cita> findByConsultingRoomAndDate(Long roomId, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return citaRepository.findByConsultingRoomIdAndAppointmentTimeBetween(roomId, start, end);
    }

    public void cancelAppointment(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontro la cita"));
        if (cita.getCitaHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se pueden cancelar citas pasadas");
        }
        citaRepository.deleteById(id);
    }*/
}
