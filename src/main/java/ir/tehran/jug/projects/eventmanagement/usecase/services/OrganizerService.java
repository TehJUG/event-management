package ir.tehran.jug.projects.eventmanagement.usecase.services;

import ir.tehran.jug.projects.eventmanagement.data.entities.Organizer;

public interface OrganizerService  extends BaseService<Organizer,Long>  {
    Organizer addOrGetOrganizer(Organizer organizer);

}