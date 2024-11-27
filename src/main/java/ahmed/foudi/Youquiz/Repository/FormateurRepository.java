package ahmed.foudi.Youquiz.repository;

import ahmed.foudi.Youquiz.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
} 