package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    MemberRepository memoryMemberRepository = new MemoryMemberRepository();

    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository);
    }

    public OrderService orderService() {
        DiscountPolicy discountPolicy = new FixDiscountPolicy();

        return new OrderServiceImpl(memoryMemberRepository, discountPolicy);
    }
}
