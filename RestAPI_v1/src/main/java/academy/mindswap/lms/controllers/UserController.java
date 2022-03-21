package academy.mindswap.lms.controllers;

import academy.mindswap.lms.commands.UserDto;
import academy.mindswap.lms.persistence.models.User;
import academy.mindswap.lms.services.GitHubLookupService;
import academy.mindswap.lms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GitHubLookupService gitHubLookupService;



  /*  public UserController(UserService userService) {
        this.userService = userService;
    }*/


    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        Optional<UserDto> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUserDto = userService.save(userDto);
        if (createdUserDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public List<UserDto> getUserByName(@RequestParam(value = "name", defaultValue = "World") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/find")
    public List<UserDto> getUserByNameIWant(@RequestParam(value = "name", defaultValue = "World") String name) {
        return userService.getUserByOther(name);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/github/{githubId}")
    public User getGitHubUser(@PathVariable String githubId) throws ExecutionException, InterruptedException {
        System.out.println("before Github Id: " + githubId);
        CompletableFuture<User> user = gitHubLookupService.findUser(githubId);
        System.out.println("after Github Id: " + githubId);
        User userGit = user.get();
        System.out.println("end Github Id: " + githubId);
        return userGit;
        // return  gitHubLookupService.findUser(githubId);
    }

    @GetMapping("/user/github/testing")
    public List<User> getGitHubTesting() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait for the lookups to complete
        CompletableFuture.allOf(page1, page2, page3).join();

        System.out.println(("Elapsed Time: " + (System.currentTimeMillis() - start)));


        List<User> users = List.of(page1.get(), page2.get(), page3.get());

        return users;
        // return  gitHubLookupService.findUser(githubId);
    }

}