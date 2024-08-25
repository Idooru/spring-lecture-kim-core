package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        // given
        Long memberId = 1L;

        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        // when
        final Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
