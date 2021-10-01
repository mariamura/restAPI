package service;

import model.Event;
import repository.Impl.EventRepositoryImpl;

import java.util.List;

public class EventService {

    private final EventRepositoryImpl eventRepository;

    public EventService(EventRepositoryImpl eventRepository) {
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

}
