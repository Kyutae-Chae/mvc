package com.codestates.mvc.member.mapstruct.mapper;

import com.codestates.mvc.member.Member;
import com.codestates.mvc.member.MemberPatchDto;
import com.codestates.mvc.member.MemberPostDto;
import com.codestates.mvc.member.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);

    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);
}
