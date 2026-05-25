 package academia.ezekiel.Config;

import academia.ezekiel.Modal.TrainingDay;
import academia.ezekiel.Repository.TrainingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final TrainingDayRepository trainingDayRepository;

    @Override
    public void run(String... args) {
        seedDay(TrainingDay.WeekDay.SEGUNDA, "Braço e Ombro");
        seedDay(TrainingDay.WeekDay.QUARTA,  "Peito e Costa");
        seedDay(TrainingDay.WeekDay.QUINTA,  "Perna");
        seedDay(TrainingDay.WeekDay.SEXTA,   "Upper");
        seedDay(TrainingDay.WeekDay.SABADO,  "Pernas");
    }

    private void seedDay(TrainingDay.WeekDay weekDay, String description) {
        if (trainingDayRepository.findByWeekDay(weekDay).isEmpty()) {
            trainingDayRepository.save(
                    TrainingDay.builder()
                            .weekDay(weekDay)
                            .description(description)
                            .build()
            );
        }
    }
}