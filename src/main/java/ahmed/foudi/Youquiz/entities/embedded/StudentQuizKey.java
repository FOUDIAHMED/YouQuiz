package ahmed.foudi.Youquiz.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class StudentQuizKey {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "quiz_id")
    Long quizId;
}
