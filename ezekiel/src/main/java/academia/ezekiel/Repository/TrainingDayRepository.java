package academia.ezekiel.Repository;

import academia.ezekiel.Modal.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;

@Repository
public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long>{

    Optional<TrainingDay> findByWeekDay(TrainingDay.WeekDay weekDay);
}
