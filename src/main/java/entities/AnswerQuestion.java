package entities;

import entities.embedded.AnswerQuestionKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class AnswerQuestion {
    @EmbeddedId
    private AnswerQuestionKey id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    private Answer answer;

    private double point;

}
