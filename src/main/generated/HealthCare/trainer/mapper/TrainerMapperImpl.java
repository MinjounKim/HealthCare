package HealthCare.trainer.mapper;

import HealthCare.trainer.dto.TrainerPostDto;
import HealthCare.trainer.dto.TrainerResponseDto;
import HealthCare.trainer.entity.Trainer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-28T18:35:36+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TrainerMapperImpl implements TrainerMapper {

    @Override
    public Trainer TrainerPostDtoToTrainer(TrainerPostDto trainerPostDto) {
        if ( trainerPostDto == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setTrainerName( trainerPostDto.getTrainerName() );
        trainer.setTrainerPassWord( trainerPostDto.getTrainerPassWord() );
        trainer.setTrainerEmail( trainerPostDto.getTrainerEmail() );
        trainer.setTrainerPhone( trainerPostDto.getTrainerPhone() );

        return trainer;
    }

    @Override
    public TrainerResponseDto TrainerToTrainerResponseDto(Trainer trainer) {
        if ( trainer == null ) {
            return null;
        }

        TrainerResponseDto.TrainerResponseDtoBuilder trainerResponseDto = TrainerResponseDto.builder();

        trainerResponseDto.trainerName( trainer.getTrainerName() );
        trainerResponseDto.trainerEmail( trainer.getTrainerEmail() );
        trainerResponseDto.trainerPhone( trainer.getTrainerPhone() );

        return trainerResponseDto.build();
    }
}
