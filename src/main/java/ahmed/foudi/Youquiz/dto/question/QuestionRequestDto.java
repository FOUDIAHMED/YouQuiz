package ahmed.foudi.Youquiz.dto.question;

import ahmed.foudi.Youquiz.entities.QuestionType;
import lombok.Data;

@Data
public class QuestionRequestDto {
    private String question;
    private int answers;
    private int correctAnswers;
    private QuestionType questionType;
    private Long subjectId;
}