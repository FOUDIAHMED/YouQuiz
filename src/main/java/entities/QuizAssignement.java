package entities;

import entities.embedded.StudentQuizKey;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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


}
