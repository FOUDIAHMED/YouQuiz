package ahmed.foudi.Youquiz.entities;

import ahmed.foudi.Youquiz.entities.embedded.StudentQuizKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class QuizAssignement {
    @EmbeddedId
    private StudentQuizKey id;

    private String reason;

    private LocalDate startDate;
    private LocalDate endDate;
    private int attempts;
    public double score;
    public double result;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AnswerValidation> answerValidations;
}
