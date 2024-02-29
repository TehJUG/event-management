package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;


import ir.tehran.jug.projects.eventmanagement.data.entities.BaseEntity;
import ir.tehran.jug.projects.eventmanagement.data.repositories.BaseRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>,
        ID extends Serializable,
        R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        if (existsById(e.getId()))
            throw new DuplicateKeyException("This entity already exist");

        else
            return repository.save(e);
    }


    @Override
    public E update(E e) {
        if (repository.existsById(e.getId())) {
            save(e);
            return e;
        }
        throw new EntityNotFoundException("Entity does not exist");
    }

    @Override
    public void delete(E e) {
        repository.delete(e);
    }

    @Override
    public E findById(ID id) {
        Optional<E> e;
        e = repository.findById(id);
        if (e.isEmpty())
            throw new EntityNotFoundException("Entity does not exist");
        return e.get();
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(ID id) {
        if (existsById(id)) {
            repository.deleteById(id);
        }
        throw new EntityNotFoundException("Entity does not exist");
    }
}
