package mx.com.gm.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import mx.com.gm.model.Cita;
import mx.com.gm.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CitaServiceImpl implements CitaRepository {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> findByDoctorIdAndAppointmentTimeBetween(Long doctorId, LocalDateTime start, LocalDateTime end) {
        return List.of();
    }

    @Override
    public List<Cita> findByConsultingRoomIdAndAppointmentTimeBetween(Long roomId, LocalDateTime start, LocalDateTime end) {
        return List.of();
    }

    @Override
    public List<Cita> findByPatientNameAndAppointmentTimeBetween(String patientName, LocalDateTime start, LocalDateTime end) {
        return List.of();
    }

    @Override
    public List<Cita> findByAppointmentTimeBetween(LocalDateTime start, LocalDateTime end) {
        return List.of();
    }

    @Override
    public long countByDoctorAndDate(Long doctorId, LocalDateTime startTime, LocalDateTime endTime) {
        return 0;
    }


    @Override
    public void registrarCita(String cita) {

    }

    @Override
    public void validateAndSave(Cita cita) {
// Rule 1: No same consultorio at same time
        List<Cita> roomConflicts = citaRepository.findByConsultingRoomIdAndAppointmentTimeBetween(
                cita.getConsultorio().getId(),
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
                cita.getCitaHora(),
                cita.getCitaHora().plusHours(1)
        );
        if (dailyAppointments >= 8) {
            throw new IllegalArgumentException("El paciente ya tiene cita dentro de 2 horas.");
        }

        citaRepository.save(cita);
    }

    public List<Cita> findByDoctorAndDate(Long doctorId, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return citaRepository.findByDoctorIdAndAppointmentTimeBetween(doctorId, start, end);
    }

    public List<Cita> findByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return citaRepository.findByAppointmentTimeBetween(start, end);
    }


    public List<Cita> findByConsultingRoomAndDate(Long roomId, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return citaRepository.findByConsultingRoomIdAndAppointmentTimeBetween(roomId, start, end);
    }


    @Override
    public List<Cita> findAll() {
        return List.of();
    }

    @Override
    public List<Cita> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Cita> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Cita> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Cita entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cita> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Cita> S save(S cita) {
// Rule 1: No same consultorio at same time
        List<Cita> roomConflicts = citaRepository.findByConsultingRoomIdAndAppointmentTimeBetween(
                cita.getConsultorio().getId(),
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
                cita.getCitaHora(),
                cita.getCitaHora().plusHours(1)
        );
        if (dailyAppointments >= 8) {
            throw new IllegalArgumentException("El paciente ya tiene cita dentro de 2 horas.");
        }

        citaRepository.save(cita);
        return cita;
    }


    @Override
    public <S extends Cita> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Cita> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Cita> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Cita> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Cita> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    /**
     * @param aLong
     * @deprecated
     */
    @Override
    public Cita getOne(Long aLong) {
        return null;
    }

    /**
     * @param aLong
     * @deprecated
     */
    @Override
    public Cita getById(Long aLong) {
        return null;
    }

    @Override
    public Cita getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Cita> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cita> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Cita> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Cita> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cita> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cita> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Cita, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
