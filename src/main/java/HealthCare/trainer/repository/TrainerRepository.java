package HealthCare.trainer.repository;

import HealthCare.trainer.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Trainer findByTrainerName(String trainerName);

    Trainer findByTrainerPhone(String trainerPhone);
}
