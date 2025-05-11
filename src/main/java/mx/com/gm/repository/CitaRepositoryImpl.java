package mx.com.gm.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import mx.com.gm.model.Cita;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CitaRepositoryImpl implements CitaRepository {

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
    public long countByDoctorAndDate(Long doctorId, LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return 0;
    }

    @Override
    public void registrarCita(String cita) {
        System.out.println("Se registro"+cita);
    }

    @Override
    public void validateAndSave(Cita cita) {

    }


    @Override
    public long countByDoctorAndDate(Long doctorId, LocalDate date) {
        return 0;
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
    public <S extends Cita> S save(S entity) {
        return null;
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
