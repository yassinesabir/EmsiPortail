package ma.exemple.emsiCasablanca03.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SectorManagers")

public class SectorManager extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sector;
    private String levelAffiliated;
}
