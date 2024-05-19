package ma.exemple.emsiCasablanca03.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Admins")

public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
