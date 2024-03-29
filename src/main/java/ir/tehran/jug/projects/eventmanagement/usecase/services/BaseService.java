package ir.tehran.jug.projects.eventmanagement.usecase.services;

import ir.tehran.jug.projects.eventmanagement.data.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    E update(E e);

    void delete(E e);

    E findById(ID id);

    List<E> findAll();

    boolean existsById(ID id);

    void deleteById(ID id);
}
