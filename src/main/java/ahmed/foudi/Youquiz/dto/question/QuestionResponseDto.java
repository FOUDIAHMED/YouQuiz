package ahmed.foudi.Youquiz.dto.question;

import ahmed.foudi.Youquiz.dto.subject.SubjectEmbeddedDto;
import ahmed.foudi.Youquiz.entities.QuestionType;
import lombok.Data;

@Data
public class QuestionResponseDto {
    private Long id;
    private String question;
    private int answers;
    private int correctAnswers;
    private QuestionType questionType;
    private SubjectEmbeddedDto subject;
} 