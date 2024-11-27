package ahmed.foudi.Youquiz.dto.question;

import ahmed.foudi.Youquiz.entities.QuestionType;
import lombok.Data;

@Data
public class QuestionEmbeddedDto {
    private Long id;
    private String question;
    private QuestionType questionType;
} 