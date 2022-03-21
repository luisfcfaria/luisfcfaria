package mindswap.academy.lindos;

import mindswap.academy.lindos.controller.UserController;
import mindswap.academy.lindos.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LindosApplication {

	public static void main(String[] args) {

		UserService.addUsers();
		SpringApplication.run(LindosApplication.class, args);
	}
}

