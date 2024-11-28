package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
} 