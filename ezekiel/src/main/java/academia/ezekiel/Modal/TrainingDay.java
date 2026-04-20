package academia.ezekiel.Modal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "training_day")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private WeekDay weekDay;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "trainingDay", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exercise> exercises;

    public enum WeekDay{
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }
}
