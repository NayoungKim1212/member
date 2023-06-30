package com.sparta.member.Controller;

import com.sparta.member.dto.MemberRequestDto;
import com.sparta.member.dto.MemberResponseDto;
import com.sparta.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;



    @GetMapping("/member")
    public List<MemberResponseDto> getMemberList() {
        return memberService.findAllMember();
    }

    @GetMapping("member/{id}")
    public MemberResponseDto getMembersByID(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }
    @PostMapping("/member")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto memberRequestDto) {
        return memberService.createMember(memberRequestDto);
    }
}
