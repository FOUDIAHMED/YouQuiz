package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Duration duration;
    private double score;
    private boolean canSeeAnswers;
    private boolean canSeeResult;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "formateur_id", nullable = false)
    private Formateur formateur;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
    private List<QuizAssignement> quizAssignements;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
    private List<QuizQuestion> quizQuestions;

}
