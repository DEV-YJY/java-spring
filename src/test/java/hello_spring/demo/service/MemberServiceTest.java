package hello_spring.demo.service;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello_spring.demo.domain.Member;
import hello_spring.demo.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	// dependency injection
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void memberSignIn() {
		// given
		Member member = new Member();
		member.setName("YJ");

		// when
		Long savedId = memberService.join(member);

		// then
		Member savedMember = memberService.findOne(savedId).get();
		assertThat(savedMember.getName()).isEqualTo(member.getName());
	}

	@Test
	public void duplicatedMemberException() {
		// given
		Member member1 = new Member();
		member1.setName("YJ");

		Member member2 = new Member();
		member2.setName("YJ");

		// when
		memberService.join(member1);
		IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));

		assertThat(e.getMessage()).isEqualTo("The member already exists");
		// try {
		// 	memberService.join(member2);
		// 	fail();
		// } catch (IllegalStateException e) {
		// 	Assertions.assertThat(e.getMessage()).isEqualTo("The member already exists");
		// }

		// then
	}

	@Test
	void findMembers() {
	}

	@Test
	void findOne() {
	}
}