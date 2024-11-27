package ahmed.foudi.Youquiz.dto.student;

import ahmed.foudi.Youquiz.dto.user.UserEmbeddedDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentEmbeddedDto extends UserEmbeddedDto {
    private LocalDate registrationDate;
} 