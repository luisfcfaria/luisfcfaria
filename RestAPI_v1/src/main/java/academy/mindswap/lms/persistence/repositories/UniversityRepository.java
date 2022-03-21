package academy.mindswap.lms.persistence.repositories;

import academy.mindswap.lms.commands.UniversityDto;
import academy.mindswap.lms.persistence.models.University;
import academy.mindswap.lms.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, String> {

}
