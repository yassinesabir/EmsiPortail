package ma.exemple.emsiCasablanca03.repositories;

import ma.exemple.emsiCasablanca03.entities.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Files, Long> {

    Files findByName(String name);
}
