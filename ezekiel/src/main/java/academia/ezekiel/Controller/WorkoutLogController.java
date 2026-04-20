package academia.ezekiel.Controller;

import academia.ezekiel.Modal.WorkoutLog;
import academia.ezekiel.Service.WorkoutLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout-logs")
@RequiredArgsConstructor
public class WorkoutLogController {

    private final WorkoutLogService workoutLogService;

    @PostMapping
    public ResponseEntity<WorkoutLog> save(@RequestBody WorkoutLog workoutLog) {
        return ResponseEntity.ok(workoutLogService.save(workoutLog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutLog> update(@PathVariable Long id, @RequestBody WorkoutLog workoutLog) {
        return ResponseEntity.ok(workoutLogService.update(id, workoutLog));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutLog>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutLogService.findByUserId(userId));
    }

    @GetMapping("/user/{userId}/training-day/{trainingDayId}")
    public ResponseEntity<List<WorkoutLog>> findByUserAndTrainingDay(
            @PathVariable Long userId,
            @PathVariable Long trainingDayId) {
        return ResponseEntity.ok(workoutLogService.findByUserIdAndTrainingDayId(userId, trainingDayId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workoutLogService.delete(id);
        return ResponseEntity.noContent().build();
    }
}