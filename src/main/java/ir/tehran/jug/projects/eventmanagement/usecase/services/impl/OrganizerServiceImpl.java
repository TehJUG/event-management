package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;

import ir.tehran.jug.projects.eventmanagement.data.entities.Organizer;
import ir.tehran.jug.projects.eventmanagement.data.repositories.OrganizerRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.OrganizerService;

import java.util.Optional;

public class OrganizerServiceImpl extends BaseServiceImpl<Organizer, Long, OrganizerRepository> implements OrganizerService {
    public OrganizerServiceImpl(OrganizerRepository repository) {
        super(repository);
    }

    public Optional<Organizer> findByOrganizerName(String organizerName) {
        return repository.findByName(organizerName);
    }

    @Override
    public Organizer addOrGetOrganizer(Organizer organizer) {
        if (existsById(organizer.getId())) {
            return findById(organizer.getId());
        } else {
            save(organizer);
            return organizer;
        }
    }
}