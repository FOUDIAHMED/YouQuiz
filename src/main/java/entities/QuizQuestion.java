package entities;

import entities.embedded.QuizQuestionKey;
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
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Quiz student;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

}
