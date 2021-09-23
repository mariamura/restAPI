package repository;

import model.Event;

import java.util.List;

public interface EventRepository {

    Event save(Event event);

    Event getById(Integer id);

    void deleteById(Integer id);

    List<Event> getAll();

    Event update(Event event);
}
