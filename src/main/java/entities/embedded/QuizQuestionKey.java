package entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class QuizQuestionKey {
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "quiz_id")
    private Long quizId;
}
