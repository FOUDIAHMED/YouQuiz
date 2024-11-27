package ahmed.foudi.Youquiz.dto.answerquestion;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerEmbeddedDto;
import lombok.Data;

@Data
public class AnswerQuestionResponseDto {
    private QuestionEmbeddedDto question;
    private AnswerEmbeddedDto answer;
    private double point;
} 