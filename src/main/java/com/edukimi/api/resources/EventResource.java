package com.edukimi.api.resources;

import java.util.List;

import com.edukimi.api.domain.Event;
import com.edukimi.api.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/event")
public class EventResource {


    @Autowired
    EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> findAll() {
        List<Event> events = eventService.findAll();
        return ResponseEntity.ok(events);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> findById(@PathVariable Integer id) {
        Event event = eventService.findById(id);
        return ResponseEntity.ok(event);
    }
    
}
