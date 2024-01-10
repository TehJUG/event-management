package ir.tehran.jug.projects.eventmanagement.data.repositories;

import ir.tehran.jug.projects.eventmanagement.data.base.repository.BaseRepository;
import ir.tehran.jug.projects.eventmanagement.data.entities.Category;
import ir.tehran.jug.projects.eventmanagement.data.entities.events.OnlineEvent;

public interface OnlineEventRepository extends BaseRepository<OnlineEvent, Long> {
    OnlineEvent findByTitle(String onlineEventTitle);

}
