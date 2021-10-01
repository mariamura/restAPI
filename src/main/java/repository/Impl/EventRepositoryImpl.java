package repository.Impl;

import model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.EventRepository;
import utils.HibernateUtils;

import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    @Override
    public Event save(Event event) {
        Session session = HibernateUtils.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(event);
        transaction.commit();
        session.close();
        return event;
    }

    @Override
    public Event getById(Integer id) {
        Session session = HibernateUtils.getSession().openSession();
        Event event = session.get(Event.class, id);
        session.close();
        return event;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = HibernateUtils.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        Event event = session.get(Event.class, id);
        session.delete(event);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Event> getAll() {
        Session session = HibernateUtils.getSession().openSession();
        List<Event> events = session.createQuery("FROM Events").list();
        session.close();
        return events;
    }

    @Override
    public Event update(Event event) {
        Session session = HibernateUtils.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        Event eventToUpdate = session.get(Event.class, event.getId());
        eventToUpdate.setDate(event.getDate());

        session.update(eventToUpdate);
        transaction.commit();
        session.close();
        return eventToUpdate;
    }
}
