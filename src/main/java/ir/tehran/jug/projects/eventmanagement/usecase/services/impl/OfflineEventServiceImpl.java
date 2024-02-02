package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;


import ir.tehran.jug.projects.eventmanagement.data.entities.events.OfflineEvent;
import ir.tehran.jug.projects.eventmanagement.data.repositories.OfflineEventRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.OfflineEventService;

public class OfflineEventServiceImpl extends BaseServiceImpl<OfflineEvent, Long, OfflineEventRepository> implements OfflineEventService{
    public OfflineEventServiceImpl(OfflineEventRepository repository) {
        super(repository);
    }
}
