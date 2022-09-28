package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    private OrderService orderService;
//    private MemberService memberService;
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();

//        memberService = new MemberServiceImpl(memberRepository);
        discountPolicy = new FixDiscountPolicy();
        orderService = new OrderServiceImpl(memberRepository,discountPolicy);
    }
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void createOrder() {
        //given
        Member mem = new Member(1L,"jiwon", Grade.VIP);
        memberRepository.save(mem);

        //when
        Order o1 = orderService.createOrder(mem.getId(),"itemName1",10000);

        //then
        System.out.println(o1);

        org.assertj.core.api.Assertions.assertThat(o1.calculatePrice()).isEqualTo(9000);
    }

    @Test
    void test() {
        MemoryMemberRepository memberRepository1 = new MemoryMemberRepository();
        memberRepository1.save(new Member(1L, "Jiwon", Grade.VIP));
        OrderServiceImpl orderService1 = new OrderServiceImpl(memberRepository1, new FixDiscountPolicy());
        Order o1 = orderService1.createOrder(1L,"Item",100000);
        System.out.println("test = " + o1.getDiscountPrice());


    }

}