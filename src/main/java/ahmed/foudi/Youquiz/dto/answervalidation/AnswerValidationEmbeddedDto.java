package ahmed.foudi.Youquiz.dto.answervalidation;

import lombok.Data;

@Data
public class AnswerValidationEmbeddedDto {
    private Long questionId;
    private Long answerId;
    private double points;
} 