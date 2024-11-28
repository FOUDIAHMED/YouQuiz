package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.AnswerValidation;
import ahmed.foudi.Youquiz.entities.embedded.AnswerValidationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerValidationRepository extends JpaRepository<AnswerValidation, AnswerValidationKey> {
} 