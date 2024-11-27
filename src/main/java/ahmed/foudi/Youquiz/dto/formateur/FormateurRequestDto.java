package ahmed.foudi.Youquiz.dto.formateur;

import ahmed.foudi.Youquiz.dto.user.UserRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormateurRequestDto extends UserRequestDto {
    private String specialite;
} 