package ahmed.foudi.Youquiz.dto.subject;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class SubjectResponseDto {
    private Long id;
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SubjectEmbeddedDto parentSubject;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SubjectEmbeddedDto> subSubjects;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<QuestionEmbeddedDto> questions;
} 