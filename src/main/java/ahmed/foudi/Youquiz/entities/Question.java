package ahmed.foudi.Youquiz.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private int answers;
    private int correctAnswers;
    private QuestionType questionType;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<QuizQuestion> quizQuestions;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<AnswerQuestion> answerQuestions;




    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


}
