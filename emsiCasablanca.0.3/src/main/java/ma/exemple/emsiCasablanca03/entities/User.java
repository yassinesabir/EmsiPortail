package ma.exemple.emsiCasablanca03.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    private String nom;
    private String prenom;
    private String numeroTelephone;
    @Column(unique = true)
    private String adresseMail;
    private String motDePasse;
    private Role role;
}
