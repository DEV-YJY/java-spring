package hello_spring.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello_spring.demo.domain.Member;
import hello_spring.demo.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void signIn() throws Exception {
		// Given
		Member member = new Member();
		member.setName("hello");

		// When
		Long saveId = memberService.join(member);

		// Then
		Member findMember = memberRepository.findById(saveId).get();
		Assertions.assertEquals(member.getName(), findMember.getName());
	}

	@Test
	public void dupMember() throws Exception {
		// Given
		Member member1 = new Member();
		member1.setName("spring");

		Member member2 = new Member();
		member2.setName("spring");

		// When
		memberService.join(member1);
		IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));

		// Then
		org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("The member already exists");
	}
}
