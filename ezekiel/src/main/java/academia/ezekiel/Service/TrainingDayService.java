package academia.ezekiel.Service;

import academia.ezekiel.Modal.TrainingDay;
import academia.ezekiel.Repository.TrainingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;

    public TrainingDay findById(Long id) {
        return trainingDayRepository.findById(id).orElseThrow(() -> new RuntimeException("Training day not found with id " + id));
    }

    public TrainingDay findByWeekDay(TrainingDay.WeekDay weekDay) {
        return trainingDayRepository.findByWeekDay(weekDay).orElseThrow(() -> new RuntimeException("Training day not found: " + weekDay));
    }

    public List<TrainingDay> findAll(){
        return trainingDayRepository.findAll();
    }

    public TrainingDay save(TrainingDay trainingDay) {
        return trainingDayRepository.save(trainingDay);
    }

    public void delete(Long id){
        trainingDayRepository.deleteById(id);
    }
}
