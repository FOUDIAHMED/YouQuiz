package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
} 