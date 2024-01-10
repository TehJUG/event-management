package ir.tehran.jug.projects.eventmanagement.data.repositories;

import ir.tehran.jug.projects.eventmanagement.data.base.repository.BaseRepository;
import ir.tehran.jug.projects.eventmanagement.data.entities.Category;
import ir.tehran.jug.projects.eventmanagement.data.entities.events.OfflineEvent;

public interface OfflineEventRepository extends BaseRepository<OfflineEvent, Long> {
    OfflineEvent findByTitle(String offlineEventTitle);

}
