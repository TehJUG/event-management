package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;

import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;
import ir.tehran.jug.projects.eventmanagement.data.repositories.TagRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, Long, TagRepository> implements TagService {
    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Tag> findByTagTitle(String tagTitle) {
        Optional<Tag> tag = repository.findByTitle(tagTitle);
        if (tag.isEmpty())
            throw new EntityNotFoundException("Entity not exist");
        return tag;
    }
}
