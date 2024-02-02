package ir.tehran.jug.projects.eventmanagement.usecase.services;

import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;

import java.util.Optional;

public interface TagService extends BaseService<Tag, Long> {
    Optional<Tag> findByTagTitle(String tagTitle);
}
