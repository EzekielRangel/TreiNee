package academia.ezekiel.Controller;

import academia.ezekiel.Modal.Exercise;
import academia.ezekiel.Modal.User;
import academia.ezekiel.Service.ExerciseService;
import academia.ezekiel.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> findById(@PathVariable Long id){
        return ResponseEntity.ok(exerciseService.findById(id));
    }

    @GetMapping("/training-day/{trainingDayId}")
    public ResponseEntity<List<Exercise>> findByTrainingDayId(@PathVariable Long trainingDayId){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(exerciseService.findByTrainingDayId(trainingDayId, user.getId()));
    }

    @PostMapping
    public ResponseEntity<Exercise> save(@RequestBody Exercise exercise){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByEmail(email);
        exercise.setUser(user);
        return ResponseEntity.ok(exerciseService.save(exercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

