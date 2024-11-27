package ahmed.foudi.Youquiz.dto.subject;

import lombok.Data;

@Data
public class SubjectRequestDto {
    private String title;
    private Long parentSubjectId;
} 