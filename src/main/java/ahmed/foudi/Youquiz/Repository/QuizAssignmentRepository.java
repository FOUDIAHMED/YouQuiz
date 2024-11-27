package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.QuizAssignement;
import ahmed.foudi.Youquiz.entities.embedded.StudentQuizKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAssignmentRepository extends JpaRepository<QuizAssignement, StudentQuizKey> {
} 