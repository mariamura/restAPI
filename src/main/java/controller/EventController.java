package controller;

import model.Event;
import service.EventService;

import java.util.List;

public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public List<Event> getAll(){
        return eventService.getAll();
    }

    public Event getById(Integer id){
        return eventService.getById(id);
    }

    public Event save(Event event){
        return eventService.save(event);
    }

    public Event update(Event event){
        return eventService.update(event);
    }

    public void deleteById(Integer id){
        eventService.deleteById(id);
    }

}
