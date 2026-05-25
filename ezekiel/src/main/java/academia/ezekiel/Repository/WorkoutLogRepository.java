package academia.ezekiel.Repository;

import academia.ezekiel.Modal.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {

    List<WorkoutLog> findByUserId(Long userId);

    List<WorkoutLog> findByUserIdAndExerciseTrainingDayId(Long userId, Long trainingDayId);

    Optional<WorkoutLog> findByUserIdAndExerciseId(Long userId, Long exerciseId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("DELETE FROM WorkoutLog w WHERE w.exercise.id = :exerciseId")
    void deleteByExerciseId(@Param("exerciseId") Long exerciseId);
}
