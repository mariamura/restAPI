package repository.Impl;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.UserRepository;
import utils.HibernateUtils;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {


    @Override
    public User save(User user) {
        Session session = HibernateUtils.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User getById(Integer id) {
        Session session = HibernateUtils.getSession().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = HibernateUtils.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateUtils.getSession().openSession();
        List<User> users = session.createQuery("from Users").list();
        session.close();
        return users;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtils.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        User user1 = session.get(User.class, user.getId());
        user1.setName(user.getName());
        user1.setEvents(user.getEvents());

        session.update(user1);
        transaction.commit();
        session.close();
        return user1;
    }
}
