package ahmed.foudi.Youquiz.dto.answer;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import lombok.Data;

@Data
public class AnswerResponseDto {
    private Long id;
    private String answer;
    private QuestionEmbeddedDto question;
} 