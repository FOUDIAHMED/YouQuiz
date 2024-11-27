package ahmed.foudi.Youquiz.dto.quizassignment;

import lombok.Data;
import java.time.LocalDate;

@Data
public class QuizAssignmentRequestDto {
    private Long studentId;
    private Long quizId;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private int attempts;
} 