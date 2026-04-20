package academia.ezekiel.Service;

import academia.ezekiel.Modal.WorkoutLog;
import academia.ezekiel.Repository.WorkoutLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutLogService {

    private final WorkoutLogRepository workoutLogRepository;

    public WorkoutLog save(WorkoutLog workoutLog) {
        workoutLog.setDate(LocalDate.now());
        return workoutLogRepository.save(workoutLog);
    }

    public WorkoutLog update(Long id, WorkoutLog workoutLog) {
        WorkoutLog existing = workoutLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkoutLog not found with id: " + id));
        existing.setSeries(workoutLog.getSeries());
        existing.setReps(workoutLog.getReps());
        existing.setWeight(workoutLog.getWeight());
        existing.setObs(workoutLog.getObs());
        existing.setDone(workoutLog.getDone());
        return workoutLogRepository.save(existing);
    }

    public List<WorkoutLog> findByUserId(Long userId) {
        return workoutLogRepository.findByUserId(userId);
    }

    public List<WorkoutLog> findByUserIdAndTrainingDayId(Long userId, Long trainingDayId) {
        return workoutLogRepository.findByUserIdAndExerciseTrainingDayId(userId, trainingDayId);
    }

    public WorkoutLog findByUserIdAndExerciseId(Long userId, Long exerciseId) {
        return workoutLogRepository.findByUserIdAndExerciseId(userId, exerciseId)
                .orElseThrow(() -> new RuntimeException("WorkoutLog not found"));
    }

    public void delete(Long id) {
        workoutLogRepository.deleteById(id);
    }
}