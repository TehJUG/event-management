package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;


import ir.tehran.jug.projects.eventmanagement.data.base.entity.BaseEntity;
import ir.tehran.jug.projects.eventmanagement.data.repositories.BaseRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.BaseService;
import jakarta.persistence.EntityNotFoundException;


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
        return repository.save(e);
    }


    @Override
    public E update(E e) {
        return repository.save(e);
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
