package academia.ezekiel.Repository;

import academia.ezekiel.Modal.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {

    List<WorkoutLog> findByUserId(Long userId);

    List<WorkoutLog> findByUserIdAndExerciseTrainingDayId(Long userId, Long trainingDayId);

    Optional<WorkoutLog> findByUserIdAndExerciseId(Long userId, Long exerciseId);
}
