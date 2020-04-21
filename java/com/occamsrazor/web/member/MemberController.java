package com.occamsrazor.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController //URL을 처리하는 컨트롤러
@RequestMapping("/member")
public class MemberController {
	//new Member() - MemberServicreImpl에 @Service.
	@Autowired MemberService memberService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {
		int current =memberService.count();
		memberService.add(member);
		return (memberService.count()==(current+1))? Messenger.SUCCESS : Messenger.FAIL;
	}
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		return (memberService.login(member))? Messenger.SUCCESS : Messenger.FAIL;
	}
	@GetMapping("/list")
	public Member[] list() {
		Member[] members = new Member[5];
		return members;
	}
	@GetMapping("/detail")
	public Member detail(@RequestBody String userid) {
		Member detail = new Member();
		return detail;
	}
	@GetMapping("/count")
	public int count() {
		int count = 0;
		return count;
	}
}
