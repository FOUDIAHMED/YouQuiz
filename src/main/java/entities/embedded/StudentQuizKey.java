package entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentQuizKey {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "quiz_id")
    Long quizId;
}
