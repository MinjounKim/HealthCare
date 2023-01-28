package HealthCare.trainer.server;

import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TrainerServer {

    private final TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer trainer){

        trainer.setTrainerSignUp(LocalDate.now());

        return trainerRepository.save(trainer);
    }
}
