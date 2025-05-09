package mx.com.gm.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import mx.com.gm.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByDoctorIdAndAppointmentTimeBetween(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<Cita> findByConsultingRoomIdAndAppointmentTimeBetween(Long roomId, LocalDateTime start, LocalDateTime end);
    List<Cita> findByPatientNameAndAppointmentTimeBetween(String patientName, LocalDateTime start, LocalDateTime end);
    List<Cita> findByAppointmentTimeBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT COUNT(a) FROM Cita a WHERE a.doctor.id = ?1 AND DATE(a.horarioPaciente) = ?2")
    long countByDoctorAndDate(Long doctorId, LocalDate date);
}
