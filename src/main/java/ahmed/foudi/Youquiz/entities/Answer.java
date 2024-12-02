package ahmed.foudi.Youquiz.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;



    @OneToMany(mappedBy = "answer",fetch = FetchType.EAGER)
    private List<AnswerQuestion> answerQuestions;

    @OneToMany(mappedBy = "answer",fetch = FetchType.EAGER)
    private List<AnswerValidation> answerValidations;

}
