package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student extends User {
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<QuizAssignement> quizAssignements;

}
