package service;

import model.Event;
import model.User;
import repository.Impl.EventRepositoryImpl;
import repository.Impl.UserRepositoryImpl;

import java.util.List;

public class UserService {

    private final UserRepositoryImpl userRepository;

    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public User getById(Integer id){
        return userRepository.getById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        return userRepository.update(user);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }
}
