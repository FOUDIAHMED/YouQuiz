package ahmed.foudi.Youquiz.dto.formateur;

import ahmed.foudi.Youquiz.dto.user.UserResponseDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizEmbeddedDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormateurResponseDto extends UserResponseDto {
    private String specialite;
    private List<QuizEmbeddedDto> quizzes;
} 