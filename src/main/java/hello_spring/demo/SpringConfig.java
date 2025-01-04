package hello_spring.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello_spring.demo.repository.JdbcTemplateMemberRepository;
import hello_spring.demo.repository.JpaMemberRepository;
import hello_spring.demo.repository.MemberRepository;
import hello_spring.demo.repository.MemoryMemberRepository;
import hello_spring.demo.service.MemberService;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

	// private final DataSource dataSource;
	// private EntityManager em;
	private final MemberRepository memberRepository;

	// @Autowired
	// public SpringConfig(DataSource dataSource) {
	// 	this.dataSource = dataSource;
	// }
	// public SpringConfig(EntityManager em) {
	// 	this.em = em;
	// }
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	// @Bean
	// public MemberRepository memberRepository() {
		// return new MemoryMemberRepository();
		// return new JdbcTemplateMemberRepository(dataSource);
		// return new JpaMemberRepository(em);
	// }
}
