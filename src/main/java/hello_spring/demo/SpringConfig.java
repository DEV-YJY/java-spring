package hello_spring.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello_spring.demo.repository.JdbcTemplateMemberRepository;
import hello_spring.demo.repository.MemberRepository;
import hello_spring.demo.repository.MemoryMemberRepository;
import hello_spring.demo.service.MemberService;

@Configuration
public class SpringConfig {

	private final DataSource dataSource;

	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		// return new MemoryMemberRepository();
		return new JdbcTemplateMemberRepository(dataSource);
	}
}
