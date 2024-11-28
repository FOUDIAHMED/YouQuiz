package ahmed.foudi.Youquiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formateur extends User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;


    private String specialite;
    
    @OneToMany(mappedBy = "formateur")
    private List<Quiz> quizzes;
}
