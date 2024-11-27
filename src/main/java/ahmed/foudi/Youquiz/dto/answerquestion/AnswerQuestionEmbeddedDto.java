package ahmed.foudi.Youquiz.dto.answerquestion;

import lombok.Data;

@Data
public class AnswerQuestionEmbeddedDto {
    private Long questionId;
    private Long answerId;
    private double point;
} 