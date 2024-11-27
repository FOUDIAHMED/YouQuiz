package ahmed.foudi.Youquiz.dto.quizassignment;

import lombok.Data;
import java.time.LocalDate;

@Data
public class QuizAssignmentEmbeddedDto {
    private Long studentId;
    private Long quizId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double score;
    private double result;
} 