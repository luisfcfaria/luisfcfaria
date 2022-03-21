package academy.mindswap.lms.persistence.repositories;

import academy.mindswap.lms.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByName(String name);
}
