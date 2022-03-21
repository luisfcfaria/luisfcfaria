package academy.mindswap.lms.controllers;


import academy.mindswap.lms.persistence.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String sayHello() {
        return "Hi from user controllers";
    }

    @GetMapping("/user")
    public User getUser() {
        return User.builder()
                .name("eu")
                .build();
    }

    @GetMapping ("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return User.builder()
                .Id(id)
                .email("J@google.com")
                .name("fofo")
                .build();
    }


}
