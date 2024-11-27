package ahmed.foudi.Youquiz.dto.answervalidation;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentEmbeddedDto;
import lombok.Data;

import java.util.List;

@Data
public class AnswerValidationResponseDto {
    private QuestionEmbeddedDto question;
    private AnswerEmbeddedDto answer;
    private double points;
    private List<QuizAssignmentEmbeddedDto> quizAssignments;
} 