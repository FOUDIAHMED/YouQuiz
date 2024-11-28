package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.AnswerQuestion;
import ahmed.foudi.Youquiz.entities.embedded.AnswerQuestionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, AnswerQuestionKey> {
} 