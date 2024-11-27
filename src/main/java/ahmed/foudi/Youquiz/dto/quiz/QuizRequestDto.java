package ahmed.foudi.Youquiz.dto.quiz;

import lombok.Data;
import java.time.Duration;

@Data
public class QuizRequestDto {
    private String title;
    private String description;
    private Duration duration;
    private double score;
    private boolean canSeeAnswers;
    private boolean canSeeResult;
    private Long formateurId;
} 