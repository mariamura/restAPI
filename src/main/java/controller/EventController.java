package controller;

import model.Event;
import repository.Impl.EventRepositoryImpl;

import java.util.List;

public class EventController {
    private final EventRepositoryImpl eventRepository;

    public EventController(EventRepositoryImpl eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll(){
        return eventRepository.getAll();
    }

    public Event getById(Integer id){
        return eventRepository.getById(id);
    }

    public Event save(Event event){
        return eventRepository.save(event);
    }

    public Event update(Event event){
        return eventRepository.update(event);
    }

    public void deleteById(Integer id){
        eventRepository.deleteById(id);
    }

    public void printAll() {
        eventRepository.getAll().
                stream().
                forEach(n -> System.out.println(n.getId() + ": " + n.getDate() + " " + n.getFile()));
    }
}
