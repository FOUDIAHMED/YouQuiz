package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Formateur extends User {

    private String Specialite;
    @OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Quiz> quizzes;

}
