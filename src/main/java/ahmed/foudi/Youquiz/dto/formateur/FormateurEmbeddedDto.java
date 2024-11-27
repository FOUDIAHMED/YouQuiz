package ahmed.foudi.Youquiz.dto.formateur;

import ahmed.foudi.Youquiz.dto.user.UserEmbeddedDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormateurEmbeddedDto extends UserEmbeddedDto {
    private String specialite;
} 