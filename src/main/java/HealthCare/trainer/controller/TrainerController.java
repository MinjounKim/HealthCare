package HealthCare.trainer.controller;

import HealthCare.trainer.dto.TrainerLoginDto;
import HealthCare.trainer.dto.TrainerPatchDto;
import HealthCare.trainer.dto.TrainerPostDto;
import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.mapper.TrainerMapper;
import HealthCare.trainer.repository.TrainerRepository;
import HealthCare.trainer.server.TrainerServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

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

    @PatchMapping("/updateTrainer/{TrainerName}")
    public ResponseEntity patchTrainer(@PathVariable("TrainerName") String trainerName,
                                        @RequestBody TrainerPatchDto trainerPatchDto){

        Trainer trainer=trainerServer.updateTrainer(trainerName,
                trainerMapper.TrainerPatchDtoToTrainer(trainerPatchDto));

        return new ResponseEntity<>(trainerMapper.TrainerToTrainerResponseDto(trainer), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity loginTrainer(@RequestBody TrainerLoginDto trainerLoginDto){

        Trainer trainer=trainerServer.LoginTrainer(
                trainerLoginDto.getTrainerName(),trainerLoginDto.getTrainerPassWord());

        return new ResponseEntity<>(trainerMapper.TrainerToTrainerResponseDto(trainer), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity getTrainers(){
        List<Trainer> trainers=trainerServer.findTrainers();

        return new ResponseEntity<>(trainerMapper.TrainersToTrainerResponseDtos(trainers), HttpStatus.OK);

    }

    @GetMapping("{TrainerName}")
    public ResponseEntity getTrainer(@PathVariable("TrainerName") String trainerName){

        Trainer trainer=trainerServer.findTrainer(trainerName);

        return new ResponseEntity<>(trainerMapper.TrainerToTrainerResponseDto(trainer), HttpStatus.OK);

    }

    @DeleteMapping("{TrainerName}")
    public ResponseEntity deleteTrainer(@PathVariable("TrainerName") String trainerName){

        trainerServer.deleteTrainer(trainerName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
