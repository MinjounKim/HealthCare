package HealthCare.trainer.server;

import HealthCare.exception.BusinessLogicException;
import HealthCare.exception.ExceptionCode;
import HealthCare.trainer.entity.Trainer;
import HealthCare.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServer {

    private final TrainerRepository trainerRepository;

    private final PasswordEncoder passwordEncoder;

    public Trainer createTrainer(Trainer trainer){

        // 트레이너가 이미 있는 경우 예외처리
        // 이름은 중복허용, 번호는 중복되는 경우는 없으니 번호로 중복 체크
        if(trainerRepository.findByTrainerPhone(trainer.getTrainerPhone())!=null){
            throw new BusinessLogicException(ExceptionCode.TRAINER_EXISTS);
        }

        trainer.setTrainerPassWord(passwordEncoder.encode(trainer.getTrainerPassWord()));
        trainer.setTrainerSignUp(LocalDate.now());


        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(String trainerName, Trainer trainer){

        Trainer updateTrainer=trainerRepository.findByTrainerName(trainerName);

        if(updateTrainer==null){
            throw new BusinessLogicException(ExceptionCode.Trainer_NOT_FOUND);
        }

        updateTrainer.setTrainerName(trainer.getTrainerName());

        updateTrainer.setTrainerEmail(trainer.getTrainerEmail());

        updateTrainer.setTrainerPhone(trainer.getTrainerPhone());

        updateTrainer.setTrainerPassWord(trainer.getTrainerPassWord());


        return trainerRepository.save(updateTrainer);

    }

    public Trainer LoginTrainer(String trainerName,String trainerPassWord){

        Trainer trainer=trainerRepository.findByTrainerName(trainerName);
        if(trainer==null){
            throw new BusinessLogicException(ExceptionCode.Trainer_NOT_FOUND);
        }

        if(!passwordEncoder.matches(trainerPassWord,trainer.getTrainerPassWord())){
            throw new BusinessLogicException(ExceptionCode.PASSWORD_NO_MATCH);
        }

        /////////////////////////////////////////
        // 토큰 생성


        /////////////////////////////////////////

        return trainer;
    }

    public List<Trainer> findTrainers(){

        return trainerRepository.findAll();
    }

    public Trainer findTrainer(String TrainerName){

        if(trainerRepository.findByTrainerName(TrainerName)==null){
            throw new BusinessLogicException(ExceptionCode.Trainer_NOT_FOUND);
        }

        return trainerRepository.findByTrainerName(TrainerName);
    }

    public void deleteTrainer(String TrainerName){

        Trainer trainer=trainerRepository.findByTrainerName(TrainerName);

        if(trainer==null){
            throw new BusinessLogicException(ExceptionCode.Trainer_NOT_FOUND);
        }

        trainerRepository.delete(trainer);
    }
}
