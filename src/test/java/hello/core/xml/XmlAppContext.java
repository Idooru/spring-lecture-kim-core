package hello.core.xml;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        final ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        final Object bean = ac.getBean("discountPolicy", DiscountPolicy.class);
        final RateDiscountPolicy rateDiscountPolicy = (RateDiscountPolicy) bean;

        final Member member = new Member(1L, "shlee", Grade.VIP);
        final int discount = rateDiscountPolicy.discount(member, 20000);
        assertThat(discount).isEqualTo(2000);
    }
}
