package HealthCare.trainer.controller;

import HealthCare.trainer.dto.TrainerPostDto;
import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.mapper.TrainerMapper;
import HealthCare.trainer.server.TrainerServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainer")
@Validated
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerServer trainerServer;

    private final TrainerMapper trainerMapper;

    @PostMapping("/signUp")
    public ResponseEntity postTrainer(@RequestBody TrainerPostDto trainerPostDto){

        Trainer trainer=trainerServer.createTrainer(
                trainerMapper.TrainerPostDtoToTrainer(trainerPostDto));

        return new ResponseEntity<>(trainerMapper.TrainerToTrainerResponseDto(trainer), HttpStatus.CREATED);
    }

}
