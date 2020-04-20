package com.occamsrazor.web.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //URL을 처리하는 컨트롤러
public class MemberController {
	public MemberService memberService;
	
	@PostMapping("/join")
	public Member add(@RequestBody Member member) {
		System.out.println(">>>>");
		System.out.println(member.toString());
		memberService = new MemberServiceImpl();
		memberService.add(member);
		return member;
	}
}
