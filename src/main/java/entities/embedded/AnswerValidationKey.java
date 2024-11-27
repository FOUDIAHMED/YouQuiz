package entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AnswerValidationKey {
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "answer_id")
    private Long answerId;
}
