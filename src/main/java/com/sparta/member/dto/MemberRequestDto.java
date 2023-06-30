package com.sparta.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {
    private Long id;
    private String name;
    private String email;
    private String pw;
}
