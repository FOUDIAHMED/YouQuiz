package ahmed.foudi.Youquiz.dto.student;

import ahmed.foudi.Youquiz.dto.user.UserRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentRequestDto extends UserRequestDto {
    private LocalDate registrationDate;
} 