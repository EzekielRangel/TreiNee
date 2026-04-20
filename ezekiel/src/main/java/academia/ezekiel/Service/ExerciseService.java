package academia.ezekiel.Service;

import academia.ezekiel.Modal.Exercise;
import academia.ezekiel.Modal.TrainingDay;
import academia.ezekiel.Repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final TrainingDayService trainingDayService;

    public Exercise findById(Long id) {
        return exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found with id: " + id));
    }

    public List<Exercise> findByTrainingDayId(Long trainingDayId) {
        return exerciseRepository.findByTrainingDayId(trainingDayId);
    }

    public List<Exercise> findByTrainingDay(TrainingDay trainingDay) {
        return exerciseRepository.findByTrainingDay(trainingDay);
    }

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void delete(Long id){
        exerciseRepository.deleteById(id);
    }
}
