package academia.ezekiel.Controller;

import academia.ezekiel.Modal.TrainingDay;
import academia.ezekiel.Service.TrainingDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/api/training-days")
@RequiredArgsConstructor
public class TrainingDayController {

    private final TrainingDayService trainingDayService;

    @GetMapping
    public ResponseEntity<List<TrainingDay>> findAll(){
        return ResponseEntity.ok(trainingDayService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDay> findById(@PathVariable Long id){
        return ResponseEntity.ok(trainingDayService.findById(id));
    }

    @GetMapping("/day/{weekDay}")
    public ResponseEntity<TrainingDay> findByWeekDay(@PathVariable TrainingDay.WeekDay weekDay){
        return ResponseEntity.ok(trainingDayService.findByWeekDay(weekDay));
    }

    @PostMapping
    public ResponseEntity<TrainingDay> save(@RequestBody TrainingDay trainingDay){
        return ResponseEntity.ok(trainingDayService.save(trainingDay));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        trainingDayService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

