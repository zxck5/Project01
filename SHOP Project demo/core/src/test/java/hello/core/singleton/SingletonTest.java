package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {


    @Test
    @DisplayName("pure container")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("singleton")
    void singleTon() {
        Singleton.setInstance();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Assertions.assertThat(s1).isSameAs(s2);

    }

    @Test
    @DisplayName("spring container")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService m1 = ac.getBean("memberService", MemberService.class);
        MemberService m2 = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(m1).isSameAs(m2);

    }

}
