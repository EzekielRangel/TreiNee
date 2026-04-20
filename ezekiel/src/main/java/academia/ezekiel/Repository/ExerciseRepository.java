package academia.ezekiel.Repository;

import academia.ezekiel.Modal.Exercise;
import academia.ezekiel.Modal.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByTrainingDay(TrainingDay trainingDay);

    List<Exercise> findByTrainingDayId(Long trainingDayId);
}