package ahmed.foudi.Youquiz.dto.quiz;

import ahmed.foudi.Youquiz.dto.formateur.FormateurEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;
import lombok.Data;
import java.time.Duration;
import java.util.List;

@Data
public class QuizResponseDto {
    private Long id;
    private String title;
    private String description;
    private Duration duration;
    private double score;
    private boolean canSeeAnswers;
    private boolean canSeeResult;
    private FormateurEmbeddedDto formateur;
    private List<QuizQuestionResponseDto> quizQuestions;
} 