package ahmed.foudi.Youquiz.dto.user;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserResponseDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private LocalDate dateNaissance;
} 