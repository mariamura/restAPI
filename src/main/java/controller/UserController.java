package controller;

import model.User;
import repository.Impl.UserRepositoryImpl;


import java.io.IOException;
import java.util.List;

public class UserController {

    private final UserRepositoryImpl userRepository;

    public UserController(UserRepositoryImpl userRepository) throws IOException {
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

    public void printAll() {
        userRepository.getAll().
                stream().
                forEach(n -> System.out.println(n.getId() + ": " + n.getName() + " " + n.getEvents()));
    }
}
