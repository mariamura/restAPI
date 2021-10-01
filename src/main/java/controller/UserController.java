package controller;

import model.User;
import service.UserService;


import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAll(){
        return userService.getAll();
    }

    public User getById(Integer id){
        return userService.getById(id);
    }

    public User save(User user){
        return userService.save(user);
    }

    public User update(User user){
        return userService.update(user);
    }

    public void deleteById(Integer id){
        userService.deleteById(id);
    }


}
