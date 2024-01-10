package ir.tehran.jug.projects.eventmanagement.data.base.repository;

import ir.tehran.jug.projects.eventmanagement.data.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<E, ID> {
}
