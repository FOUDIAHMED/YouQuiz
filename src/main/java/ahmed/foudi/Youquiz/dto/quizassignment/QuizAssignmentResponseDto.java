package ahmed.foudi.Youquiz.dto.quizassignment;

import ahmed.foudi.Youquiz.dto.student.StudentEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizEmbeddedDto;
import ahmed.foudi.Youquiz.dto.answervalidation.AnswerValidationEmbeddedDto;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class QuizAssignmentResponseDto {
    private StudentEmbeddedDto student;
    private QuizEmbeddedDto quiz;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private int attempts;
    private double score;
    private double result;
    private List<AnswerValidationEmbeddedDto> answerValidations;
} 