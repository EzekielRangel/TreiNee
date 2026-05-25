package academia.ezekiel.Repository;

import academia.ezekiel.Modal.Exercise;
import academia.ezekiel.Modal.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByTrainingDay(TrainingDay trainingDay);

    List<Exercise> findByTrainingDayId(Long trainingDayId);

    List<Exercise> findByTrainingDayIdAndUserId(Long trainingDayId, Long userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM exercises WHERE id = :id", nativeQuery = true)
    void deleteNativeById(@Param("id") Long id);
}
