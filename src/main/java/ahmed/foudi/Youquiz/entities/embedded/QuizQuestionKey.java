package ahmed.foudi.Youquiz.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Embeddable
@Data
@RequiredArgsConstructor
public class QuizQuestionKey {
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "quiz_id")
    private Long quizId;
}
