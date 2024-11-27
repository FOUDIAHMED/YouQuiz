package ahmed.foudi.Youquiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

//@EqualsAndHashCode(callSuper=true)
@Entity
@Data
@Table(name = "student")
//@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User {
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<QuizAssignement> quizAssignements;

}
