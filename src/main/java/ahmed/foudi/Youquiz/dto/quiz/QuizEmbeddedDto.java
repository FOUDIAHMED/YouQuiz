package ahmed.foudi.Youquiz.dto.quiz;

import lombok.Data;
import java.time.Duration;

@Data
public class QuizEmbeddedDto {
    private Long id;
    private String title;
    private Duration duration;
    private double score;
} 