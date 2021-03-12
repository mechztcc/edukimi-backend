package com.edukimi.api.services;

import java.util.List;
import java.util.Optional;

import com.edukimi.api.domain.Event;
import com.edukimi.api.domain.School;
import com.edukimi.api.dto.EventDTO;
import com.edukimi.api.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    EventRepository eventRepository;

    @Autowired
    SchoolService schoolService;

    public List<Event> findAll() {
        List<Event> obj = eventRepository.findAll();
        return obj;
    }

    public Event findById(Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElseThrow(() -> new RuntimeException("Evento não encontrado!"));
    }

    public Event create(Event event) {
        event = eventRepository.save(event);
        return event;
    }

    public Event fromDto(EventDTO eventDto) {
        School school = schoolService.findById(eventDto.getSchoolId());
        Event event = new Event(null, eventDto.getName(), eventDto.getDate(), eventDto.getDescription(), school);
        return event;
    }
}
