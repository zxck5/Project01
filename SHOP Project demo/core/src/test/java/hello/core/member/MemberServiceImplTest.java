package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    private MemberService memberService;
    private MemberRepository repository;
    @BeforeEach
    void beforeEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(repository);
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
    }

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void join() {
        //given
        Member m = new Member(1L,"mem",Grade.VIP);

        // when
        memberService.join(m);
        Member findMem = memberService.findMember(1L);

        // then
        Assertions.assertThat(m).isEqualTo(findMem);
    }



}