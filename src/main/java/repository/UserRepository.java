package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User getById(Integer id);

    void deleteById(Integer id);

    List<User> getAll();

    User update(User user);
}
