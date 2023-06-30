package com.sparta.member.service;

import com.sparta.member.dto.MemberRequestDto;
import com.sparta.member.dto.MemberResponseDto;
import com.sparta.member.entity.Member;
import com.sparta.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public List<MemberResponseDto> findAllMember() {
        return memberRepository.findAll().stream().map(MemberResponseDto::new).toList();
    }

    public MemberResponseDto getMemberById(Long id) {
        return new MemberResponseDto(findMember(id));
    }
    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() ->
                new NullPointerException("회원 상세 조회 실패"));
    }
    public MemberResponseDto createMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);

        Member saveMember = memberRepository.save(member);

        return new MemberResponseDto(member);
    }

}
