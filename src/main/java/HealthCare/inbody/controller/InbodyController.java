package HealthCare.inbody.controller;

import HealthCare.inbody.dto.PostInbodyDto;
import HealthCare.inbody.entity.Inbody;
import HealthCare.inbody.mapper.InbodyMapper;
import HealthCare.inbody.server.InbodyServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inbody")
@Validated
@RequiredArgsConstructor
public class InbodyController {

    private final InbodyServer inbodyServer;

    private final InbodyMapper inbodyMapper;

    @PostMapping("/{memberName}")
    public ResponseEntity postMember(@PathVariable("memberName") String memberName,
                                     @RequestBody PostInbodyDto postInbodyDto){

        Inbody inbody=inbodyServer.measurementInbody(memberName,inbodyMapper.postInbodyDtoToInbody(postInbodyDto));

        return new ResponseEntity<>(inbodyMapper.inbodyToResponseInbodyDto(inbody), HttpStatus.OK);
    }

    @GetMapping("/{memberName}")
    public ResponseEntity getMemberInbodies(@PathVariable("memberName") String memberName){

        List<Inbody> inbodies=inbodyServer.getMemeberInbodies(memberName);

        return new ResponseEntity<>(inbodyMapper.inbodiesToResponseInbodyDtos(inbodies),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllInbodies(){

        List<Inbody> inbodies=inbodyServer.getInbodies();

        return new ResponseEntity<>(inbodyMapper.inbodiesToResponseInbodyDtos(inbodies),HttpStatus.OK);
    }

}
