package hello_spring.demo.repository;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello_spring.demo.domain.Member;

class MemoryMemberRepositoryTest {
	MemberRepository repository = new MemoryMemberRepository();

	@Test
	public void save() {
		Member member = new Member();
		member.setName("YJ");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		// junit
		// Assertions.assertEquals(result, member);

		// assertj
		assertThat(member).isEqualTo(result);
	}
}
