package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.QuizQuestion;
import ahmed.foudi.Youquiz.entities.embedded.QuizQuestionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, QuizQuestionKey> {
} 