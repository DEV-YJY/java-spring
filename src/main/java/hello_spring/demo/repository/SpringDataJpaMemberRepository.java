package hello_spring.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello_spring.demo.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	@Override
	Optional<Member> findByName(String name);
}
