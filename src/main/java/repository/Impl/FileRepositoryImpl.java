package repository.Impl;

import model.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.FileRepository;

import java.util.List;

public class FileRepositoryImpl implements FileRepository {

    private static SessionFactory sessionFactory;

    public FileRepositoryImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public File save(File file) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(file);
        transaction.commit();
        session.close();
        return file;
    }

    @Override
    public File getById(Integer id) {
        Session session = sessionFactory.openSession();
        File file = session.get(File.class, id);
        session.close();
        return file;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        File file = session.get(File.class, id);
        session.delete(file);
        transaction.commit();
        session.close();
    }

    @Override
    public List<File> getAll() {
        Session session = sessionFactory.openSession();
        List<File> files = session.createQuery("FROM Files").list();
        session.close();
        return files;
    }

    @Override
    public File update(File file) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        File file1 = session.get(File.class, file.getId());
        file1.setName(file.getName());

        session.update(file1);
        transaction.commit();
        session.close();
        return file1;
    }
}
