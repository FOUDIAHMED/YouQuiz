package ahmed.foudi.Youquiz.dto.subject;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import lombok.Data;

import java.util.List;

@Data
public class SubjectResponseDto {
    private Long id;
    private String title;
    private SubjectEmbeddedDto parentSubject;
    private List<SubjectEmbeddedDto> subSubjects;
    private List<QuestionEmbeddedDto> questions;
} 