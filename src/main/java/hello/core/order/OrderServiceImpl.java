package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        final Member findMember = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(findMember, itemPrice); // raise null pointer exception

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}