package ir.tehran.jug.projects.eventmanagement.data.repositories;

import ir.tehran.jug.projects.eventmanagement.data.entities.Organizer;

import java.util.Optional;

public interface OrganizerRepository extends BaseRepository<Organizer, Long>{
    Optional<Organizer> findByName(String name);
}