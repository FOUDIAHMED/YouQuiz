package ahmed.foudi.Youquiz.entities;

import ahmed.foudi.Youquiz.entities.embedded.AnswerValidationKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class AnswerValidation {
    @EmbeddedId
    private AnswerValidationKey id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne(fetch = FetchType.EAGER)
    private QuizAssignement quizAssignement;

    private double points;



}
