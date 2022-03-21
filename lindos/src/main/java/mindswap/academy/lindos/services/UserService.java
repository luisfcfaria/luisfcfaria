package mindswap.academy.lindos.services;

import mindswap.academy.lindos.persistance.model.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    public static List<User> users = new ArrayList<>();

    public static void addUsers() {
        users.add(User.builder().Id(1).name("luis").email("luis@mail.com").build());
        users.add(User.builder().Id(2).name("maria").email("maria@mail.com").build());
        users.add(User.builder().Id(3).name("joao").email("joao@mail.com").build());
        users.add(User.builder().Id(4).name("antonio").email("antonio@mail.com").build());
    }


    public List<User> allUsers(){
        return users;
    }

    public User getUserById(Integer id) {
        Optional<User> opt = users.stream()
                .filter(i -> Objects.equals(i.getId(), id))
                .findAny();

        return opt.orElse(User.builder().name("I don't exist motherfucker! ").build());
    }

    public User getUserByName(String name) {
        Optional<User> opt = users.stream()
                .filter(i -> Objects.equals(i.getName(), name))
                .findAny();

        return opt.orElse(User.builder().name("I don't exist motherfucker! ").build());
    }

//
//    @GetMapping("/search")
//    public User search(@RequestParam(value = "name", defaultValue = "world") String name,
//                       @RequestParam(value = "lastName" , defaultValue = "World") String lastname,
//                       @RequestParam(value = "email" , defaultValue = "mail@mail") String email){
//        return User.builder()
//                .name(name)
//                .email(email)
//                .name(name.concat(lastname))
//                .build();
//    }
}
