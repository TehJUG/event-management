package ir.tehran.jug.projects.eventmanagement.data.repositories;

import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;

public interface TagRepository extends BaseRepository<Tag, Long> {
    Tag findByTitle(String tagTitle);
}
