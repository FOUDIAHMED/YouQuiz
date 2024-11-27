package ahmed.foudi.Youquiz.dto.quizquestion;

import lombok.Data;
import java.time.Duration;

@Data
public class QuizQuestionRequestDto {
    private Long quizId;
    private Long questionId;
    private Duration timer;
} 