package com.codestates.mvc.member;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
public class MemberController {

    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-Geo-Location", "Korea,Seoul"); //test
        return new ResponseEntity<>(memberPostDto, headers, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        memberPatchDto.setName("홍길동2");

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId = " + memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(HttpServletResponse response) {
        response.addHeader("Client-Geo-Location", "Korea,Seoul");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
