package ir.tehran.jug.projects.eventmanagement.data.repositories;

import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;

import java.util.Optional;

public interface TagRepository extends BaseRepository<Tag, Long> {
    Optional<Tag> findByTitle(String title);

}
