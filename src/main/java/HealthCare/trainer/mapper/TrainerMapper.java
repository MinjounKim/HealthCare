package HealthCare.trainer.mapper;

import HealthCare.trainer.dto.TrainerPatchDto;
import HealthCare.trainer.dto.TrainerPostDto;
import HealthCare.trainer.dto.TrainerResponseDto;
import HealthCare.trainer.entity.Trainer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    Trainer TrainerPostDtoToTrainer(TrainerPostDto trainerPostDto);

    TrainerResponseDto TrainerToTrainerResponseDto(Trainer trainer);

    Trainer TrainerPatchDtoToTrainer(TrainerPatchDto trainerPatchDto);

    List<TrainerResponseDto> TrainersToTrainerResponseDtos(List<Trainer> trainers);
}
