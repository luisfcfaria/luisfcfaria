package mindswap.academy.lindos.controller;

import mindswap.academy.lindos.persistance.model.User;
import mindswap.academy.lindos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "WELCOME!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.allUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable Integer id){
        return userService.getUserById(id);
    }

}
