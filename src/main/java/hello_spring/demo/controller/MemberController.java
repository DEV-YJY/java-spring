package hello_spring.demo.controller;

import java.util.List;

import hello_spring.demo.domain.Member;
import hello_spring.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	 private final MemberService memberService;

	 @Autowired
	 public MemberController(MemberService memberservice) {
		 this.memberService = memberservice;
	 }

	@GetMapping("/members/new")
	public String createForm() {
		 return "members/createMemberForm";
	 }

	 // triggered by the form submit
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		 Member member = new Member();
		 member.setName(form.getName());
		 memberService.join(member);

		 return "redirect:/";
	 }

	@GetMapping("/members")
	public String list(Model model) {
		 List<Member> members = memberService.findMembers();
		 model.addAttribute("members", members);
		 return "members/memberList";
	 }
}
