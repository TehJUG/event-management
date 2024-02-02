package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;

import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;
import ir.tehran.jug.projects.eventmanagement.data.repositories.TagRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, Long, TagRepository> implements TagService {
    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }

    @Override
    public Tag findByTagTitle(String tagTitle) {
        Tag tag = repository.findByTitle(tagTitle);
        if (tag == null)
            throw new EntityNotFoundException("Entity not exist");
        return tag;
    }
}
