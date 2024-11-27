package ahmed.foudi.Youquiz.dto.quizquestion;

import ahmed.foudi.Youquiz.dto.quiz.QuizEmbeddedDto;
import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import lombok.Data;
import java.time.Duration;

@Data
public class QuizQuestionResponseDto {
    private QuizEmbeddedDto quiz;
    private QuestionEmbeddedDto question;
    private Duration timer;
} 