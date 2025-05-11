package mx.com.gm.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import mx.com.gm.model.Consultorio;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
/*
    @Override
    public List<Consultorio> findAll() {
        return List.of();
    }

    @Override
    public List<Consultorio> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Consultorio> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Consultorio> findAllById(Iterable<Long> longs) {
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
    public void delete(Consultorio entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Consultorio> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Consultorio> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Consultorio> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Consultorio> findById(Long aLong) {
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
    public <S extends Consultorio> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Consultorio> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Consultorio> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    *//**
     * @param aLong
     * @deprecated
     *//*
    @Override
    public Consultorio getOne(Long aLong) {
        return null;
    }

    *//**
     * @param aLong
     * @deprecated
     *//*
    @Override
    public Consultorio getById(Long aLong) {
        return null;
    }

    @Override
    public Consultorio getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Consultorio> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Consultorio> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Consultorio> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Consultorio> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Consultorio> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Consultorio> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Consultorio, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }*/
}
