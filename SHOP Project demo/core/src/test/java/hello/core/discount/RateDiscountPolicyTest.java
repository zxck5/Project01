package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    private DiscountPolicy discountPolicy;

    @Test
    @DisplayName("VIP should be 10 percent discount")
    void rateDiscountO() {
        // given
        discountPolicy = new RateDiscountPolicy();
        Member member = new Member(1L,"Jiwon", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    void rateDiscountX() {
        // given
        discountPolicy = new RateDiscountPolicy();
        Member member = new Member(2L,"Jiwon2", Grade.Basic);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);

    }


}