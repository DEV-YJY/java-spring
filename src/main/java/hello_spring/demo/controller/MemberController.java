package hello_spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello_spring.demo.service.MemberService;

@Controller
public class MemberController {
	 private final MemberService memberService;

	 @Autowired
	 public MemberController(MemberService memberservice) {
		 this.memberService = memberservice;
	 }
}