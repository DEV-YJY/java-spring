package hello_spring.demo.service;

import java.util.List;
import java.util.Optional;

import hello_spring.demo.domain.Member;
import hello_spring.demo.repository.MemberRepository;
import hello_spring.demo.repository.MemoryMemberRepository;

public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/**
	 * member sign in
	 */
	public Long join(Member member)	{
		validateExistingMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateExistingMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("The member already exists");
			});
	}

	/**
	 * view all members
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long id) {
		return memberRepository.findById(id);
	}
}
