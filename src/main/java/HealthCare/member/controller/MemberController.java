package HealthCare.member.controller;

import HealthCare.member.dto.MemberPatchDto;
import HealthCare.member.dto.MemberPostDto;
import HealthCare.member.entity.Member;
import HealthCare.member.mapper.MemberMapper;
import HealthCare.member.repository.MemberRepository;
import HealthCare.member.server.MemberServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@Validated
@RequiredArgsConstructor
public class MemberController {

    private final MemberServer memberServer;
    private final MemberMapper memberMapper;

    @PostMapping("/signUp")
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto){

        Member member=memberServer.createMember(
                memberMapper.memberPostDtoTomember(memberPostDto));

        return new ResponseEntity<>(memberMapper.memberTomemberResponseDto(member), HttpStatus.CREATED);
    }

    @PatchMapping("/updateMember/{memberName}")
    public ResponseEntity patchMember(@PathVariable("memberName") String memberName,
                                        @RequestBody MemberPatchDto memberPatchDto){
        Member member=memberServer.updateMember(memberName,
                memberMapper.memberPatchDtoTomember(memberPatchDto));

        return new ResponseEntity<>(memberMapper.memberTomemberResponseDto(member), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(){
        List<Member> members=memberServer.findMembers();

        return new ResponseEntity<>(memberMapper.membersTomemberResponseDtos(members), HttpStatus.OK);

    }

    @GetMapping("{memberName}")
    public ResponseEntity getMember(@PathVariable("memberName") String memberName){

        Member member=memberServer.findMember(memberName);

        return new ResponseEntity<>(memberMapper.memberTomemberResponseDto(member), HttpStatus.OK);

    }

    @DeleteMapping("{memberName}")
    public ResponseEntity deleteMember(@PathVariable("memberName") String memberName){

        memberServer.deleteMember(memberName);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}