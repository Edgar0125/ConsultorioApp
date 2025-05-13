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
    @Query("SELECT COUNT(c) FROM Cita c WHERE c.doctor.id = ?1 AND c.citaHora >= ?2 AND c.citaHora < ?3")
    long countByDoctorAndDate(Long doctorId, LocalDateTime startTime, LocalDateTime endTime);
    //@Query("SELECT COUNT(a) FROM Cita a WHERE a.doctor.id = ?1 AND DATE(a.citaHora) = ?2")
    //@Query("SELECT COUNT(c) FROM Cita c WHERE c.doctor.id = ?1 AND c.citaHora >= ?2 AND c.citaHora < ?3")
    //long countByDoctorAndDate(Long id, LocalDateTime localDate);
    //long countByDoctorAndDate(Long doctorId, LocalDateTime startOfDay, LocalDateTime endOfDay);
    //long countByDoctorAndDate(Long doctorId, LocalDate date);
    void registrarCita(String cita);

    void validateAndSave(Cita cita);


    //void validateAndSave(Cita cita);

    //long countByDoctorAndDate(Long doctorId, LocalDate date);
}
