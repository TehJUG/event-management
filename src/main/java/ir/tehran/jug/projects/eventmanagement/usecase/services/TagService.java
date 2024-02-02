package ir.tehran.jug.projects.eventmanagement.usecase.services;

import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;

public interface TagService extends BaseService<Tag,Long> {
    Tag findByTagTitle(String tagTitle);
}
