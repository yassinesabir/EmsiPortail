package ma.exemple.emsiCasablanca03.repositories;

import ma.exemple.emsiCasablanca03.entities.EmsiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmsiUserRepo extends JpaRepository<EmsiUser, Long> {
    EmsiUser findByUsername(String username);
}