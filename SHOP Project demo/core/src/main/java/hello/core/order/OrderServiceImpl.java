package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{


//     constructor
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // field injection
    // cons : hard to test them in pure java codes.
//    @Autowired private MemberRepository memberRepository;
//    @Autowired  private DiscountPolicy discountPolicy;

    // for setters
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

//     setter injection
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.setMemberRepository(memberRepository);
//        this.setDiscountPolicy(discountPolicy);
//    }

    // method injection
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


//     construction injection
    // using Qualifier --> if there are two beans enrolled as component that implements same interface, we
    // can pick one by using Qualifier
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    // Another way of picking component of two beans which have same interface implemented.

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = rateDiscountPolicy;
//    }

// you can also use primary

    // using Annotation. We can manually design our own annotation
//    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        return new Order(memberId,itemName,itemPrice,discountPolicy.discount(memberRepository.findbyId(memberId), itemPrice));
    }
//     test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
