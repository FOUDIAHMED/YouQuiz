package ahmed.foudi.Youquiz.dto.student;

import ahmed.foudi.Youquiz.dto.user.UserResponseDto;
import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentEmbeddedDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentResponseDto extends UserResponseDto {
    private LocalDate registrationDate;
    private List<QuizAssignmentEmbeddedDto> quizAssignments;
}