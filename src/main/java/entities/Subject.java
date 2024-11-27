package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "parentSubject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> subSubjects;

    @ManyToOne
    @JoinColumn(name = "parent_subject_id")
    private Subject parentSubject;


    @OneToMany(mappedBy = "subject" ,fetch = FetchType.EAGER)
    private List<Question> questions;
}
