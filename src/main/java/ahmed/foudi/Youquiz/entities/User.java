package ahmed.foudi.Youquiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@MappedSuperclass
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class User {

    protected String nom;

    protected String prenom;

    protected String adresse;

    protected LocalDate dateNaissance;
}
