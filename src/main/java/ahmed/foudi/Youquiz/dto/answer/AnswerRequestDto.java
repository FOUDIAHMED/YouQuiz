package ahmed.foudi.Youquiz.dto.answer;

import lombok.Data;

@Data
public class AnswerRequestDto {
    private String answer;
    private Long questionId;
    private double points;
} 