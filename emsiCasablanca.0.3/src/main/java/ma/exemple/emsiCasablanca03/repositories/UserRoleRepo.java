package ma.exemple.emsiCasablanca03.repositories;

import ma.exemple.emsiCasablanca03.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
