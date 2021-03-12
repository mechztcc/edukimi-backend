package com.edukimi.api.services;

import java.util.List;

import com.edukimi.api.domain.Event;
import com.edukimi.api.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    EventRepository eventRepository;

    public List<Event> findAll() {
        List<Event> obj = eventRepository.findAll();
        return obj;
    }
}
