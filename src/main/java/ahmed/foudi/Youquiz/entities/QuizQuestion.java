package ahmed.foudi.Youquiz.entities;

import ahmed.foudi.Youquiz.entities.embedded.QuizQuestionKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

@Entity
@Data
@RequiredArgsConstructor
public class QuizQuestion {
    @EmbeddedId
    QuizQuestionKey id;

    private Duration timer;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

}
