package ahmed.foudi.Youquiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper=true)
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "formateur")
@PrimaryKeyJoinColumn(name = "formateur_id")
public class Formateur extends User {

    private String Specialite;
    @OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Quiz> quizzes;

}
