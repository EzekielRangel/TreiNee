package academia.ezekiel.Controller;

import academia.ezekiel.Modal.Exercise;
import academia.ezekiel.Service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> findById(@PathVariable Long id){
        return ResponseEntity.ok(exerciseService.findById(id));
    }

    @GetMapping("/training-day/{trainingDayId}")
    public ResponseEntity<List<Exercise>> findByTrainingDayId(@PathVariable Long trainingDayId){
        return ResponseEntity.ok(exerciseService.findByTrainingDayId(trainingDayId));
    }

    @PostMapping
    public ResponseEntity<Exercise> save(@RequestBody Exercise exercise){
        return ResponseEntity.ok(exerciseService.save(exercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

