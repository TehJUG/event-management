package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;

import ir.tehran.jug.projects.eventmanagement.data.entities.events.OnlineEvent;
import ir.tehran.jug.projects.eventmanagement.data.repositories.OnlineEventRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.OnlineEventService;
import org.springframework.stereotype.Service;

@Service
public class OnlineEventServiceImpl extends BaseServiceImpl<OnlineEvent, Long, OnlineEventRepository> implements OnlineEventService {
    public OnlineEventServiceImpl(OnlineEventRepository repository) {
        super(repository);
    }
}
