package ma.exemple.emsiCasablanca03.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Students")

public class Student extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sector;
    private String group;
    private String level;
}
