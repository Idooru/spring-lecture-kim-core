package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용돠어야 한다.")
    void vip_o() {
        // given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.VIP);

        // when
        final int memberADiscount = discountPolicy.discount(memberA, 10000);
        final int memberBDiscount = discountPolicy.discount(memberB, 20000);

        // then
        assertThat(memberADiscount).isEqualTo(1000);
        assertThat(memberBDiscount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given
        Member memberA = new Member(1L, "memberA", Grade.BASIC);

        // when
        final int memberADiscount = discountPolicy.discount(memberA, 10000);

        // then
        assertThat(memberADiscount).isEqualTo(0);
    }
}
