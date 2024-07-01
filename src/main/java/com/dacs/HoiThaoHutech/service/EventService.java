package com.dacs.HoiThaoHutech.service;


import com.dacs.HoiThaoHutech.models.Event;
import com.dacs.HoiThaoHutech.models.Status;
import com.dacs.HoiThaoHutech.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    public List<Event> getEventsByStatus(Status status) {
        return eventRepository.findByStatus(status);
    }
    public Event findById(Integer idEvent) {
        return this.eventRepository.findById(idEvent).get();
    }
    //add event
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
    //update event
    public Event updateEvent(Integer id, Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setEventName(eventDetails.getEventName());
            existingEvent.setTimeStart(eventDetails.getTimeStart());
            existingEvent.setTimeEnd(eventDetails.getTimeEnd());
            existingEvent.setNumberSport(eventDetails.getNumberSport());
            existingEvent.setStatus(eventDetails.getStatus());
            existingEvent.setListSport(eventDetails.getListSport());
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id " + id);
        }
    }
    //xoa event
    public void deleteEvent(Integer id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new RuntimeException("Event not found with id " + id);
        }
    }
    public List<Event> searchEventsByKeyword(String keyword) {
        return eventRepository.findByEventNameContainingIgnoreCase(keyword);
    }

}
