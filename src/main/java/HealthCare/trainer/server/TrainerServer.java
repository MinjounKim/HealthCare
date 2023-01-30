package HealthCare.trainer.server;

import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServer {

    private final TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer trainer){

        trainer.setTrainerSignUp(LocalDate.now());

        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(String trainerName, Trainer trainer){

        Trainer updateTrainer=trainerRepository.findByTrainerName(trainerName);

        updateTrainer.setTrainerName(trainer.getTrainerName());

        updateTrainer.setTrainerEmail(trainer.getTrainerEmail());

        updateTrainer.setTrainerPhone(trainer.getTrainerPhone());

        updateTrainer.setTrainerPassWord(trainer.getTrainerPassWord());


        return trainerRepository.save(updateTrainer);

    }

    public List<Trainer> findTrainers(){

        return trainerRepository.findAll();
    }

    public Trainer findTrainer(String TrainerName){

        return trainerRepository.findByTrainerName(TrainerName);
    }

    public void deleteTrainer(String TrainerName){

        Trainer trainer=trainerRepository.findByTrainerName(TrainerName);
        trainerRepository.delete(trainer);
    }
}
