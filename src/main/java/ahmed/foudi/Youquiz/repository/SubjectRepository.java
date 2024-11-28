package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
} 