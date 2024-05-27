package ma.exemple.emsiCasablanca03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@Builder
public class UserRole {
    @Id
    @Column(nullable = false, updatable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<EmsiUser> users = new HashSet<>();
}
